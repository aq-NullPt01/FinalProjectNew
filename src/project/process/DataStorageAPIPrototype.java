package project.process;

import java.util.List;
import project.annotations.ProcessAPIPrototype;

/**
 * Prototype client for the data storage API.
 */
public class DataStorageAPIPrototype {

    /**
     * Demonstrates how the compute engine can use the data storage API.
     *
     * @param api the data storage API
     */
    @ProcessAPIPrototype
    public void prototype(DataStorageAPI api) {
    	// Validate the API dependency
        if (api == null) {
            throw new IllegalArgumentException(
                    "DataStorageAPI cannot be null");
        }

        // Create a valid input source
        InputSource source = new InputSource() {

            @Override
            public String getLocation() {
                return "input.txt";
            }
        };

        // Create a valid output destination
        OutputDestination destination =
                new OutputDestination() {

            @Override
            public String getLocation() {
                return "output.txt";
            }
        };
        
        

        // Read integer data from the input file
        IntegerData inputData =
                api.readInputData(source);

        // Validate returned data
        if (inputData == null ||
                inputData.getValues() == null) {
            throw new IllegalStateException(
                    "Input data cannot be null");
        }

        List<Integer> values = inputData.getValues();

        // Create valid output data
        OutputData outputData = new OutputData() {

            @Override
            public String getData() {
                return values.toString();
            }
        };

        // Write the output
        api.writeOutputData(destination, outputData);
    }
}