/**
 * Info: http://thisthread.blogspot.com/2017/03/the-spring-aop-around-advice.html
 * 
 * @author manny egalli64@gmail.com
 */
package dd.sia.concert;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class PopConcertTest {
    @Autowired
    private Performance performance;

    @Test
    public void testPerform() {
        try {
            assertTrue(performance.perform(11));
        } catch (PerformanceException pe) {
            fail("Unexpected PerformanceException: " + pe.getMessage());
        }
    }

    @Test(expected=PerformanceException.class)
    public void testPerformBadly() throws PerformanceException {
        performance.perform(2);
    }
}
