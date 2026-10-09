package project.tests.memory;

import java.util.ArrayList;
import java.util.List;

import project.process.OutputDestination;

public class InMemoryOutputDestination
        implements OutputDestination {

    private final List<String> results = new ArrayList<>();

    public List<String> getResults() {
        return results;
    }

    @Override
    public String getLocation() {
        return "memory-output";
    }
}
