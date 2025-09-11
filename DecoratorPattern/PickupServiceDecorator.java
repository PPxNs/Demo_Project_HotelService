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
   
    public String getDescription(){
        return super.getDescription() + "\n + Pickup Service            --> 300.00" ;
    }
    @Override
    public double getCost() {
         return super.getPrice() + 300.00;

    }
    
}
