package project.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import project.process.DataStorageAPI;
import project.process.DataStorageAPIImpl;
import project.process.InputSource;
import project.process.IntegerData;

/**
 * Smoke tests for the data storage API.
 */
public class TestDataStorageAPI {

    @TempDir
    Path temporaryDirectory;

    /**
     * Checks that the storage API reads integers.
     *
     * @throws Exception if the file operation fails
     */
    @Test
    public void testDataStorageAPI() throws Exception {

        Path inputPath = temporaryDirectory.resolve("input.txt");

        Files.writeString(inputPath, "1\n10\n25\n");

        InputSource source = () -> inputPath.toString();

        DataStorageAPI storage = new DataStorageAPIImpl();

        IntegerData result = storage.readInputData(source);

        assertEquals(Arrays.asList(1, 10, 25),result.getValues());
    }
}