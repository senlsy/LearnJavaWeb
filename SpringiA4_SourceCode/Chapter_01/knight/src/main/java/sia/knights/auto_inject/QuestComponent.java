package sia.knights.auto_inject;

import org.springframework.stereotype.Component;
import sia.knights.Quest;

/**
 * Created by mark.lin on 2017/3/29.
 */
@Component
public class QuestComponent implements Quest {
    @Override
    public void embark() {
        System.out.print("auto inject quest component call");
    }
}
