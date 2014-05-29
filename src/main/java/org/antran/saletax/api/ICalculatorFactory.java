package org.antran.saletax.api;

public interface ICalculatorFactory
{
    ICartCalculator saleTaxCaculator();
    
    IReceiptMaker receiptMaker();
}
