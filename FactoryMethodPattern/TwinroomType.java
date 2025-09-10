package FactoryMethodPattern;

public class TwinroomType implements DepositRoom{

    @Override
    public double getPrice() {
        return 1000.0;
    }

    @Override
    public String getDescription() {
       return "Deposit for the accommodation of the Twin room" ;
    }

    
    
}
