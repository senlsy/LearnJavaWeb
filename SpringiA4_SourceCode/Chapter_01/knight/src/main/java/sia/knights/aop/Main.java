package sia.knights.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import sia.knights.Knight;

public class Main {

    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/minstrel.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();

    }

}
