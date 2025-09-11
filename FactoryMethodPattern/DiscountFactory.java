package FactoryMethodPattern;

import Model.*;
import StrategyPattern.*;

//ให้มันสร้างโรงงานเลือกเอง
public class DiscountFactory {
    public static DiscountStrategy getStrategy(Room room, Customer customer) {
        
        if (customer.getDateStay() >= 2) {
            return new StayMoreDiscount();
        } else if (customer.getDaysBeforeCheckin() >= 30) {
            return new EarlyBirdDiscount();
        }
        return new DefaultDiscount();
    }
}
