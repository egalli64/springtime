package spittr;

import static org.junit.Assert.*;
import org.junit.Test;

import java.time.LocalDateTime;

public class SpittleTest {
    @Test
    public void testEquals() {
        LocalDateTime time = LocalDateTime.now();
        Spittle a = new Spittle("A message", time);
        Spittle b = new Spittle("A message", time);
        assertEquals(a, b);
    }

    @Test
    public void testEqualsSame() {
        LocalDateTime time = LocalDateTime.now();
        Spittle a = new Spittle("A message", time);
        assertEquals(a, a);
    }

    @Test
    public void testEqualsSameNot() {
        LocalDateTime time = LocalDateTime.now();
        Spittle a = new Spittle("A message", time);
        Spittle b = new Spittle("A message", time.plusSeconds(1));
        assertNotEquals(a, b);
    }

    @Test
    public void testEqualsNullNot() {
        LocalDateTime time = LocalDateTime.now();
        Spittle a = new Spittle("A message", time);
        Spittle b = null;
        assertNotEquals(a, b);
    }

    @Test
    public void testEqualsNullNot2() {
        LocalDateTime time = LocalDateTime.now();
        Spittle a = null;
        Spittle b = new Spittle("A message", time);
        assertNotEquals(a, b);
    }

    @Test
    public void testEqualsNullDate() {
        LocalDateTime time = LocalDateTime.now();
        Spittle a = new Spittle("A message", null);
        Spittle b = new Spittle("A message", time);
        assertNotEquals(a, b);
    }

    @Test
    public void testEqualsNullDate2() {
        LocalDateTime time = LocalDateTime.now();
        Spittle a = new Spittle("A message", time);
        Spittle b = new Spittle("A message", null);
        assertNotEquals(a, b);
    }
}
