package org.antran.saletax.api;

public interface ITaxPolicy
{
    IAmount tax(ICartItem item);
}
