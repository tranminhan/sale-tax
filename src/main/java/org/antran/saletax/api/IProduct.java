package org.antran.saletax.api;


public interface IProduct
{
    
    IAmount price();

    Categories category();

    Boolean imported();
    
}
