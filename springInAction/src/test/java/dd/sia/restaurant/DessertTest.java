/**
 * Info: http://thisthread.blogspot.com/2017/02/autowiring-ambiguity.html
 * 
 * @author manny egalli64@gmail.com
 */
package dd.sia.restaurant;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DessertConfig.class)
@WebAppConfiguration
public class DessertTest {
    @Autowired
    @Qualifier("yummy")
    Dessert dessert;

    @Test
    public void test() {
        assertThat(dessert.getPrice(), is(7.50));
    }
}
