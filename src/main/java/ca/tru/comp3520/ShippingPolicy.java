package ca.tru.comp3520;

public class ShippingPolicy {

    public static boolean qualifiesForFreeShipping(int orderTotalCents) {
        return orderTotalCents >= 5000;
    
}}
