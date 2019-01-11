package sia.knights.aop;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sia.knights.FakePrintStream;
import sia.knights.Knight;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/sia/knights/KnightXMLInjectionTest-context.xml"})
public class KnightXMLInjectionTest {

    @Autowired
    Knight knight;

    @Autowired
    FakePrintStream printStream;

    @After
    public void clearPrintStream() {
        printStream.clear();
    }

    @Test
    public void shouldInjectKnightWithSlayDragonQuest() {
        knight.embarkOnQuest();
        assertEquals(
                "前置通知\n" +
                        "后置通知\n",
                printStream.getPrintedString());
    }

}
