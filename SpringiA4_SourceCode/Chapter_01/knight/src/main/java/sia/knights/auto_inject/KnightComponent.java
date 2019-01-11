package sia.knights.auto_inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sia.knights.Knight;
import sia.knights.Quest;

/**
 * Created by mark.lin on 2017/3/29.
 */
@Component("knight")
public class KnightComponent implements Knight {

    @Autowired
    private Quest quest;

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }

}
