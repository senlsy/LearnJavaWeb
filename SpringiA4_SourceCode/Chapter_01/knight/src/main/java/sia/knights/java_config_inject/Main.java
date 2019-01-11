package sia.knights.java_config_inject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sia.knights.Knight;

public class Main {

    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();

    }

}
