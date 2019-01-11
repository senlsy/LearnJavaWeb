package sia.knights.auto_inject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "sia.knights.auto_inject", excludeFilters = {@Filter(Configuration.class)})
public class ScanConfig {
}
