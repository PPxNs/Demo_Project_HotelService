package StrategyPattern;
import Model.Customer;
import Model.Room;

/**
 * Interface สำหรับกลยุทธ์ส่วนลด
 */
// น่าจะมีความหยืดหยุ่นกว่านี้ที่ แอดมินสามารถยกเลิกส่วนลดหรือโปรได้
public interface DiscountStrategy{
    public double applyDiscount(Room room, Customer customer, double totalPrice);
}
