package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

import Model.Customer;
import Model.CustomerRepository;
import Model.Room;

public class BillObserver implements RoomObserver{
    
    private final CustomerRepository customerRepository;

    // รับ CustomerRepository มาตอนสร้าง
    public BillObserver(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
  
    @Override
    public void update(Room room, Customer customer) {
        BillPrint(room , customer);
    }

    public void BillPrint(Room room, Customer customer){
        
        System.out.println("===== HOTEL BILL =====");
        System.out.println("Number Room: " + room.getNumberRoom());
        System.out.println("Type: " + room.getType());
        System.out.println("Booking: " + customer.getDateBooking());


        //ข้อมูลของลูกค้าที่พักห้องเดียวกันจะดึงมาอย่างไร 
        //ดึงข้อมูลจากการส่งเลขห้อง เราก็จะได้ list ของห้องนั้น ๆ แต่ต้องดูรายละเอียดอื่นต่อ

        List<Customer> customersInRoom = customerRepository.getCustomersInRoom(room.getNumberRoom());

        //กรองลูกค้าที่พักห้องนี้จาก Hash (วันเช็คอินตรง+วันจองตรง)

        List<Customer> stayingCustomers = new ArrayList<>();
        for(Customer c : customersInRoom){
            if (c.getDateCheckin().equals(customer.getDateCheckin())&&
                c.getDateBooking().equals(customer.getDateBooking())) {
                stayingCustomers.add(c); //ถ้าข้อมูลตรงเก็บไว้ในลิสก่อน
            }
        }

        if (!stayingCustomers.isEmpty()) {

            //ลูกค้าที่ 1 ที่อยู่ห้องนี้
            Customer mainGuest = stayingCustomers.get(0);
            System.out.println("Main Guest: " + mainGuest.getFullName());
            
            //กรณีมากกว่า 1 คน
            if (stayingCustomers.size()> 1) {
                System.out.println("Guest: ");
            for(int i = 1;i < stayingCustomers.size() ; i++){
                Customer g = stayingCustomers.get(i);
                System.out.println(g.getFullName()+"\n"); 
            }
            }
        } else {
            System.out.println("No valid guests found for this booking/check-in.");
        }

        System.out.println("Check-in: " + customer.getDateCheckin());
        System.out.println("Check-out: " + customer.getDateCheckout());
        System.out.println("----------------------");


        System.out.println("Room Price: " + room.getPrice()); // อยากให้แสดงราคาห้องที่ยังไม่มีการบวกมัดจำ


        if (room.getDepositRoom() != null) {
            // เราจะทำยังไงที่จะดึงข้อมูลหลังห่อ แสดงราคาของมัดจำ + service
            System.out.println("Room & Services: " + room.getDepositRoom().getDescription());
            System.out.printf("Total Price: %.2f\n", room.getDepositRoom().getPrice()); 
        } else {
            
            //แสดงราคารวมทั้งหมด
            System.out.printf("Total Price: %.2f\n", room.getPrice());
        }
        

        System.out.println("Payment Method: " + customer.getPaymentStrategy().getName());
        System.out.println("======================\n");

    }    
}
