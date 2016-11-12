package akqa.venus;

import java.util.Objects;

/**
 * Created by aaron on 11/11/16.
 * <p>
 * This class is awesome
 */
public class Coordinates {
    public final int x;
    public final int y;

    public Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates moveNorth() {
        return new Coordinates(this.x, this.y + 1);
    }

    public Coordinates moveEast() {
        return new Coordinates(this.x + 1, this.y);
    }

    public Coordinates moveSouth() {
        return new Coordinates(this.x, this.y - 1);
    }

    public Coordinates moveWest() {
        return new Coordinates(this.x - 1, this.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
