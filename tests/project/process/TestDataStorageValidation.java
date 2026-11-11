package project.process;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDataStorageValidation {

    private final DataStorageAPIImpl storage =
            new DataStorageAPIImpl();

    @Test
    public void testNullInputSource() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> storage.readInputData(null));
    }

    @Test
    public void testEmptyInputLocation() {

        InputSource source = () -> "";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> storage.readInputData(source));
    }

    @Test
    public void testNullOutputDestination() {

        OutputData data = () -> "Test output";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> storage.writeOutputData(null, data));
    }

    @Test
    public void testNullOutputData() {

        OutputDestination destination =
                () -> "output.txt";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> storage.writeOutputData(destination, null));
    }

    @Test
    public void testEmptyOutputLocation() {

        OutputDestination destination = () -> "";

        OutputData data = () -> "Test output";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> storage.writeOutputData(destination, data));
    }
}