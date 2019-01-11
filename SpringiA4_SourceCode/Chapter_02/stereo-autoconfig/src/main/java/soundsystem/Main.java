package soundsystem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mark.lin on 2017/3/30.
 */
public class Main {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("META-INF/spring/soundsystem.xml");
        MediaPlayer player = xmlContext.getBean(MediaPlayer.class);
        player.play();
    }
}
