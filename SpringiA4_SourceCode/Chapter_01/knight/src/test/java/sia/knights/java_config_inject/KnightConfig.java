package sia.knights.java_config_inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sia.knights.FakePrintStream;
import sia.knights.Knight;
import sia.knights.Quest;


@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new KnightBean(quest());
    }

    @Bean
    public Quest quest() {
        return new QuestBean(stream());
    }

    @Bean
    public FakePrintStream stream() {
        return new FakePrintStream();
    }

}
