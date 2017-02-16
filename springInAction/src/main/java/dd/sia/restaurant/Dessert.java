/**
 * Info: http://thisthread.blogspot.com/2017/02/autowiring-ambiguity.html
 * 
 * @author manny egalli64@gmail.com
 */
package dd.sia.restaurant;

public interface Dessert {
    default double getPrice() {
        return 0;
    }
}
