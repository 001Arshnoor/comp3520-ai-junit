package ca.tru.comp3520;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShippingPolicyTest {

    @Test
    void testJustBelowFreeShippingThreshold() {
        assertFalse(ShippingPolicy.qualifiesForFreeShipping(4999));
    }

    @Test
    void testExactlyAtFreeShippingThreshold() {
        assertTrue(ShippingPolicy.qualifiesForFreeShipping(5000));
    }

    @Test
    void testJustAboveFreeShippingThreshold() {
        assertTrue(ShippingPolicy.qualifiesForFreeShipping(5001));
    }

    @Test
    void testNegativeOrderTotal() {
        assertFalse(ShippingPolicy.qualifiesForFreeShipping(-1));
    }

    @Test
    void testZeroOrderTotal() {
        assertFalse(ShippingPolicy.qualifiesForFreeShipping(0));
    }

    @Test
    void testJustAboveZero() {
        assertFalse(ShippingPolicy.qualifiesForFreeShipping(1));
    }

    @Test
    void testLargeOrderTotal() {
        assertTrue(ShippingPolicy.qualifiesForFreeShipping(100000));
    }

    @Test
    void testMinimumIntegerValue() {
        assertFalse(ShippingPolicy.qualifiesForFreeShipping(Integer.MIN_VALUE));
    }

    @Test
    void testMaximumIntegerValue() {
        assertTrue(ShippingPolicy.qualifiesForFreeShipping(Integer.MAX_VALUE));
    }
}