package sia.knights.java_config_inject;

import sia.knights.Quest;

import java.io.PrintStream;

public class QuestBean implements Quest {

    private PrintStream stream;

    public QuestBean(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("java config inject quest call");
    }

}
