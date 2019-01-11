package sia.knights.java_config_inject;

import sia.knights.Knight;
import sia.knights.Quest;

public class KnightBean implements Knight {

    private Quest quest;

    public KnightBean(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }

}
