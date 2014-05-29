package org.antran.saletax.internal;

import static org.junit.Assert.assertEquals;

import org.antran.saletax.api.Categories;
import org.antran.saletax.api.ICartItem;
import org.antran.saletax.api.ITaxPolicy;
import org.junit.Test;

public class ImportedTaxPolicyTest
{
    
    @Test
    public void shouldCalculateImportedTax()
    {
        ITaxPolicy importedTaxPolicy = new ImportedTaxPolicy(0.05);
        
        final ICartItem cartItemOf_1 = new CartItem(new Product("100.00", Categories.BOOK, true), 1);
        assertEquals(new Amount("5.00"), importedTaxPolicy.tax(cartItemOf_1));
        
        final ICartItem cartItemOf_2 = new CartItem(new Product("100.00", Categories.BOOK, true), 2);
        assertEquals(new Amount("10.00"), importedTaxPolicy.tax(cartItemOf_2));
        
        final ICartItem cartItemOf_notImported = new CartItem(new Product("100.00", Categories.BOOK, false), 2);
        assertEquals(new Amount("0.00"), importedTaxPolicy.tax(cartItemOf_notImported));
    }
    
}
