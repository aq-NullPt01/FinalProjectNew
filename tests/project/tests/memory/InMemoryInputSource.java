package project.tests.memory;

import java.util.ArrayList;
import java.util.List;

import project.process.InputSource;



public class InMemoryInputSource {

    private final List<Integer> values;

    public InMemoryInputSource(List<Integer> values) {
        this.values = new ArrayList<>(values);
    }

    public List<Integer> getValues() {
        return values;
    }

    @Override
    public String getLocation() {
        return "memory-input";
    }

}
