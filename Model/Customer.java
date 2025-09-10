package Model;

/*class no 3 */
// กำหนดให้คลาสนี้เป็นเก็บ properties เป็น โมเดลเอาไว้ ให้ระบบอื่นเข้าถึงได้
//เก็บข้อมูลลูกค้า
public class Customer {
    private int idCart ; // เก็บข้อมูลเลขบัตรประชาชน
    private String firstnameCustomer ; // เก็บข้อมูลชื่อจริงลูกค้า
    private String lastnameCustomer ; // เก็บข้อมูลนามสกุลลูกค้า
    private String dateCheckin;  // เก็บวันเข้าพัก _/_/_ เก็บเป็น คศ
    private String dateCheckout; // เก็บวันออก _/_/_ เก็บเป็น คศ
    private String statusCustomer; // สถานะการมายืนยันการจอง หรือการใช้บริการ

    public Customer(int idCart, String firstnameCustomer,String lastnameCustomer, String dateCheckin, String dateCheckout, String statusCustomer){
        this.idCart = idCart;
        this.firstnameCustomer = firstnameCustomer;
        this.lastnameCustomer = lastnameCustomer;
        this.dateCheckin = dateCheckin; 
        this.dateCheckout = dateCheckout;
        this.statusCustomer = statusCustomer;
    }

    public int getidCart(){
        return idCart;
    }

    public String getFirstnameCustomer(){
        return firstnameCustomer;
    }

    public String getLastnameCustomer(){
        return lastnameCustomer;
    }

    public String getDateCheckin(){
        return dateCheckin ;
    }

    public String getDateCheckout(){
        return dateCheckout;
    }

    public String getStatusCustomer(){
        return statusCustomer;
    }

}
