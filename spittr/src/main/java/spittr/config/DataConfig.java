/**
 * http://thisthread.blogspot.com/2017/05/from-model-to-view-through-spring.html
 */

package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spittr.data.JdbcSpittleRepository;
import spittr.data.SpittleRepository;

@Configuration
public class DataConfig {
    @Bean
    public SpittleRepository spittleRepository() {
        return new JdbcSpittleRepository();
    }
}
