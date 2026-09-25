package project.network;

import project.process.InputSource;
import project.process.OutputDestination;

/**
 * Describes a computation job requested by the user.
 */
public interface JobRequest {

    /**
     * Gets the source containing the input integer.
     *
     * @return input source
     */
    InputSource getInputSource();

    /**
     * Gets the destination for the computation results.
     *
     * @return output destination
     */
    OutputDestination getOutputDestination();

    /**
     * Gets the delimiters used to format results.
     *
     * @return result delimiters
     */
    ResultDelimiters getDelimiters();
}
