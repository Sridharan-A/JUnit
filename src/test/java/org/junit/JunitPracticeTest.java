package org.junit;

import junit.framework.TestCase;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class JunitPracticeTest {
    BmiCalculator b;

    @Before
    public void initializeBefore() {
        b = new BmiCalculator();
    }

    @Test
    public void testBmiReturnFloatValueFromTwoFloatValue() {
        assertEquals(19.38f, b.calculate(1.7f, 56), .01);
    }

    @Test(expected = InvalidParameterException.class)
    public void testBmiReturnExceptionFromZeroValue() {
        b.calculate(0,0);
    }

    @Test
    public void testBmiReturnExceptionMessageFromZeroValue() {
        InvalidParameterException thrown = assertThrows(InvalidParameterException.class, () -> b.calculate(0, 0));
        assertEquals("Height and Weight should be greater than zero", thrown.getMessage());

    }

    @Test
    public void testBmiReturnExceptionFromZeroValueOfOneParameter() {
        InvalidParameterException thrown = assertThrows(InvalidParameterException.class, () -> b.calculate(0, 56));
        assertEquals("Height and Weight should be greater than zero", thrown.getMessage());


    }

    @Test
    public void testBmiReturnFloatValueFromTwoLargeFloatValue() {
        assertEquals(0.21f, b.calculate(186, 7385), 0.1);

    }


}


