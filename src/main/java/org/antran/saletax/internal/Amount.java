package org.antran.saletax.internal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.antran.saletax.api.IAmount;

public class Amount implements IAmount
{
    private static final String USD = "USD";
    
    public static final Amount ZERO = new Amount("0.00");
    
    private BigDecimal value;
    private String currency;
    
    public Amount(String valueAsString)
    {
        BigDecimal result = new BigDecimal(valueAsString);
        result = roundAmount(result);
        
        this.value = result;
        this.currency = USD;
    }
    
    public Amount(BigDecimal value)
    {
        BigDecimal result = new BigDecimal(value.toString());
        result = roundAmount(result);
        
        this.value = result;
        this.currency = USD;
    }
    
    private BigDecimal roundAmount(BigDecimal result)
    {
        result = result.setScale(2, RoundingMode.HALF_UP);
        result = result.round(new MathContext(2, RoundingMode.HALF_UP));
        return result;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((currency == null) ? 0 : currency.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Amount other = (Amount) obj;
        if (value == null)
        {
            if (other.value != null)
                return false;
        }
        else if (!value.equals(other.value))
            return false;
        if (currency == null)
        {
            if (other.currency != null)
                return false;
        }
        else if (!currency.equals(other.currency))
            return false;
        return true;
    }
    
    public BigDecimal value()
    {
        return value;
    }
    
    public IAmount add(IAmount amount)
    {
        return new Amount(this.value.add(amount.value()));
    }
    
    @Override
    public String toString()
    {
        return "Amount [value=" + value + ", currency=" + currency + "]";
    }
    
    public String currency()
    {
        return currency;
    }
    
    public IAmount percent(double percent)
    {
        BigDecimal result = value.multiply(new BigDecimal(percent));
        result = roundAmount(result);
        return new Amount(result);
    }
    
    public IAmount times(int time)
    {
        return new Amount(this.value.multiply(new BigDecimal(time)));
    }
}
