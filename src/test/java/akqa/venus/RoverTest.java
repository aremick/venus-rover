package akqa.venus;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aaron on 11/11/16.
 * <p>
 * This class is awesome
 */
public class RoverTest {
    private static Plateau p = new Plateau(5,5,5,5);
    private Rover r;

    @Before
    public void setUp() throws Exception {
        r = new Rover(p, 0, 0, Plateau.Direction.N);
    }

    @Test
    public void moveTest() throws Exception {
        assertEquals("move north", new Coordinates(0,1), r.move());
        r.turnRight();
        assertEquals("move east", new Coordinates(1,1), r.move());
        r.turnRight();
        assertEquals("move south", new Coordinates(1,0), r.move());
        r.turnRight();
        assertEquals("move west", new Coordinates(0,0), r.move());
        assertEquals("move west again", new Coordinates(-1,0), r.move());
    }

    @Test
    public void turnLeftTest() throws Exception {
        assertEquals("left from N", Plateau.Direction.W, r.turnLeft());
        assertEquals("left from W", Plateau.Direction.S, r.turnLeft());
        assertEquals("left from S", Plateau.Direction.E, r.turnLeft());
        assertEquals("left from E", Plateau.Direction.N, r.turnLeft());
    }

    @Test
    public void turnRightTest() throws Exception {
        assertEquals("right from N", Plateau.Direction.E, r.turnRight());
        assertEquals("right from E", Plateau.Direction.S, r.turnRight());
        assertEquals("right from S", Plateau.Direction.W, r.turnRight());
        assertEquals("right from W", Plateau.Direction.N, r.turnRight());
    }

}
