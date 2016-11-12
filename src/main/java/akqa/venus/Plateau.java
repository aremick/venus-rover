package akqa.venus;

import com.google.common.collect.BiMap;
import com.google.common.collect.EnumBiMap;

import java.util.function.Function;

/**
 * Created by aaron on 11/9/16.
 * <p>
 * This class is awesome
 */
public class Plateau {

    private int north, south, east, west;

    Plateau(int n, int e, int s, int w) {
        this.north = n; // y max
        this.south = -s; // y min
        this.east = e; // x max
        this.west = -w; // x min
        if (!(this.north > this.south && this.east > this.west)) {
            throw new IllegalStateException("plateau must have some size.");
        }
    }

    public boolean isValidPosition(int x, int y) {
        return x <= east && x >= west && y <= north && y >= south;
    }

    public boolean isValidPosition(final Coordinates c) {
        return isValidPosition(c.x, c.y);
    }

    public double plateauArea() {
        return (north - south) * (east - west);
    }

    public enum Direction {
        N((Coordinates o) -> o.moveNorth()),
        E((Coordinates o) -> o.moveEast()),
        S((Coordinates o) -> o.moveSouth()),
        W((Coordinates o) -> o.moveWest());

        protected static BiMap<Direction, Direction> turnMap = EnumBiMap.create(Direction.class, Direction.class);

        static {
            turnMap.put(N, E);
            turnMap.put(E, S);
            turnMap.put(S, W);
            turnMap.put(W, N);
        }

        private final Function<Coordinates, Coordinates> moveFunction;

        Direction(final Function<Coordinates, Coordinates> moveFunction) {
            this.moveFunction = moveFunction;
        }

        public Direction right() {
            return turnMap.get(this);
        }

        public Direction left() {
            return turnMap.inverse().get(this);
        }

        public Coordinates move(Coordinates origin) {
            return moveFunction.apply(origin);
        }
    }

}
