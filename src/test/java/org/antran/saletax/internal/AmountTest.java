package org.antran.saletax.internal;

import static org.junit.Assert.*;

import org.antran.saletax.api.IAmount;
import org.junit.Test;

public class AmountTest
{
    
    @Test
    public void shouldAddAmount()
    {
        IAmount amount = new Amount("0.00");
        IAmount sum = amount.add(new Amount("10.00"));
        
        assertEquals(new Amount("10.00"), sum);
    }
    
    @Test
    public void shouldGetPercentage()
    {
        assertEquals(new Amount("1.00"), new Amount("10.00").percent(0.1));
        assertEquals(new Amount("2.00"), new Amount("20.00").percent(0.1));
        assertEquals(new Amount("1.05"), new Amount("10.50").percent(0.1));
    }
    
    @Test
    public void shouldMultiply()
    {
        assertEquals(new Amount("40.00"), new Amount("20.00").times(2));
    }
    
}
