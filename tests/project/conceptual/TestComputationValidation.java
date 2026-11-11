
package project.conceptual;

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
    public void testNegativeMaximumValue() {

        ComputationRequest request = () -> -5;

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> api.compute(request));
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
