package org.antran.saletax.internal;

import org.antran.saletax.api.IAmount;
import org.antran.saletax.api.ICart;
import org.antran.saletax.api.ICartCalculator;
import org.antran.saletax.api.IReceiptMaker;
import org.antran.saletax.api.Receipt;

public class TotalCartCalculator implements IReceiptMaker, ICartCalculator
{
    public TotalCartCalculator(
            ICartCalculator saleTaxCalculator,
            ICartCalculator merchandiseTotalCalator)
    {
        this.saleTaxCalculator = saleTaxCalculator;
        this.merchandiseTotalCalculator = merchandiseTotalCalator;
    }
    
    public Receipt makeReceipt(ICart cart)
    {
        IAmount saleTax = saleTaxCalculator.calculate(cart);
        IAmount total = this.calculate(cart);
        
        Receipt receipt = new Receipt(cart, saleTax, total);
        return receipt;
    }
    
    ICartCalculator saleTaxCalculator;
    ICartCalculator merchandiseTotalCalculator;
    
    public IAmount calculate(ICart cart)
    {
        IAmount result = Amount.ZERO;
        result = result.add(merchandiseTotalCalculator.calculate(cart));
        result = result.add(saleTaxCalculator.calculate(cart));
        return result;
    }
    
}
