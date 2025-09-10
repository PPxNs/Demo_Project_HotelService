package DecoratorPattern;
import FactoryMethodPattern.*;

/**
 *  Concrete Decorators: บริการประกันของสูญหาย 1000 บาท
 */
public class InsuranceDecorator extends DepositDecorator {


    public InsuranceDecorator(DepositRoom wrappedDepositRoom) {
        super(wrappedDepositRoom);
        
    }

    public double getPrice(){
        return super.getPrice() + 1000.0; 
    }
    public String getDescription(){
        return super.getDescription() + " + Insurance";
    }
    
}
