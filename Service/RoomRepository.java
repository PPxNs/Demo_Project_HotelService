package Service;

import java.io.*;
import java.util.HashMap;

// คลาสที่ 3 ที่สร้าง 
/*
 * จะสร้าง dictionary hash map มาช่วยเก็บข้อมูล โกดัง จะได้เข้าถึงข้อมูลได้เร็วมากขึ้น
 * https://marcuscode.com/lang/java/hashmap เว็บที่ช่วยเรียนรู้
 */

 // แก้ไข้เพิ่มเติมตรงส่วนของข้อความแจ้ง exception ทุกอัน

public class RoomRepository {
    HashMap<Integer, Room > map = new HashMap<Integer, Room>(); // สร้าง hash map มีตัวของ key เป็น Integer และ value เป็น Room (เริ่มแรกจะใช้ String แต่น่าจะเข้าถึงข้อมูลลำบากขึ้น)
    //คิดว่าอาจจะต้องเผื่อกรณีที่จะเพิ่ม ลบ แก้ data ด้วย 

    /*  แอบรู้สึกกังวลตรงถ้าเราดึงข้อมูล csv มาแล้ว แล้วลบภายหลังเฉพาะใน hash เวลา add ค่าแล้ว ใด ๆ มาแล้วต้องอ่าน csv ใหม่อีกรอบ ก็จะ add ค่าซ้ำซ้อนได้   
    คิดว่าจะมีการจดจำลำดับไฟล์ล่าสุดก็คงจะดี ข้อดีคือ เราเหมือนมีไฟล์ csv เป็นตัวประวัติของการบันทึกข้อมูลข้อโรงแรมเกี่ยวกับการเข้าใช้ การเปิดบริการ 
    อีกทั้งสามารถแก้ไขเฉพาะข้อมูลห้องนั้น ๆ โดยไม่มี key,value ซ้ำซ้อนด้วย (แนวคิดตั้งต้น)

    ตอนนี้เราเปลี่ยนมาเขียนทับไฟล์แทน (ทับไฟล์เก่าหลังปิดระบบ = ข้อมูลอัทเดทล่าสุดทุกครั้ง)) ป้องกันข้อมูลหายหลังปิดโปรแกรม ส่วนเพิ่ม ลบ แก้ไขห้องจะแก้ผ่านคีย์โดยตรง 
    และมีการเคลียร์คีย์ทุกครั้งเมื่อมีการปิดระบบแล้ว
    */

    //ดึงข้อมูลมาดึงข้อมูลของ csv เข้ามาเก็บใน hash
    // ค่อยเพิ่มเติมตรงจุด แจ้ง exception กรณีไม่เจอไฟล์
    public void loadFromCSV(){
        File fi = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fi = new File(".//File/Room.csv");
            fr = new FileReader(fi);
            br = new BufferedReader(fr);
            String s ;
            while ((s = br.readLine()) != null) {
                String[] parts = s.split(","); //จะทำการสร้างสตริง เพื่อแบ่ง ข้อมูลตาม (,)
                if (parts.length == 4) {
                   int numberRoom = Integer.parseInt(parts[0]);
                   String type = parts[1] ; // ที่เป็นแบบนี้ได้เลยเพราะมันเป็นสตริงอยู่แล้ว
                   double price = Double.parseDouble(parts[2]);
                   String status = parts[3];
                if (!map.containsKey(numberRoom)) {
                    map.put(numberRoom, new Room(numberRoom, type, price, status));
                } 
                }
            }
        } catch (Exception e) {
            System.out.println();
        }finally {
            try {
                br.close(); fr.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    // เพิ่มห้อง อาจจะต้องมีตัวเช็คว่ามีห้องนั้นยัง ถ้ามีแล้วจะแอดห้องเพิ่มต้องแจ้งเตือน
    public void addRoom(){
        //คิดว่าน่าจะต้องมีอะไรเพิ่มความหยืดหยุ่นเจค แบบให้ไม่ยึดข้อมูลที่คีย์ผ่าน gui เผื่อกรณีต้องการปรับแต่งหน้า gui น่าจะลำบาก้ามามั่วแก้โค้ดในนี้
        //มีการดึงข้อมูลจาก gui มา //รอ gui
        //map.put(numberRoom, new Room(numberRoom, type, price, status))
    }

    // ลบห้อง  เราเลือกแก้ไขที่ hash เข้าถึงผ่านคีย์ อาจจะต้องมีตัว gui ให้เข้าถึงได้โดยตรงไม่ต้องใช้งานผ่านตัวแอด
    public void removeRoom(){
        //คิดว่าน่าจะต้องมีอะไรเพิ่มความหยืดหยุ่นเจค แบบให้ไม่ยึดข้อมูลที่คีย์ผ่าน gui เผื่อกรณีต้องการปรับแต่งหน้า gui น่าจะลำบาก้ามามั่วแก้โค้ดในนี้
        //มีการดึงข้อมูลจาก gui มา //รอ gui
        //map.remove(numberRoom);
    }

    // แก้ไขรายละเอียดของห้อง เราเลือกแก้ไขที่ hash เข้าถึงผ่านคีย์ อาจจะต้องมีตัว gui ให้เข้าถึงได้โดยตรงไม่ต้องใช้งานผ่านตัวแอด
    public void replaceRoom(){
        //คิดว่าน่าจะต้องมีอะไรเพิ่มความหยืดหยุ่นเจค แบบให้ไม่ยึดข้อมูลที่คีย์ผ่าน gui เผื่อกรณีต้องการปรับแต่งหน้า gui น่าจะลำบาก้ามามั่วแก้โค้ดในนี้
        //มีการดึงข้อมูลจาก gui มา //รอ gui
        //map.replace(numberRoom, type, price, status)
    }

    //เคลียร์ hash รีเซ็ตคลังข้อมูล
    public void removeAllRoom(){
        map.clear();
    }

    //มีระบบเหมือนปิดโปรแกรมแล้วเรา hash ไปเป็น csv ตอนปรับหรือ update database น่าจะง่ายขึ้น
    //ตอนแรกจะเข้าด้วย Enumerating the elements of the dictionary แต่มัน error เลยเปลี่ยนใหม่
    public void saveToCSV(){
        //กดปิดโปรแกรม จะเรียก method นี้
        File fi = null;
        FileWriter fw = null; 
        BufferedWriter bw = null;
        try {
            fi = new File(".//File/Room.csv");
            fw = new FileWriter(fi,false); // false เพราะจะได้ทับไฟล์เก่า
            bw = new BufferedWriter(fw);

            //จะวน for เข้าถึงตัว key ทั้งหมด
            for(Integer key : map.keySet()){
                Room room = map.get(key); // ดึงข้อมูลของคีย์นั้น ๆ มาใช้คลาสของ Room จะได้ดึงค่าข้อมูลมา
                bw.write(room.getNumberRoom() + ","+room.getType() + "," + room.getPrice() + "," + room.getStatus());
                bw.newLine();
            }
            
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
