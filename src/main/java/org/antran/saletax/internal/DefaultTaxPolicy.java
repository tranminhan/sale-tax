package org.antran.saletax.internal;

import java.util.ArrayList;
import java.util.List;

import org.antran.saletax.api.Categories;
import org.antran.saletax.api.IAmount;
import org.antran.saletax.api.ICartItem;
import org.antran.saletax.api.ITaxPolicy;

public class DefaultTaxPolicy implements ITaxPolicy
{
    private final double taxRate;
    private final List<Categories> extemptCategories;
    
    public DefaultTaxPolicy(double taxRate, List<Categories> extemptCategories)
    {
        this.taxRate = taxRate;
        this.extemptCategories = new ArrayList<Categories>(extemptCategories);
    }
    
    public IAmount tax(ICartItem cartItem)
    {
        if (extemptCategories.contains(cartItem.product().category()))
        {
            return Amount.ZERO;
        }
        return cartItem.product().price().percent(taxRate).times(cartItem.qty());
    }
}
