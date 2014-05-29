package org.antran.saletax.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.antran.saletax.api.Categories;
import org.antran.saletax.api.ICartCalculator;
import org.antran.saletax.api.ICalculatorFactory;
import org.antran.saletax.api.IReceiptMaker;
import org.antran.saletax.api.ITaxPolicy;

public class CalculatorFactory implements ICalculatorFactory
{
    private static final double STANDARD_TAX = 0.1;
    private static final double STANDARD_IMPORTED_TAX = 0.05;
    
    private static final List<Categories> EXTEMPT_CATEGORIES = Collections.unmodifiableList(
            Arrays.asList(
                    Categories.BOOK,
                    Categories.FOOD,
                    Categories.MEDICAL
                    ));
    
    public ICartCalculator saleTaxCaculator()
    {
        return new DefaultSaleTaxCalculator(
                new ITaxPolicy[] {
                        new DefaultTaxPolicy(STANDARD_TAX, EXTEMPT_CATEGORIES),
                        new ImportedTaxPolicy(STANDARD_IMPORTED_TAX)
                });
    }
    
    public IReceiptMaker receiptMaker()
    {
        return new TotalCartCalculator(
                saleTaxCaculator(),
                new MerchandiseTotalCalculator());
    }
    
}
