package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import StrategyPattern.PaymentStrategy;

/*class no 3 */
// กำหนดให้คลาสนี้เป็นเก็บ properties เป็น โมเดลเอาไว้ ให้ระบบอื่นเข้าถึงได้
//เก็บข้อมูลลูกค้า
public class Customer {
    private final String idCart ; // เก็บข้อมูลเลขบัตรประชาชน
    private final String firstnameCustomer ; // เก็บข้อมูลชื่อจริงลูกค้า
    private final String lastnameCustomer ; // เก็บข้อมูลนามสกุลลูกค้า
    private final LocalDate dateCheckin;  // เก็บวันเข้าพัก _/_/_ เก็บเป็น คศ
    private final LocalDate dateCheckout; // เก็บวันออก _/_/_ เก็บเป็น คศ
    private final LocalDate dateBooking ; // เก็บวันที่จอง
    private final String statusCustomer; // สถานะการมายืนยันการจอง หรือการใช้บริการ

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //กำหนดรูปแบบที่จะแปลง

    public Customer(String idCart, String firstnameCustomer,String lastnameCustomer, String checkin, String checkout, String booking , String statusCustomer){
        this.idCart = idCart;
        this.firstnameCustomer = firstnameCustomer;
        this.lastnameCustomer = lastnameCustomer;
        this.dateCheckin =  LocalDate.parse(checkin, formatter); //อันนี้คือ จะแปลงจาก String เป็น LocalDate เพราะว่า csv มันเก็บเป็น string แต่ถ้าจะใช้ในระบบก็ต้องแปลง
        this.dateCheckout =  LocalDate.parse(checkout, formatter);
        this.dateBooking = LocalDate.parse(booking, formatter);
        this.statusCustomer = statusCustomer;
    }

    // ค่อยปรับวิธีการชำระเงินข้อลูกค้าในฐานของมูล CSV
    // ในส่วนข้อฐานลูกค้า รูปแบบการชำระเงินน่าจะเข้ามาในนี้เพื่อจะได้สะดวกในการดึงฐานข้อมูลของลูกค้า
    private PaymentStrategy paymentStrategy;
    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    //อันนี้ให้ customerRepository บันทึกข้อมูลใน csv //ยังไม่จัดการ
    public String getPayment(){
        return paymentStrategy.getName();
    }

    //อันนี้มีให้ตัวของผู้ประกาศใช้งาน
    public PaymentStrategy getPaymentStrategy(){
        return paymentStrategy ;
    }

    /* 
    public void processPayment(){
        if (paymentStrategy != null  ) {
             throw new IllegalStateException("No payment method set for customer: " + firstnameCustomer);
        }
    }*/

    public String getidCart(){
        return idCart;
    }

    public String getFirstnameCustomer(){
        return firstnameCustomer;
    }

    public String getLastnameCustomer(){
        return lastnameCustomer;
    }

    public LocalDate getDateCheckin(){
        return dateCheckin ;
    }

    public LocalDate getDateCheckout(){
        return dateCheckout;
    }

    public LocalDate getDateBooking(){
        return dateBooking;
    }

    public String getStatusCustomer(){
        return statusCustomer;
    }

    public String getFullName(){
        return firstnameCustomer + " " + lastnameCustomer ;
    }

    //ใช้ดึงข้อมูลว่าจองก่อนเข้าพักจริงกี่วัน
    public int getDaysBeforeCheckin(){
        return (int) ChronoUnit.DAYS.between(dateBooking, dateCheckin);
    }

    //ใช้ดึงข้อมูลว่าพักกี่คืน
    public int getDateStay(){
        return (int) ChronoUnit.DAYS.between(dateCheckin, dateCheckout);
    }

}
