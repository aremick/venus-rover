package akqa.venus;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aaron on 11/11/16.
 * <p>
 * This class is awesome
 */
public class CoordinatesTest {
    @Test
    public void testMoveNorth() throws Exception {
        assertEquals("N from origin", new Coordinates(0,1), new Coordinates(0,0).moveNorth());
    }

    @Test
    public void testMoveEast() throws Exception {
        assertEquals("N from origin", new Coordinates(1,0), new Coordinates(0,0).moveEast());
    }

    @Test
    public void testMoveSouth() throws Exception {
        assertEquals("N from origin", new Coordinates(0,-1), new Coordinates(0,0).moveSouth());
    }

    @Test
    public void testMoveWest() throws Exception {
        assertEquals("N from origin", new Coordinates(-1,0), new Coordinates(0,0).moveWest());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("", "(0,1)", new Coordinates(0,1).toString());
    }


}
