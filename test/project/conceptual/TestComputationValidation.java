
package project.conceptual;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestComputationValidation {

    private final ComputationAPIImpl api =
            new ComputationAPIImpl();

    @Test
    public void testNullRequest() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> api.compute(null));
    }

    @Test
    public void testNegativeInputReturnsEmptyList() {

        ComputationAPI api = new ComputationAPIImpl();

        ComputationRequest request = () -> -5;

        ComputationResult result = api.compute(request);

        assertNotNull(result);

        assertTrue(result.getPythagoreanTriples().isEmpty());
    }
    @Test
    public void testValidMaximumValue() {

        ComputationRequest request = () -> 5;

        ComputationResult result = api.compute(request);

        Assertions.assertEquals(5, result.getInput());

        Assertions.assertTrue(
                result.getPythagoreanTriples()
                        .contains("3,4,5"));
    }
}
