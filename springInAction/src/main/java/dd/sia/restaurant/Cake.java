/**
 * Info: http://thisthread.blogspot.com/2017/02/autowiring-ambiguity.html
 * 
 * @author manny egalli64@gmail.com
 */
package dd.sia.restaurant;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cake implements Dessert {
}
