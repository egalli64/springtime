/**
 * Info: http://thisthread.blogspot.com/2017/03/the-spring-aop-around-advice.html
 * 
 * @author manny egalli64@gmail.com
 */
package dd.sia.concert;

public interface Performance {
    boolean perform(int level) throws PerformanceException;
}
