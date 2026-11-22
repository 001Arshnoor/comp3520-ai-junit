
package ca.tru.comp3520;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReturnPolicyTest {

    @Test
    void testJustBelowLowerBoundary() {
        assertFalse(ReturnPolicy.canReturn(-1));
    }

    @Test
    void testExactlyAtLowerBoundary() {
        assertTrue(ReturnPolicy.canReturn(0));
    }

    @Test
    void testJustAboveLowerBoundary() {
        assertTrue(ReturnPolicy.canReturn(1));
    }

    @Test
    void testWithinReturnPeriod() {
        assertTrue(ReturnPolicy.canReturn(15));
    }

    @Test
    void testJustBelowUpperBoundary() {
        assertTrue(ReturnPolicy.canReturn(29));
    }

    @Test
    void testExactlyAtUpperBoundary() {
        assertTrue(ReturnPolicy.canReturn(30));
    }

    @Test
    void testJustAboveUpperBoundary() {
        assertFalse(ReturnPolicy.canReturn(31));
    }

    @Test
    void testLargeNegativeDays() {
        assertFalse(ReturnPolicy.canReturn(-100));
    }

    @Test
    void testFarBeyondReturnPeriod() {
        assertFalse(ReturnPolicy.canReturn(100));
    }
}
