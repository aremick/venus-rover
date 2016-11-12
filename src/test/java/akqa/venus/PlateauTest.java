package akqa.venus;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aaron on 11/11/16.
 * <p>
 * This class is awesome
 */
public class PlateauTest {
    @Test
    public void testCreateInvalidPlateau() {
        try {
            new Plateau(0,1,0,-2);
            fail("Expected error on 0,1,0,-2");
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "plateau must have some size.");
        }
        try {
            new Plateau(1,-11,-2,2);
            fail("Expected error on 1,-11,-2,2");
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "plateau must have some size.");
        }
    }

    @Test
    public void isValidPosition() {
        Plateau p = new Plateau(5,5,3,3);
        assertTrue("Center should always be valid.", p.isValidPosition(0,0));
        assertTrue("NE corner should be valid.", p.isValidPosition(5,5));
        assertTrue("SE corner should be valid.", p.isValidPosition(-3,5));
        assertTrue("NW corner should be valid.", p.isValidPosition(5,-3));
        assertTrue("SW corner should be valid.", p.isValidPosition(-3,-3));
        assertFalse("Too far north should be invalid", p.isValidPosition(0,6));
        assertFalse("Too far east should be invalid", p.isValidPosition(6,0));
        assertFalse("Too far south should be invalid", p.isValidPosition(0,-4));
        assertFalse("Too far west should be invalid", p.isValidPosition(-4,0));
    }

    @Test
    public void testDirectionLeft() throws Exception {
        assertEquals("from N turn left", Plateau.Direction.W, Plateau.Direction.N.left());
        assertEquals("from E turn left", Plateau.Direction.N, Plateau.Direction.E.left());
        assertEquals("from S turn left", Plateau.Direction.E, Plateau.Direction.S.left());
        assertEquals("from W turn left", Plateau.Direction.S, Plateau.Direction.W.left());
    }

    @Test
    public void testDirectionRight() throws Exception {
        assertEquals("from N turn right", Plateau.Direction.E, Plateau.Direction.N.right());
        assertEquals("from E turn right", Plateau.Direction.S, Plateau.Direction.E.right());
        assertEquals("from S turn right", Plateau.Direction.W, Plateau.Direction.S.right());
        assertEquals("from W turn right", Plateau.Direction.N, Plateau.Direction.W.right());
    }

}
