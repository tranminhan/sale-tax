package org.antran.saletax.internal;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class BigDecimalTest
{
    
    @Test
    public void test()
    {
        BigDecimal num1 = new BigDecimal("10.00");        
        BigDecimal num2 = new BigDecimal(2);
        BigDecimal multiply = num1.multiply(num2);
        System.out.println(multiply);
    }
    

    @Test
    public void test2()
    {
        BigDecimal num1 = new BigDecimal("10.00123");        
        num1 = num1.setScale(2, RoundingMode.HALF_UP);
        BigDecimal num2 = new BigDecimal(2);
        BigDecimal multiply = num1.multiply(num2);
        System.out.println(multiply);
    }
    
}
