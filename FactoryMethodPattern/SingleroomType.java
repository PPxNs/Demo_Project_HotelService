package FactoryMethodPattern;

public class SingleroomType implements DepositRoom{

    @Override
    public String getDescription() {
        return "Deposit for the Single room --> 500.0" ;
    }

    @Override
    public double getCost() {
        return 500.0 ;
    }

    
    
}
