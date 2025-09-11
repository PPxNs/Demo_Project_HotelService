package FactoryMethodPattern;

public class SuiteType implements DepositRoom{

    @Override
    public String getDescription() {
       return "Deposit for the suite --> 3000.00" ;
    }

    @Override
    public double getCost() {
        return 3000.00 ;
    }

    
    
}
