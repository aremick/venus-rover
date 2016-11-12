package akqa.venus;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aaron on 11/11/16.
 * <p>
 * This class is awesome
 */
public class CommanderTest {

    private static final String mission1 =  "5 5 3 3\n" +
                                            "1 2 N\n" +
                                            "LMLMLMLMM\n" +
                                            "-3 -1 E\n" +
                                            "MMRMMLMMMR";

    private static final String mission1Result =    "1 3 N\n" +
                                                    "2 -3 S";

    @Test
    public void missionTest() throws Exception {
        assertEquals("Mission1 Failed", mission1Result, new Commander(mission1).getOutput());
    }
}
