package dd.sia.myapp;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class CharSeqConfigTest {
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes=CharSeqConfig.class)
    @ActiveProfiles("dev")
    public static class DevCharSeqTest {
        @Autowired
        private CharSequence charSeq;
        
        @Test
        public void testCharSeq() {
          assertThat(charSeq.toString(), is("String"));
        }
    }

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes=CharSeqConfig.class)
    @ActiveProfiles("prod")
    public static class ProdCharSeqTest {
        @Autowired
        private CharSequence charSeq;
        
        @Test
        public void testCharSeq() {
          assertThat(charSeq.toString(), is("StringBuilder"));
        }
    }
}
