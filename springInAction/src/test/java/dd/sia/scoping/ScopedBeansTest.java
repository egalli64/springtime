/**
 * Info: http://thisthread.blogspot.com/2017/02/spring-prototype-bean.html
 * 
 * @author manny egalli64@gmail.com
 */
package dd.sia.scoping;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ScopedConfig.class)
public class ScopedBeansTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void testSingleton() {
        UniqueThing thing1 = context.getBean(UniqueThing.class);
        UniqueThing thing2 = context.getBean(UniqueThing.class);
        assertSame(thing1, thing2);
    }

    @Test
    public void testPrototype() {
        Notepad notepad1 = context.getBean(Notepad.class);
        Notepad notepad2 = context.getBean(Notepad.class);
        assertNotSame(notepad1, notepad2);
    }
}
