/**
 * Info: http://thisthread.blogspot.com/2017/02/spring-prototype-bean.html
 * 
 * @author manny egalli64@gmail.com
 */
package dd.sia.scoping;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Scoping.class)
public class ScopedConfig {
}
