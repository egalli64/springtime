/**
 * Info: http://thisthread.blogspot.com/2017/02/autowiring-ambiguity.html
 * 
 * @author manny egalli64@gmail.com
 */
package dd.sia.restaurant;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Dessert.class)
public class DessertConfig {
}
