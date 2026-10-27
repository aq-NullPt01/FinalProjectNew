package project.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import project.conceptual.ComputationAPI;
import project.conceptual.ComputationAPIImpl;
import project.conceptual.ComputationRequest;
import project.conceptual.ComputationResult;

/**
 * Smoke tests for the computation API.
 */
public class TestComputationAPI {

    /**
     * Checks that the computation API produces a result.
     */
    @Test
    public void testComputationAPI() {

        ComputationAPI api = new ComputationAPIImpl();

        ComputationRequest request = () -> 10;

        ComputationResult result = api.compute(request);

        assertNotNull(result);

        assertTrue(result.getPythagoreanTriples().contains("3,4,5"));
    }
}
