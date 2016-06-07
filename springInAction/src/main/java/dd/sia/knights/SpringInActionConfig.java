package dd.sia.knights;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import dd.sia.knights.logic.Minstrel;

@Configuration
@EnableAspectJAutoProxy
public class SpringInActionConfig {
    @Bean
    public Minstrel minstrel() {
        return new Minstrel();
    }
}
