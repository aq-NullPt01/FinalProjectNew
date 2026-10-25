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

        InputSource mockSource = mock(InputSource.class);

        DataStorageAPIImpl storage =   new DataStorageAPIImpl();

        IntegerData data = storage.readInputData(mockSource);

        assertNotNull(data);
    }
}
