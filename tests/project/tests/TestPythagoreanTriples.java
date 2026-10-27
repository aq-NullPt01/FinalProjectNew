package project.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import project.conceptual.ComputationAPI;
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

        assertEquals(Arrays.asList("3,4,5", "6,8,10"),result.getPythagoreanTriples());
    }

    @Test
    public void testMaximumValueOne() {

        ComputationAPIImpl computation = new ComputationAPIImpl();

        ComputationRequest request = () -> 1;

        ComputationResult result = computation.compute(request);

        assertEquals(Collections.emptyList(),result.getPythagoreanTriples());
    }

    @Test
    public void testMaximumValueFive() {

        ComputationAPIImpl computation = new ComputationAPIImpl();

        ComputationRequest request = () -> 5;

        ComputationResult result =computation.compute(request);

        assertTrue(result.getPythagoreanTriples().contains("3,4,5"));
    }
    /**
     * Tests that zero produces no Pythagorean triples.
     */
    @Test
    public void testZeroInput() {

        ComputationAPI api = new ComputationAPIImpl();

        ComputationRequest request = () -> 0;

        ComputationResult result = api.compute(request);

        assertNotNull(result);
        assertTrue(result.getPythagoreanTriples().isEmpty());
    }

    /**
     * Tests that a negative maximum produces no triples.
     */
    @Test
    public void testNegativeInput() {

        ComputationAPI api = new ComputationAPIImpl();

        ComputationRequest request = () -> -5;

        ComputationResult result = api.compute(request);

        assertNotNull(result);
        assertTrue(result.getPythagoreanTriples().isEmpty());
    }

    /**
     * Tests the value immediately below the first triple.
     */
    @Test
    public void testBelowMinimumTriple() {

        ComputationAPI api = new ComputationAPIImpl();

        ComputationRequest request = () -> 4;

        ComputationResult result = api.compute(request);

        assertNotNull(result);
        assertTrue(result.getPythagoreanTriples().isEmpty());
    }
    


    /**
     * Tests the first valid Pythagorean triple boundary.
     */
    @Test
    public void testFirstValidTriple() {

        ComputationAPI api = new ComputationAPIImpl();

        ComputationRequest request = () -> 5;

        ComputationResult result = api.compute(request);

        assertNotNull(result);

        assertEquals(Arrays.asList("3,4,5"),result.getPythagoreanTriples());
    }
    
}
