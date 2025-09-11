package FactoryMethodPattern;

public class SingleroomType implements DepositRoom{

    @Override
    public String getDescription() {
        return "Deposit for the Single room --> 500.00" ;
    }

    @Override
    public double getCost() {
        return 500.00 ;
    }

    
    
}
