package StrategyPattern;

import Model.Customer;
import Model.Room;

/**
 * กลยุทธ์ส่วนลด 15% เมื่อจองล่วงหน้า 30 วัน และ 25% เมื่อจองล่วงหน้า 60 วัน
 */


public class EarlyBirdDiscount implements DiscountStrategy{

    @Override
    public double applyDiscount(Room room, Customer customer) {
        if (customer.getDaysBeforeCheckin()>= 60) {
            return room.getPrice() * 0.75; // ลด 25 %

        }else if (customer.getDaysBeforeCheckin()>= 30) {
            return room.getPrice() * 0.85; // ลด 15 %

        } else return room.getPrice();
        
    }
    
}
