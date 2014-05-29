package org.antran.saletax.internal;

import static org.junit.Assert.*;

import org.antran.saletax.api.Categories;
import org.antran.saletax.api.IProduct;
import org.antran.saletax.internal.Product;
import org.junit.Test;

public class ProductTest
{
    @Test
    public void shouldCreateProductWithPrice()
    {
        IProduct product = new Product("12.99");
        assertNotNull(product);
        assertEquals(new Amount("12.99"), product.price());
        assertFalse(product.imported());
    }
    
    @Test
    public void shouldCreateProductWithPriceAndCategories()
    {
        IProduct product = new Product("12.99", Categories.BOOK);
        assertNotNull(product);
        assertEquals(Categories.BOOK, product.category());
    }
    
    @Test
    public void shouldCreateImportedProduct()
    {
        IProduct product = new Product("12.99", Categories.BOOK, true);
        assertEquals(true, product.imported());
    }
}
