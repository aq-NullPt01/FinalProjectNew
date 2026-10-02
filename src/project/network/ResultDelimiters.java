package project.network;

/**
 * Defines delimiters used when formatting computation results.
 */
public interface ResultDelimiters {

    /**
     * Gets the delimiter between an input and its result.
     *
     * @return input-result delimiter
     */
    String getInputResultDelimiter();

    /**
     * Gets the delimiter between separate results.
     *
     * @return result delimiter
     */
    String getResultDelimiter();

    /**
     * Provides the default delimiters.
     *
     * @return default result delimiters
     */
    static ResultDelimiters defaults() {
        return new ResultDelimiters() {

            @Override
            public String getInputResultDelimiter() {
                return ":";
            }

            @Override
            public String getResultDelimiter() {
                return ";";
            }
        
        };
        
        
    }
    
}

