package akqa.venus;

import java.util.*;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

/**
 * Created by aaron on 11/9/16.
 * <p>
 * This class is awesome
 */
public class Commander {

    private Plateau plateau;
    private final Set<Rover> rovers = new LinkedHashSet<Rover>();
    private StringJoiner output = new StringJoiner("\n");

    public String getOutput() {
        return output.toString();
    }

    public Commander(final String commands) {
        Rover r;
        String[] lines = commands.split("\\r?\\n");
        if (lines.length == 0) {
            // no commands found
        }

        try {
            plateau = createPlateau(lines[0]);
        } catch (Throwable t) {
            output.add("Failed to create Plateau. Initial command line: " + lines[0]);
        }
        if (plateau != null) {
            for (int i = 1; i + 1 < lines.length; i += 2) {
                try {
                    r = createRover(lines[i]);
                    moveRover(r, lines[i + 1]);
                    rovers.add(r);
                } catch (Throwable e) {
                    // error parsing the rover commands log this
                    output.add("error parsing rover commands: " + lines[i] + "/" + lines[i + 1]);
                }
            }
        }
    }

    public Plateau createPlateau(final String borders) {
        String[] param = borders.split("\\s");
        int north = Integer.valueOf(param[0]);
        int east = Integer.valueOf(param[1]);
        int south = Integer.valueOf(param[2]);
        int west = Integer.valueOf(param[3]);

        return new Plateau(north, east, south, west);
    }

    public Rover createRover(final String start) {
        String[] param = start.split("\\s", 4);
        int x = Integer.valueOf(param[0]);
        int y = Integer.valueOf(param[1]);
        Plateau.Direction orientation = Plateau.Direction.valueOf(param[2]);
        return new Rover(plateau, x, y, orientation);
    }

    public void moveRover(final Rover r, final String commandString) {
        char[] commands = commandString.toCharArray();
        for(char c: commands) {
            switch (c) {
                case 'L':
                    r.turnLeft();
                    break;
                case 'R':
                    r.turnRight();
                    break;
                case 'M':
                    r.move();
                    break;
                default:
                    output.add("Ignoreing unrecognized command: " + c);
                    break;
            }
        }
        output.add(r.coordinates.x + " " + r.coordinates.y + " " + r.orientation.name());
    }

}
