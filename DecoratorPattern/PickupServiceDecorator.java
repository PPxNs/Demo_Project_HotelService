package DecoratorPattern;
import FactoryMethodPattern.*;

/**
 *  Concrete Decorators: บริการรับส่ง - บาท แก้ปัญหาด้วยการคิดแบบ เหมาต่อห้อง ห้องละ 300 บาท
 */
//มันยังมีความไม่ยืดหยุ่นในเรื่องของจำนวนคน

public class PickupServiceDecorator extends DepositDecorator{

    public PickupServiceDecorator(DepositRoom wrappedDepositRoom) {
        super(wrappedDepositRoom);
    }
    public double getPrice(){
        return super.getPrice() + 300.0; 
    }

    public String getDescription(){
        return super.getDescription() + " + Pickup Service";
    }
    
}
