package org.antran.saletax.internal;

import static org.junit.Assert.*;

import org.antran.saletax.api.Categories;
import org.antran.saletax.api.ICart;
import org.antran.saletax.api.IReceiptMaker;
import org.antran.saletax.api.Receipt;
import org.antran.saletax.internal.Amount;
import org.antran.saletax.internal.Cart;
import org.antran.saletax.internal.TotalCartCalculator;
import org.antran.saletax.internal.Product;
import org.junit.Test;

public class CartCalculatorTest
{
    
    @Test
    public void shouldCreateReceipt()
    {
        // given
        IReceiptMaker receiptMaker = new CalculatorFactory().receiptMaker();
        
        ICart cart = new Cart();
        cart.add(new Product("12.49", Categories.BOOK), 1);
        cart.add(new Product("14.99"), 1);
        cart.add(new Product("0.85", Categories.FOOD), 1);
        
        // when
        Receipt receipt = receiptMaker.makeReceipt(cart);
        
        // then
        assertNotNull(receipt);
        assertEquals(new Amount("1.50"), receipt.saleTax());
        assertEquals(new Amount("29.83"), receipt.total());
    }
}
