package sia.knights.xml_inject;

import sia.knights.Knight;
import sia.knights.Quest;

public class KnightXmlBean implements Knight {

    private Quest quest;

    public KnightXmlBean(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }

}
