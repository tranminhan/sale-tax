package org.antran.saletax.api;

public class Receipt
{
    private final ICart cart;
    private final IAmount saleTax;
    private final IAmount total;
    
    public Receipt(ICart cart, IAmount saleTax, IAmount total)
    {
        this.cart = cart;
        this.saleTax = saleTax;
        this.total = total;
    }
    
    public IAmount saleTax()
    {
        return saleTax;
    }
    
    public IAmount total()
    {
        return total;
    }
    
}
