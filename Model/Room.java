package Model;

// class no. 1 ที่สร้าง
/*คิดว่าจะมีการเก็บข้อมูลอีกอย่างหนึ่ง โดยการเขียนลงใน csv ผ่านการแอดข้อมูลผ่าน gui จากนั้นดึงข้อมูลเก็บลงในตัว dictionary จะได้ไม่ต้องลูป หาลดเวลาการเข้าถึงข้อมูล
 * จากนันสามารดึงข้อมูลจากไฟล์ส่วนกลาง (hash) มายังคลาสนี้กรณีจะดึงไปใช้ในคลาส service อื่น ๆ
 */

// กำหนดให้คลาสนี้เป็นเก็บ properties เป็น โมเดลเอาไว้ ให้ระบบอื่นเข้าถึงได้
public class Room {
    private final int numberRoom ; // เก็บข้อมูลหมายเลยห้อง
    private final String type;    //เก็บข้อมูลห้องเดี่ยว ห้องคู่ หรือห้องชุด
    private final double price; // เก็บข้อมูลว่าห้องราคาเท่าไหร่
    private final String status; // เก็บข้อมูลสถานะห้องว่าง  ไม่ว่าง หรือมีคนจองแล้ว

    //Rep 
    // - numberRoom ต้องไม่เป็น null หรือ <= 0
    // - Type จะต้องไม่เป็นตัวเลข
    // - price >= 0 
    // 
    // AF 
    // - AF(numberRoom, type, price, availble)

    //รอสร้าง checkRep();
    public Room(int numberRoom, String type, double price , String status){
        this.numberRoom = numberRoom;
        this.type = type;
        this.price = price;
        this.status = status;
        //checkRep();  // ตรวจสอบความถูกต้องทุกครั้งที่สร้าง
    }

    public int getNumberRoom(){
        return numberRoom;
    }

    public String getType(){
        return type;
    }

    public double getPrice(){
        return price;
    }

    public String getStatus(){
        return status;
    }

    

}
