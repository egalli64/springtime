/**
 * Info: http://thisthread.blogspot.com/2017/03/the-spring-aop-around-advice.html
 * 
 * @author manny egalli64@gmail.com
 */
package dd.sia.concert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AudienceAround {
    private final static Log log = LogFactory.getLog(AudienceAround.class);

    @Around("execution(boolean Performance.perform(int))")
    public Object watchPerformance(ProceedingJoinPoint pjp) throws PerformanceException {
        Object result = null;
        try {
            log.info("Ensure mobile is off");
            log.info("Take place");
            result = pjp.proceed();
            log.info("Cheer");
        } catch (Throwable t) {
            log.info("Demand a refund: " + t.getMessage());
            if (t instanceof PerformanceException) {
                throw ((PerformanceException) t);
            } else {
                throw new PerformanceException("Unexpected:" + t.getMessage());
            }
        }
        return result;
    }
}
