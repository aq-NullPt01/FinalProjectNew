package project.network;

import project.annotations.NetworkAPIPrototype;
import project.process.InputSource;
import project.process.OutputDestination;

/**
 * Demonstrates submitting a computation job.
 */
public class ComputeEngineAPIPrototype {

    @NetworkAPIPrototype
    public void prototype(ComputeEngineAPI api) {

        InputSource source = new InputSource() {
            @Override
            public String getLocation() {
                return "input.txt";
            }
        };

        OutputDestination destination = new OutputDestination() {
            @Override
            public String getLocation() {
                return "output.txt";
            }
        };

        JobRequest request = new JobRequest() {
            @Override
            public InputSource getInputSource() {
                return source;
            }

            @Override
            public OutputDestination getOutputDestination() {
                return destination;
            }

            @Override
            public ResultDelimiters getDelimiters() {
                return ResultDelimiters.defaults();
            }
        };

        JobResponse response = api.submitJob(request);
    }
}