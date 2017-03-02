/**
 * Info: http://thisthread.blogspot.com/2017/03/the-spring-aop-around-advice.html
 * 
 * @author manny egalli64@gmail.com
 */
package dd.sia.concert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
    private final static Log log = LogFactory.getLog(Audience.class);

    @Pointcut("execution(boolean Performance.perform(int))")
    public void performance() {}
    
    @Before("performance()")
    public void silenceMobile() {
        log.info("Silencing mobile phones");
    }

    @Before("performance()")
    public void takingSeat() {
        log.info("Taking seat");
    }

    @AfterReturning("performance()")
    public void applaude() {
        log.info("Applauding");
    }

    @AfterThrowing("performance()")
    public void complain() {
        log.info("Demanding a refund");
    }
}
