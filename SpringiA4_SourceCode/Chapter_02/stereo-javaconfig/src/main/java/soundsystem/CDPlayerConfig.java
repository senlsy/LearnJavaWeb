package soundsystem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CDPlayerConfig {

    @Bean
    @Qualifier
    public CompactDisc compactDisc() {
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }

    @Bean
    @Primary
    public CDPlayer cdPlayer2(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }

}
