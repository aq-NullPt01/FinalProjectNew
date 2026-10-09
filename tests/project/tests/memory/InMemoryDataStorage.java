package project.tests.memory;

import java.util.List;

import project.process.DataStorageAPI;
import project.process.InputSource;
import project.process.IntegerData;
import project.process.OutputData;
import project.process.OutputDestination;

public class InMemoryDataStorage implements DataStorageAPI {

    // Read integer values from memory
    @Override
    public IntegerData readInputData(InputSource source) {

        // Convert the input source to our test class
        InMemoryInputSource input =
                (InMemoryInputSource) source;

        // Retrieve the stored integers
        List<Integer> values = input.getValues();

        // Return the values as IntegerData
        return new IntegerData() {

            @Override
            public List<Integer> getValues() {
                return values;
            }
        };
    }

    // Write computation results into memory
    @Override
    public void writeOutputData(
            OutputDestination destination,
            OutputData data) {

        // Convert destination to our test class
        InMemoryOutputDestination output =
                (InMemoryOutputDestination) destination;

        // Store the result string
        output.getResults().add(data.getData());
    }
}