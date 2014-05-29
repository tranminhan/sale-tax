package org.antran.saletax.internal;

import org.antran.saletax.api.IAmount;
import org.antran.saletax.api.ICart;
import org.antran.saletax.api.ICartCalculator;
import org.antran.saletax.api.ICartItem;

public class MerchandiseTotalCalculator implements ICartCalculator
{
    
    public IAmount calculate(ICart cart)
    {
        IAmount result = Amount.ZERO;
        
        for (ICartItem item : cart)
        {
            result = result.add(item.product().price());
        }
        return result;
    }
    
}
