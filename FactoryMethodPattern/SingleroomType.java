package FactoryMethodPattern;

public class SingleroomType implements DepositRoom{

    @Override
    public double getPrice() {
        return 500.0 ;
    }

    @Override
    public String getDescription() {
        return "Deposit for the accommodation of the Single room" ;
    }

    
    
}
