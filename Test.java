import DecoratorPattern.*;
import FactoryMethodPattern.*;
import Model.*;
import StrategyPattern.*;
import ObserverPattern.*;

public class Test {

    // ยังมีความไม่สมเหตุสมผลการเชื่อมของห้องและลูกต้า //ขอคิดวิธี
    public static void main(String[] args) {
        System.out.println("--- Hotel System Simulation ---");

        // --- 1. Setup ---
        // สร้างห้อง
        Room K1 = new Room(456, "Double room", 3000, "empty");
        K1.setDepositRoom(new DoubleroomType());
        Room K2 = new Room(598, "Suite", 5000, "booking");
        K2.setDepositRoom(new SuiteType());

        RoomRepository roomRepo = new RoomRepository();
        CustomerRepository customerRepo = new CustomerRepository();
        DepositFactory depositFactory = new DepositFactory();
        

        // --- 2. สร้างลูกค้า ---
        Customer customer1 = new Customer(
            1234567891233L, "John", "Doe",
            "2025-09-11", "2025-09-12", "2025-08-10",
            "Confirmed"
        );
        customer1.setPaymentStrategy(new CreditCardPayment("4569873"));

        //L บอกว่านี่ long no int
        Customer customer2 = new Customer(
             987654321156L, "Jane", "Smith",
            "2025-09-11", "2025-09-12", "2025-08-10",
            "Confirmed"
        );
        
        //สร้างโรงงานก่อนห่อ เป็นตัวของประเภทห้อง
        DepositRoom depositType = depositFactory.createSimpDepositRoom(K1);
            
        // "ห่อ" ทับด้วยบริการประกันของสูญหาย
        depositType = new InsuranceDecorator(depositType);

        // "ห่อ" ด้วยบริการมื้ออาหาร
        depositType = new MealDecorator(depositType, 1);

        // "ห่อ" ด้วยบริการรับส่ง
        depositType = new PickupServiceDecorator(depositType);
        K1.setDepositRoom(depositType);
        

        customer2.setPaymentStrategy(new PromptpayPayment());

        // --- 3. เก็บห้องและลูกค้า ---

        roomRepo.addRoom(K1.getNumberRoom(), K1.getType(), K1.getPrice(), K1.getStatus());
        roomRepo.addRoom(K2.getNumberRoom(), K2.getType(), K2.getPrice(), K2.getStatus());

        customerRepo.addCustomer(K1.getNumberRoom(),customer2);
        customerRepo.addCustomer(K1.getNumberRoom(),customer2);

        // --- 4. Observer ---
        BillObserver billObserver = new BillObserver(customerRepo);

        // --- 5. จำลองการแจ้งเตือนออกบิล ---
        billObserver.update(K1, customer1);
    }
}
