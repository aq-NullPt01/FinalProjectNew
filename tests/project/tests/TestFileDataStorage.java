package project.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import project.process.DataStorageAPIImpl;
import project.process.InputSource;
import project.process.IntegerData;
import project.process.OutputData;
import project.process.OutputDestination;

/**
 * Tests file-based data storage.
 */
public class TestFileDataStorage {

    @TempDir
    Path temporaryDirectory;

    /**
     * Verifies that integer values are read from a file.
     *
     * @throws Exception if the file operation fails
     */
    @Test
    public void testReadInputData() throws Exception {

        Path inputPath = temporaryDirectory.resolve("input.txt");

        Files.writeString(inputPath,"1\n10\n25\n",StandardCharsets.UTF_8);

        InputSource source = () -> inputPath.toString();

        DataStorageAPIImpl storage = new DataStorageAPIImpl();

        IntegerData result = storage.readInputData(source);

        assertEquals(Arrays.asList(1, 10, 25),result.getValues());
    }

    /**
     * Verifies that output data is written to a file.
     *
     * @throws Exception if the file operation fails
     */
    @Test
    public void testWriteOutputData() throws Exception {

        Path outputPath = temporaryDirectory.resolve("output.txt");

        OutputDestination destination = () -> outputPath.toString();

        OutputData data = () -> "10:3,4,5;6,8,10";

        DataStorageAPIImpl storage = new DataStorageAPIImpl();

        storage.writeOutputData(destination, data);

        String actualOutput = Files.readString(outputPath,StandardCharsets.UTF_8);

        assertEquals("10:3,4,5;6,8,10", actualOutput);
    }
}