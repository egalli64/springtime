/**
 * http://thisthread.blogspot.com/2017/06/spitter-registration.html
 */
package spittr;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpitterTest {

    @Test
    public void testEqualsEmpty() {
        Spitter left = new Spitter();
        Spitter right = new Spitter();
        assertEquals(left, right);
    }

    @Test
    public void testEqualsSame() {
        Spitter left = new Spitter("rguy", "password", "Random", "Guy", "rguy@somesite.dd");
        Spitter right = new Spitter("rguy", "password", "Random", "Guy", "rguy@somesite.dd");
        assertEquals(left, right);
    }

    @Test
    public void testEqualsDifferent() {
        Spitter left = new Spitter("rguy", "password", "Random", "Guy", "rguy@somesite.dd");
        Spitter right = new Spitter("rguy", "password", "Random", "Guy", "rguy2@somesite.dd");
        assertNotEquals(left, right);
    }

    @Test
    public void testHashSame() {
        Spitter left = new Spitter("rguy", "password", "Random", "Guy", "rguy@somesite.dd");
        Spitter right = new Spitter("rguy", "password", "Random", "Guy", "rguy@somesite.dd");
        assertEquals(left.hashCode(), right.hashCode());
    }

    @Test
    public void testHashDifferent() {
        Spitter left = new Spitter("rguy", "password", "Random", "Guy", "rguy@somesite.dd");
        Spitter right = new Spitter("rguy", "password", "Random", "Guy", "rguy2@somesite.dd");
        assertNotEquals(left.hashCode(), right.hashCode());
    }

}
