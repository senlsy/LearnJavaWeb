package soundsystem;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mark.lin on 2017/3/30.
 */
public class Main {
    public static void main(String[] args) {
        //装载config
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);

        //装载xml
        ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("META-INF/spring/soundsystem.xml");

        MediaPlayer player = xmlContext.getBean(MediaPlayer.class);
        player.startPlay();
    }
}
