package project.tests.memory;

import java.util.ArrayList;
import java.util.List;

import project.process.InputSource;

public class InMemoryInputSource implements InputSource {

    private final List<Integer> values;

    // Constructor
    public InMemoryInputSource(List<Integer> values) {

        if (values == null) {
            throw new IllegalArgumentException(
                    "Input values cannot be null");
        }

        this.values = new ArrayList<>(values);
    }

    // Return the stored input values
    public List<Integer> getValues() {
        return values;
    }

    
    
    // Required by InputSource interface
    @Override
    public String getLocation() {
        return "memory-input";
    }
}