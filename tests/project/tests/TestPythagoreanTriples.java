package project.tests;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import project.conceptual.ComputationAPIImpl;
import project.conceptual.ComputationRequest;
import project.conceptual.ComputationResult;

public class TestPythagoreanTriples {

    @Test
    public void testMaximumValueTen() {

        ComputationAPIImpl computation = new ComputationAPIImpl();

        ComputationRequest request = () -> 10;

        ComputationResult result = computation.compute(request);

        assertEquals(10, result.getInput());

        assertEquals( Arrays.asList("3,4,5", "6,8,10"), result.getPythagoreanTriples());
    }

    @Test
    public void testMaximumValueOne() {

        ComputationAPIImpl computation = new ComputationAPIImpl();

        ComputationRequest request = () -> 1;

        ComputationResult result = computation.compute(request);

        assertEquals( Collections.emptyList(), result.getPythagoreanTriples());
    }

    @Test
    public void testMaximumValueFive() {

        ComputationAPIImpl computation = new ComputationAPIImpl();

        ComputationRequest request = () -> 5;

        ComputationResult result = computation.compute(request);

        assertTrue(result.getPythagoreanTriples().contains("3,4,5"));
    }
}