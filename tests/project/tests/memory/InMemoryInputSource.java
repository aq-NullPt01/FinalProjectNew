package project.tests.memory;

import java.util.ArrayList;
import java.util.List;

import project.process.InputSource;

public class InMemoryInputSource implements InputSource {

    // Stores input values
    private final List<Integer> values;

    // Constructor
    public InMemoryInputSource(List<Integer> values) {
        this.values = new ArrayList<>(values);
    }

    // Returns the input values
    public List<Integer> getValues() {
        return values;
    }

    // Required by InputSource interface
    @Override
    public String getLocation() {
        return "memory-input";
    }
}