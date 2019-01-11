package sia.knights.aop;

import sia.knights.Knight;
import sia.knights.Quest;

public class DamselRescuingKnight implements Knight {
    private Quest quest;

    public DamselRescuingKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }

}
