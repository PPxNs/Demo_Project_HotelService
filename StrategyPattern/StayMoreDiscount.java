package StrategyPattern;

import Model.Customer;
import Model.Room;

/**
 * กลยุทธ์ส่วนลด 10% เมื่อเข้าพัก 2 คืน และ 20% เมื่อเข้าพัก 3 คืนขึ้นไป
 */


public class StayMoreDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(Room room, Customer customer) {
        if (customer.getDateStay() >= 3) {
            return room.getPrice() * 0.8; // ลด 20 %

        }else if (customer.getDateStay() == 2) {
            return room.getPrice() * 0.9; // ลด 10 %

        } else return room.getPrice();
    }
}
