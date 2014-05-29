package org.antran.saletax.internal;

import org.antran.saletax.api.ICartItem;
import org.antran.saletax.api.IProduct;

public class CartItem implements ICartItem
{
    
    private final IProduct product;
    private final int qty;
    
    public CartItem(IProduct product, int qty)
    {
        this.product = product;
        this.qty = qty;
    }
    
    public IProduct product()
    {
        return product;
    }
    
    public int qty()
    {
        return qty;
    }
    
}
