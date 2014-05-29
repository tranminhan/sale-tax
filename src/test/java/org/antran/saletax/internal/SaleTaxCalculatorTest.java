package org.antran.saletax.internal;

import static org.junit.Assert.assertEquals;

import org.antran.saletax.api.Categories;
import org.antran.saletax.api.IAmount;
import org.antran.saletax.api.ICart;
import org.antran.saletax.api.ICartCalculator;
import org.junit.Test;

public class SaleTaxCalculatorTest
{
    
    @Test
    public void shouldCalculateSaleTax()
    {
        // given
        ICart cart = new Cart();
        cart.add(new Product("12.49", Categories.BOOK), 1);
        cart.add(new Product("14.99"), 1);
        cart.add(new Product("0.85", Categories.FOOD), 1);
        
        // when
        ICartCalculator calculator = new CalculatorFactory().saleTaxCaculator();
        IAmount saleTax = calculator.calculate(cart);
        
        // then
        assertEquals(new Amount("1.50"), saleTax);
    }
    
    @Test
    public void shouldCalculateSaleTaxWithImportedProduct()
    {
        // given
        ICart cart = new Cart();
        cart.add(new Product("10.00", Categories.FOOD, true), 1);
        cart.add(new Product("47.50", Categories.OTHER, true), 1);
        
        // when
        ICartCalculator calculator = new CalculatorFactory().saleTaxCaculator();
        IAmount saleTax = calculator.calculate(cart);
        
        // then
        assertEquals(new Amount("7.65"), saleTax);
    }
    
    @Test
    public void shouldCalculateSaleTaxWithImportedProduct_2()
    {
        // given
        ICart cart = new Cart();
        cart.add(new Product("27.99", Categories.OTHER, true), 1);
        cart.add(new Product("18.99", Categories.OTHER), 1);
        cart.add(new Product("9.75", Categories.MEDICAL), 1);
        cart.add(new Product("11.25", Categories.FOOD, true), 1);
        
        // when
        ICartCalculator calculator = new CalculatorFactory().saleTaxCaculator();
        IAmount saleTax = calculator.calculate(cart);
        
        // then
        assertEquals(new Amount("6.70"), saleTax);
    }
}
