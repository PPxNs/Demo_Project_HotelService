package DecoratorPattern;
import FactoryMethodPattern.*;

/**
 * Abstract Decortor สำหรับห่อหุ้ม DepositRoom
 */
public abstract class DepositDecorator implements DepositRoom{

    protected DepositRoom wrappedDepositRoom;

    public DepositDecorator(DepositRoom wrappedDepositRoom){
        this.wrappedDepositRoom = wrappedDepositRoom ; 
    }

    public double getPrice(){
        return wrappedDepositRoom.getCost();
    }

    public String getDescription(){
        return wrappedDepositRoom.getDescription();
    }
}