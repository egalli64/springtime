/**
 * Info: http://thisthread.blogspot.com/2017/03/the-spring-aop-around-advice.html
 * 
 * @author manny egalli64@gmail.com
 */
package dd.sia.concert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PopConcert implements Performance {
    private static final Log log = LogFactory.getLog(PopConcert.class);

    @Override
    public boolean perform(int level) throws PerformanceException {
        if (level > 8) {
            log.info("A nice gig");
            return true;
        } else if (level > 6) {
            log.info("Not in the mood tonight");
            return false;
        } else {
            throw new PerformanceException("Drunk drummer");
        }
    }
}
