package project.process;

import java.util.List;

/**
 * Represents integer input data read from a data source.
 */
public interface IntegerData {

    /**
     * Gets the integer values contained in this data.
     *
     * @return the integer values
     */
    List<Integer> getValues();
}
