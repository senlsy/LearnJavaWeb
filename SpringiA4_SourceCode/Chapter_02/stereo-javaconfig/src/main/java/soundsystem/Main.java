package soundsystem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by mark.lin on 2017/3/30.
 */
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);

        MediaPlayer player = context.getBean(MediaPlayer.class);
        player.play();

    }
}
