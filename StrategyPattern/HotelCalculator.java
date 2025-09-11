package StrategyPattern;
import Model.*;

public class HotelCalculator {
    public double calculateFinalPrice(Room room, Customer customer, DiscountStrategy strategy){
        double roomPrice = room.getPrice();
    
        return strategy.applyDiscount(room, customer, roomPrice);
    }
}
