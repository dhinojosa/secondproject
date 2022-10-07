package org.frb.kc.iloveotters;

import org.junit.Test;

import java.math.BigDecimal;

public class FloatingPointArithmeticTest {

    @Test
    public void testTheProblemWithUsingFloatingPointForMoney() {
        double dollar = 1.00;
        double dime = 0.10;
        int number = 7;
        System.out.println(
            "A dollar less " + number + " dimes is $" +
                (dollar - number * dime)
        );
    }

    @Test
    public void testBigDecimal() {
        BigDecimal bigDecimal = new BigDecimal("3.12");
        BigDecimal result = bigDecimal.multiply(new BigDecimal("2.0"));
        System.out.println(result);
    }

    @Test
    public void testAnotherWayToDealWithMoney() {
        long pennies = 10000L;
    }
}
