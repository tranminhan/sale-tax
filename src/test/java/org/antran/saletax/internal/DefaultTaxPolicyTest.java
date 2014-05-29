package org.antran.saletax.internal;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.antran.saletax.api.Categories;
import org.antran.saletax.api.ICartItem;
import org.antran.saletax.api.ITaxPolicy;
import org.junit.Test;

public class DefaultTaxPolicyTest
{
    
    @Test
    public void shouldCalculateTax()
    {
        // given
        ITaxPolicy defaultTaxPolicy = new DefaultTaxPolicy(0.1, Arrays.asList(
                Categories.BOOK,
                Categories.FOOD,
                Categories.MEDICAL
                ));
        
        // then
        ICartItem itemOf_1 = new CartItem(new Product("10.00", Categories.FOOD, true), 1);
        assertEquals(new Amount("0.00"), defaultTaxPolicy.tax(itemOf_1));
        
        ICartItem itemOf_2 = new CartItem(new Product("10.00", Categories.FOOD, true), 2);
        assertEquals(new Amount("0.00"), defaultTaxPolicy.tax(itemOf_2));
        
        ICartItem taxableItemOf_1 = new CartItem(new Product("10.00", Categories.OTHER, true), 1);
        assertEquals(new Amount("1.00"), defaultTaxPolicy.tax(taxableItemOf_1));
        
        ICartItem taxableItemOf_2 = new CartItem(new Product("10.00", Categories.OTHER, true), 2);
        assertEquals(new Amount("2.00"), defaultTaxPolicy.tax(taxableItemOf_2));
    }
    
}
