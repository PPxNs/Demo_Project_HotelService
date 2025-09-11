package DecoratorPattern;
import FactoryMethodPattern.*;

/**
 *  Concrete Decorators: บริการประกันของสูญหาย 1000 บาท
 */
public class InsuranceDecorator extends DepositDecorator {


    public InsuranceDecorator(DepositRoom wrappedDepositRoom) {
        super(wrappedDepositRoom);
        
    }

    public String getDescription(){
        return super.getDescription() + "\n + Insurance      --> 1000.0";
    }

    @Override
    public double getCost() {
        return super.getPrice() + 1000.0; 
    }
    
}
