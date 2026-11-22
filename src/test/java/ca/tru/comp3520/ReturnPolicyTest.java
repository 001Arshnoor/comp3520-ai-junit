package ca.tru.comp3520;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReturnPolicyTest {

    @Test
    void testNegativeDays() {
        assertFalse(ReturnPolicy.canReturn(-1));
    }

    @Test
    void testLargeNegativeDays() {
        assertFalse(ReturnPolicy.canReturn(-100));
    }

    @Test
    void testZeroDays() {
        assertTrue(ReturnPolicy.canReturn(0));
    }

    @Test
    void testOneDayAfterPurchase() {
        assertTrue(ReturnPolicy.canReturn(1));
    }

    @Test
    void testWithinReturnPeriod() {
        assertTrue(ReturnPolicy.canReturn(15));
    }

    @Test
    void testJustBelowReturnDeadline() {
        assertTrue(ReturnPolicy.canReturn(29));
    }

    @Test
    void testExactlyAtReturnDeadline() {
        assertTrue(ReturnPolicy.canReturn(30));
    }

    @Test
    void testJustAboveReturnDeadline() {
        assertFalse(ReturnPolicy.canReturn(31));
    }

    @Test
    void testFarBeyondReturnDeadline() {
        assertFalse(ReturnPolicy.canReturn(100));
    }

    @Test
    void testMinimumIntegerValue() {
        assertFalse(ReturnPolicy.canReturn(Integer.MIN_VALUE));
    }

    @Test
    void testMaximumIntegerValue() {
        assertFalse(ReturnPolicy.canReturn(Integer.MAX_VALUE));
    }
}