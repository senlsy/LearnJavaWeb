package sia.knights.aop;

import sia.knights.Quest;

public class RescueDamselQuest implements Quest {

    public void embark() {
        System.out.println("test aop quest call");
    }

}
