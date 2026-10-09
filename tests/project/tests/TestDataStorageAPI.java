package project.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import project.process.DataStorageAPIImpl;
import project.process.InputSource;
import project.process.IntegerData;

public class TestDataStorageAPI {

    @Test
    public void testReadInputData() {

        // Create the real Data Storage implementation
        DataStorageAPIImpl storage = new DataStorageAPIImpl();

        // Mock the input source
        InputSource source = mock(InputSource.class);

        // Call the data storage method
        IntegerData data = storage.readInputData(source);

        // Verify that input data is returned
        assertNotNull(data);
    }
}
