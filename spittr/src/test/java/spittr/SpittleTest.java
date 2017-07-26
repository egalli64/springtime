/**
 * http://thisthread.blogspot.com/2017/07/using-jdbctemplate-in-spitter-web-app.html
 */
package spittr;

import static org.junit.Assert.*;
import org.junit.Test;

import java.time.Instant;

public class SpittleTest {
    @Test
    public void testEquals() {
        Instant time = Instant.now();
        Spittle a = new Spittle("A message", time);
        Spittle b = new Spittle("A message", time);
        assertEquals(a, b);
    }

    @Test
    public void testEqualsSame() {
        Instant time = Instant.now();
        Spittle a = new Spittle("A message", time);
        assertEquals(a, a);
    }

    @Test
    public void testEqualsSameNot() {
        Instant time = Instant.now();
        Spittle a = new Spittle("A message", time);
        Spittle b = new Spittle("A message", time.plusSeconds(1));
        assertNotEquals(a, b);
    }

    @Test
    public void testEqualsNullNot() {
        Instant time = Instant.now();
        Spittle a = new Spittle("A message", time);
        Spittle b = null;
        assertNotEquals(a, b);
    }

    @Test
    public void testEqualsNullNot2() {
        Instant time = Instant.now();
        Spittle a = null;
        Spittle b = new Spittle("A message", time);
        assertNotEquals(a, b);
    }

    @Test
    public void testEqualsNullDate() {
        Instant time = Instant.now();
        Spittle a = new Spittle("A message", null);
        Spittle b = new Spittle("A message", time);
        assertNotEquals(a, b);
    }

    @Test
    public void testEqualsNullDate2() {
        Instant time = Instant.now();
        Spittle a = new Spittle("A message", time);
        Spittle b = new Spittle("A message", null);
        assertNotEquals(a, b);
    }
}
