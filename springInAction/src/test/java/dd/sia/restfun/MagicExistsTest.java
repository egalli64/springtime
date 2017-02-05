package dd.sia.restfun;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MagicConfig.class)
public class MagicExistsTest {
    @Autowired
    private ApplicationContext context;
    
    @Autowired
    private MagicBean magic;

    @Test
    public void testBeanInContext() {
        MagicBean mb = (MagicBean) context.getBean("magicBean");
        assertThat(mb.toString(), is("Magic Bean!"));
    }
    
    @Test
    public void testBeanWired() {
        assertThat(magic.toString(), is("Magic Bean!"));
    }
}
