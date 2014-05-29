package org.antran.saletax.internal;

import org.antran.saletax.api.IAmount;
import org.antran.saletax.api.ICartItem;
import org.antran.saletax.api.ITaxPolicy;

public class ImportedTaxPolicy implements ITaxPolicy
{
    private double taxRate;
    
    public ImportedTaxPolicy(double taxRate)
    {
        this.taxRate = taxRate;
    }
    
    public IAmount tax(ICartItem item)
    {
        if (item.product().imported())
        {
            return item.product().price().percent(taxRate).times(item.qty());
        }
        return Amount.ZERO;
    }
    
}
