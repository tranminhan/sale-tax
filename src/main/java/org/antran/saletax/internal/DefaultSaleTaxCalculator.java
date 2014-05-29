package org.antran.saletax.internal;

import org.antran.saletax.api.IAmount;
import org.antran.saletax.api.ICart;
import org.antran.saletax.api.ICartCalculator;
import org.antran.saletax.api.ICartItem;
import org.antran.saletax.api.ITaxPolicy;

public class DefaultSaleTaxCalculator implements ICartCalculator
{
    
    private final ITaxPolicy[] taxPolicies;
    
    public DefaultSaleTaxCalculator(ITaxPolicy[] taxPolicies)
    {
        this.taxPolicies = taxPolicies;
    }
    
    public IAmount calculate(ICart cart)
    {
        IAmount saleTax = Amount.ZERO;
        for (ICartItem item : cart)
        {
            for (ITaxPolicy policy : taxPolicies)
            {
                IAmount tax = policy.tax(item);
                saleTax = saleTax.add(tax);
            }
        }
        return saleTax;
    }
    
}
