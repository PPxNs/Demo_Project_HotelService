package DecoratorPattern;
import java.math.BigDecimal;
import java.math.RoundingMode;

import FactoryMethodPattern.*;

/**
 *  Concrete Decorators: บริการประกันของสูญหาย 1000 บาท
 */
public class InsuranceDecorator extends DepositDecorator {


    public InsuranceDecorator(DepositRoom wrappedDepositRoom) {
        super(wrappedDepositRoom);
        
    }

    public String getDescription(){
        return super.getDescription() + "\n + Insurance                 --> 1000.00";
    }

    @Override
    public double getCost() {
        return new BigDecimal(super.getPrice() + 1000.0).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
    
}
