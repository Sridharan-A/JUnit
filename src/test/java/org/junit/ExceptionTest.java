package org.junit;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;



public class ExceptionTest {


    @Test
    public void testExceptionAndState() {
        List<Object> list;
        list = new ArrayList<>();

        IndexOutOfBoundsException thrown = assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.add(1, new Object()));
        thrown.printStackTrace();

        // assertions on the thrown exception
        assertEquals("Index: 1, Size: 0", thrown.getMessage());
        // assertions on the state of a domain object after the exception has been thrown
        assertTrue(list.isEmpty());
    }
}
