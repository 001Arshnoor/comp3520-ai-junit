package ca.tru.comp3520;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShippingPolicyTest {

    @Test
    void testOrderBelowThreshold() {
        assertFalse(ShippingPolicy.qualifiesForFreeShipping(4999));
    }

    @Test
    void testOrderAtThreshold() {
        assertTrue(ShippingPolicy.qualifiesForFreeShipping(5000));
    }

    @Test
    void testOrderAboveThreshold() {
        assertTrue(ShippingPolicy.qualifiesForFreeShipping(5001));
    }

    @Test
    void testZeroOrderTotal() {
        assertFalse(ShippingPolicy.qualifiesForFreeShipping(0));
    }

    @Test
    void testNegativeOrderTotal() {
        assertFalse(ShippingPolicy.qualifiesForFreeShipping(-100));
    }

    @Test
    void testLargeOrderTotal() {
        assertTrue(ShippingPolicy.qualifiesForFreeShipping(100000));
    }
}
    

