package Service;
import java.io.*;

// class 2 ที่สร้าง
/* เวลาผู้ใช้เพิ่มข้อมูล (ผ่าน GUI) → เขียนบันทึกลงไฟล์ CSV (เป็นเหมือน "ฐานข้อมูลกลาง")
   จากนั้นอ่านไฟล์ CSV มาเก็บไว้ใน HashMap (dictionary) เวลาดึงข้อมูลเข้าจะได้ไม่ต้อง วนลูปอ่านข้อมูลทุกครั้งที่จะดึงข้อมมูล
*/
public class RoomService {

    //รับข้อมูลผ่าน gui มาเขียนใน csv
    public void Write_csv (int numberRoom, String type, double price,String status){
        File fi = null;
        FileWriter fw = null; 
        BufferedWriter bw = null;
        try {
            fi = new File(".//File/Room.csv");
            fw = new FileWriter(fi,true);
            bw = new BufferedWriter(fw);

            bw.write(numberRoom + "," + type + "," + price + "," + status ); // เขียนข้อมูลลงไปใน csv
            bw.newLine();                                                       // ขึ้นบรรทัดใหม่ใน csv
        } catch (Exception e) {
            // อาจมีการขึ้นแจ้งเตือนถ้ามีความผิดพลาดแบบ pop up
            System.out.println(e);
        }finally{ 
            try {
                bw.close(); 
                fw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }




    }

        
  
}
