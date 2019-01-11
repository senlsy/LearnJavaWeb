package sia.knights.xml_inject;

import sia.knights.Quest;

import java.io.PrintStream;

public class QuestXmlBean implements Quest {

    private PrintStream stream;

    public QuestXmlBean(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("xml inject quest call");
    }

}
