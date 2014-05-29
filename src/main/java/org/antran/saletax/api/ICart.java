package org.antran.saletax.api;


public interface ICart extends Iterable<ICartItem>
{
    
    void add(IProduct product, int qty);
    
    int size();
    
}
