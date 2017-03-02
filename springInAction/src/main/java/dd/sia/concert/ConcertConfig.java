/**
 * Info: http://thisthread.blogspot.com/2017/03/the-spring-aop-around-advice.html
 * 
 * @author manny egalli64@gmail.com
 */
package dd.sia.concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = Performance.class)
public class ConcertConfig {
    @Bean
    public Audience audience() {
        return new Audience();
    }

    // @Bean
    // public AudienceAround audienceAround() {
    // return new AudienceAround();
    // }
}
