package sia.knights.mockito_test;

import static org.mockito.Mockito.*;

import org.junit.Test;
import sia.knights.Quest;
import sia.knights.xml_inject.KnightXmlBean;


public class KnightXmlBeanTest {

    @Test
    public void knightShouldEmbarkOnQuest() {
        Quest mockQuest = mock(Quest.class);
        KnightXmlBean knight = new KnightXmlBean(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();
    }

}
