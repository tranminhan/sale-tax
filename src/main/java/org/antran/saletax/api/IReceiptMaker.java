package org.antran.saletax.api;

public interface IReceiptMaker
{
    Receipt makeReceipt(ICart cart);
}