package StrategyPattern;

import Model.Customer;
import Model.Room;

/**
 * กลยุทธ์การคิดราคาแบบปกติ (ไม่มีส่วนลด)
 */

public class DefaultDiscount implements DiscountStrategy{
    
    

    @Override
    public double applyDiscount(Room room, Customer customer, double totalPrice) {
       return totalPrice;
    }
    
}
