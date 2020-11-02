package com.verifly.smb.utils;

import android.app.Application;

import com.mark.quick.base_library.utils.android.Log;
import com.optimizely.ab.android.sdk.OptimizelyClient;
import com.optimizely.ab.android.sdk.OptimizelyManager;
import com.verifly.smb.BuildConfig;
import com.verifly.smb.R;
import com.verifly.smb.manager.SessionManager;
import com.verifly.smb.sharepreference.model.AccountPrefModel;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class ABUtils {

    private static ABUtils sInstance;

    private ABUtils() {
    }

    public static ABUtils getInstance() {
        synchronized (SessionManager.class) {
            if (sInstance == null) {
                sInstance = new ABUtils();
            }
        }
        return sInstance;
    }

    OptimizelyClient mSyncOptyClient;
    String mUserId;

    public ABUtils init(Application application) {

        try {
            OptimizelyManager manager = OptimizelyManager.builder()
                    .withSDKKey(BuildConfig.ABTEST_KEY)
                    .withDatafileDownloadInterval(TimeUnit.MINUTES.toSeconds(60))
                    .build(application);

            mSyncOptyClient = manager.initialize(application, R.raw.datafile, true, true);
            Log.e("Optly", "mSyncOptyClient=%s, thread info:%s", mSyncOptyClient, Thread.currentThread().getName());

            /*OptimizelyManager.builder()
                    .withSDKKey(BuildConfig.ABTEST_KEY)
                    .withDatafileDownloadInterval(TimeUnit.MINUTES.toSeconds(60))
                    .build(application)
                    .initialize(application, null, (OptimizelyClient optimizely) -> {
                        Log.e("Optly", "mAsyncOptyClient initialized, thread info:%s", Thread.currentThread().getName());
                        mAsyncOptyClient = optimizely;
                    });*/


        } catch (Exception e) {
            e.printStackTrace();
            TrackEventUtils.put("error_message", TempUtils.converThrowable2String(e))
                    .track("CodeError");
        }

        return this;
    }

    public void updateUserId() {
        AccountPrefModel acc = new AccountPrefModel().restore();
        if (acc.isLogin()) {
            mUserId = acc.user_id;
        } else {
            mUserId = "anonymous-user";
        }
    }

    public boolean isFeatureEnable(String key) {

        if (mSyncOptyClient == null) {
            return false;
        }

        HashMap<String, String> attribution = new HashMap<>();
        attribution.put("client", "Android");
        return mSyncOptyClient.isFeatureEnabled(key, mUserId, attribution);

    }


}
