package org.antran.saletax.internal;

import static org.junit.Assert.*;

import org.antran.saletax.api.Categories;
import org.antran.saletax.api.ICart;
import org.antran.saletax.internal.Cart;
import org.antran.saletax.internal.Product;
import org.junit.Test;

public class CartTest
{
    
    @Test
    public void shouldAddItemToCart()
    {
        // given
        ICart cart = new Cart();
        
        // when
        cart.add(new Product("10.99", Categories.BOOK), 1);
        
        // then
        assertEquals(1, cart.size());
        
        // add again
        cart.add(new Product("12.99", Categories.FOOD), 1);
        assertEquals(2, cart.size());
    }    
}
