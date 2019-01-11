package sia.knights.java_config_inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sia.knights.Knight;
import sia.knights.Quest;

@Configuration
public class JavaConfig {

    @Bean(name = "knight")
    public Knight knight(Quest quest) {
        return new KnightBean(quest);
    }

    @Bean
    public Quest quest() {
        return new QuestBean(System.out);
    }

}
