package org.antran.saletax.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.antran.saletax.api.ICart;
import org.antran.saletax.api.ICartItem;
import org.antran.saletax.api.IProduct;

public class Cart implements ICart
{
    private final List<ICartItem> items = new ArrayList<ICartItem>();
    
    public void add(IProduct product, int qty)
    {
        items.add(new CartItem(product, qty));
    }
    
    public int size()
    {
        return items.size();
    }
    
    public Iterator<ICartItem> iterator()
    {
        return items.iterator();
    }
    
}
