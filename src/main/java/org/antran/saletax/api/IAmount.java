package org.antran.saletax.api;

import java.math.BigDecimal;

public interface IAmount
{
    BigDecimal value();
    
    String currency();
    
    IAmount add(IAmount amount);
    
    IAmount percent(double percent);
    
    IAmount times(int time);
    
}
