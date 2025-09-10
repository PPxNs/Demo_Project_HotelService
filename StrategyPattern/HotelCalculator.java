package StrategyPattern;
import Model.*;

public class HotelCalculator {
    public double calculateFinalPrice(Room room, Customer customer, DiscountStrategy strategy){
        return strategy.applyDiscount(room, customer);
    }
}
