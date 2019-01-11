package sia.knights.aop;

import java.io.PrintStream;

public class Minstrel {

    private PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }

    public void singBeforeQuest() {
        stream.println("前置通知");
    }

    public void singAfterQuest() {
        stream.println("后置通知");
    }

}
