package StrategyPattern;
import Model.Customer;
import Model.Room;

/**
 * Interface สำหรับกลยุทธ์ส่วนลด
 */

public interface DiscountStrategy{
    public double applyDiscount(Room room, Customer customer);
}
