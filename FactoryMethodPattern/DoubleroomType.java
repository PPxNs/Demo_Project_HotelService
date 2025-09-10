package FactoryMethodPattern;

public class DoubleroomType implements DepositRoom{

    @Override
    public double getPrice() {
        return 1500.0;
    }

    @Override
    public String getDescription() {
       return "Deposit for the accommodation of the Double room" ;
    }

   
    
}
