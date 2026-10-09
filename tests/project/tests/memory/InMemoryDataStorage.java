package project.tests.memory;

import java.util.List;

import project.process.DataStorageAPI;
import project.process.InputSource;
import project.process.IntegerData;
import project.process.OutputData;
import project.process.OutputDestination;

public class InMemoryDataStorage implements DataStorageAPI {

    @Override
    public IntegerData readInputData(InputSource source) {

        InMemoryInputSource input =
                (InMemoryInputSource) source;

        List<Integer> values = input.getValues();

        return new IntegerData() {

            @Override
            public List<Integer> getValues() {
                return values;
            }
        };
    }

    @Override
    public void writeOutputData(
            OutputDestination destination,
            OutputData data) {

        InMemoryOutputDestination output =
                (InMemoryOutputDestination) destination;

        output.getResults().add(data.getData());
    }
}