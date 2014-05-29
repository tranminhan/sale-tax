package org.antran.saletax.internal;

import org.antran.saletax.api.Categories;
import org.antran.saletax.api.IProduct;

public class Product implements IProduct
{
    
    private Amount price;
    private Categories category;
    private Boolean imported = false;
    
    public Product(String price, Categories category)
    {
        this.price = new Amount(price);
        this.category = category;
    }
    
    public Product(String price)
    {
        this.price = new Amount(price);
    }
    
    public Product(String price, Categories category, boolean imported)
    {
        this(price, category);
        this.imported = imported;
    }

    public Amount price()
    {
        return price;
    }
    
    public Categories category()
    {
        return category;
    }

    public Boolean imported()
    {
        return imported;
    }
    
}
