package project.tests;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import project.process.DataStorageAPI;
import project.process.DataStorAPIImpl;
import project.process.InputSource;
import project.process.IntegerData;

public class TestDataStorageAPI {

    @Test
    public void testReadInputPlaceholder() {

        DataStorageAPI api = new DataStorAPIImpl();

        // Mock the input source.
        InputSource source = mock(InputSource.class);

        IntegerData result = api.readInputData(source);

        assertNull(result);
    }
}
