package project.process;

/**
 * Represents computation results that can be written to an output destination.
 */
public interface OutputData {

    /**
     * Gets the formatted output data.
     *
     * @return formatted output
     */
    String getData();
}