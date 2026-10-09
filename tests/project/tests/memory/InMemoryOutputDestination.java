package project.tests.memory;

import java.util.ArrayList;
import java.util.List;

import project.process.OutputDestination;

public class InMemoryOutputDestination
        implements OutputDestination {

    // Stores computation results
    private final List<String> results;

    // Constructor
    public InMemoryOutputDestination() {
        results = new ArrayList<>();
    }

    // Returns the stored results
    public List<String> getResults() {
        return results;
    }

    // Required by OutputDestination interface
    @Override
    public String getLocation() {
        return "memory-output";
    }
}