package ca.tru.comp3520;

public class ReturnPolicy {
    public static boolean canReturn(int daysSincePurchase) {
        return daysSincePurchase >= 0 && daysSincePurchase <= 30;
    }
}