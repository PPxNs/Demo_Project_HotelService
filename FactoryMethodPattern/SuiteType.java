package FactoryMethodPattern;

public class SuiteType implements DepositRoom{

    @Override
    public double getPrice() {
        return 3000.0 ;
    }

    @Override
    public String getDescription() {
       return "Deposit for the accommodation of the suite" ;
    }

    
    
}
