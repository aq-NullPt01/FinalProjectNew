
package project.process;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DataStorageAPIImpl implements DataStorageAPI {

    // Constructor has no parameters to validate
    public DataStorageAPIImpl() {
    }

    // Read integer data from a file
    @Override
    public IntegerData readInputData(InputSource source) {

        // Checkpoint 5: Validate input source
        if (source == null) {
            throw new IllegalArgumentException(
                    "Input source cannot be null");
        }

        String location = source.getLocation();

        // Validate file location
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Input file location cannot be empty");
        }

        Path inputPath = Path.of(location);

        List<Integer> values = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(
                    inputPath, StandardCharsets.UTF_8);

            for (String line : lines) {

                String trimmedLine = line.trim();

                if (trimmedLine.isEmpty()) {
                    continue;
                }

                String[] numbers =
                        trimmedLine.split("[,\\s]+");

                for (String number : numbers) {

                    try {
                        values.add(Integer.parseInt(number));

                    } catch (NumberFormatException exception) {

                        throw new IllegalArgumentException(
                                "Invalid integer in input file: "
                                + number, exception);
                    }
                }
            }

        } catch (IOException exception) {

            throw new UncheckedIOException(
                    "Unable to read input file: "
                    + inputPath, exception);
        }

        // Return integer data
        return new IntegerData() {

            @Override
            public List<Integer> getValues() {
                return values;
            }
        };
    }

    // Write computation results to a file
    @Override
    public void writeOutputData(
            OutputDestination destination,
            OutputData data) {

        // Checkpoint 5: Validate destination
        if (destination == null) {
            throw new IllegalArgumentException(
                    "Output destination cannot be null");
        }

        // Validate output data
        if (data == null) {
            throw new IllegalArgumentException(
                    "Output data cannot be null");
        }

        String location = destination.getLocation();

        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Output file location cannot be empty");
        }
        

        String outputText = data.getData();

        if (outputText == null) {
            throw new IllegalArgumentException(
                    "Output text cannot be null");
        }

        Path outputPath = Path.of(location);

        try {
            Files.writeString(
                    outputPath,
                    outputText,
                    StandardCharsets.UTF_8);

        } catch (IOException exception) {

            throw new UncheckedIOException(
                    "Unable to write output file: "
                    + outputPath, exception);
        }
    }
}
