package dd.sia.soundsystem;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
    @Autowired
    private MediaPlayer player;

    @Test
    public void testPlayerNotNull() {
        assertNotNull(player);
    }

    @Test
    public void testCDInserted() {
        assertTrue(player.hasMedia());
    }

    @Test
    public void testPlay() {
        assertEquals("Sgt. Pepper's Lonely Hearts Club Band by The Beatles", player.play());
    }
}
