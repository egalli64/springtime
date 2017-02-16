/**
 * Info: http://thisthread.blogspot.com/2017/02/autowiring-ambiguity.html
 * 
 * @author manny egalli64@gmail.com
 */
package dd.sia.restaurant;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("yummy")
public class Cookies implements Dessert {
    @Override
    public double getPrice() {
        return 7.50;
    }
}
