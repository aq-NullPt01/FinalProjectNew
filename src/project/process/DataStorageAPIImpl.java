package project.process;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads integer inputs from files and writes computation results.
 */
public class DataStorageAPIImpl implements DataStorageAPI {

    /**
     * Creates a file-based data storage implementation.
     */
    public DataStorageAPIImpl() {
    }

    /**
     * Reads integer values from the specified input file.
     *
     * @param source location of the input file
     * @return integer data read from the file
     */
    @Override
    public IntegerData readInputData(InputSource source) {

        Path inputPath = Path.of(source.getLocation());
        List<Integer> values = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(inputPath, StandardCharsets.UTF_8);

            for (String line : lines) {

                String trimmedLine = line.trim();

                if (trimmedLine.isEmpty()) {
                    continue;
                }

                String[] numbers = trimmedLine.split("[,\\s]+");

                for (String number : numbers) {
                    values.add(Integer.parseInt(number));
                }
            }

        } catch (IOException exception) {
            throw new UncheckedIOException("Unable to read input file: " + inputPath, exception);
        }

        return new IntegerData() {

            @Override
            public List<Integer> getValues() {
                return values;
            }
        };
    }

    /**
     * Writes formatted computation results to the output file.
     *
     * @param destination location of the output file
     * @param data computation output to write
     */
    @Override
    public void writeOutputData(OutputDestination destination,OutputData data) {

        Path outputPath = Path.of(destination.getLocation());

        try {
            Files.writeString(outputPath,data.getData(),StandardCharsets.UTF_8);

        } catch (IOException exception) {
            throw new UncheckedIOException("Unable to write output file: " + outputPath,exception);
        }
    }
}