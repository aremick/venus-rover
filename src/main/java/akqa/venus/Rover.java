package akqa.venus;

/**
 * Created by aaron on 11/11/16.
 * <p>
 * This class is awesome
 */
public class Rover {
    Plateau plateau;
    Coordinates coordinates;
    Plateau.Direction orientation;


    public Rover(Plateau plateau, int xPos, int yPos, Plateau.Direction orientation) {
        if (!plateau.isValidPosition(xPos, yPos)) {
            throw new IllegalStateException("rover must start on plateau");
        }
        this.plateau = plateau;
        this.coordinates = new Coordinates(xPos, yPos);
        this.orientation = orientation;
    }

    public Coordinates move() {
        Coordinates newLocation = orientation.move(coordinates);
        if (!plateau.isValidPosition(newLocation)) {
            throw new IllegalStateException("attempt to move" + orientation + " from " + coordinates + " would leave plateau.");
        }
        return coordinates = newLocation;
    }

    public Plateau.Direction turnLeft() {
        return orientation = orientation.left();
    }

    public Plateau.Direction turnRight() {
        return orientation = orientation.right();
    }

}
