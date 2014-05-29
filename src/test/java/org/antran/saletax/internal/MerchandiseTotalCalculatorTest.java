package org.antran.saletax.internal;

import static org.junit.Assert.*;

import org.antran.saletax.api.Categories;
import org.antran.saletax.api.IAmount;
import org.antran.saletax.api.ICart;
import org.antran.saletax.api.ICartCalculator;
import org.junit.Test;

public class MerchandiseTotalCalculatorTest
{
    
    @Test
    public void test()
    {
        // given
        ICartCalculator merchandiseTotalCalculator = new MerchandiseTotalCalculator();
        
        ICart cart = new Cart();
        cart.add(new Product("12.49", Categories.BOOK), 1);
        cart.add(new Product("14.99"), 1);
        cart.add(new Product("0.85", Categories.FOOD), 1);
        
        // when
        IAmount amount = merchandiseTotalCalculator.calculate(cart);
        
        // then
        assertEquals(new Amount("28.33"), amount);
    }
    
}
