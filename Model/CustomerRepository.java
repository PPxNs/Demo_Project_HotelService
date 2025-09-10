package Model;
/*
 * class no.4 จะเป็นคลังเก็บข้อมูลลูกค้า จะเก็บข้อมูลคล้ายห้องแต่จะใช้ key เป็นตัวหมายเลขห้อง
 */

import java.io.*;
import java.util.*;

public class CustomerRepository {
    //คีย์เราจะดึงฐานข้อมูลมาจาก room โดยตัวคีย์จะเป็นตัวของเลขห้องเชื่อมกับผู้เข้าใช้
    HashMap<Integer, List<Customer>> mapCustomer = new HashMap<>();
    

    // ให้ดึง hash มาอ่านได้
    public List<Customer> getCustomersInRoom(int numberRoom) {
        return mapCustomer.getOrDefault(numberRoom, new ArrayList<>());
    }

    //เพิ่มลูกค้าเข้าห้อง กำลังคิดว่า ถ้าทำเป็น dictionary แบบ linklist น่าจะดีกว่า เพราะมันต้องมีคนใช้ห้องเดียวกัน หลายคนได้
    public boolean addCustomer(int numberRoom, Customer customer){

            //putIfAbsent เราจะให้เพิ่ม key เพราะใน value เราไม่มีค่าของ key
            mapCustomer.putIfAbsent(numberRoom, new ArrayList<>());
            mapCustomer.get(numberRoom).add(customer); // เพราะมันเป็นลิส เลยใช้การ add
            return true;
    }
    
    
    /* ข้อสงสัย ถ้าเราลบ key ข้อมูลมันจะหายทั้งหมดมั้ยนะ หรือควรจะให้มีแค่ฟังก์ชัน แก้ไขข้อมูล แต่ถ้าลูกค้ายกเลิก 
           เราจะรู้ได้ไงล่ะ คิดว่าอาจจะเพิ่มเติมตัว สถานะเข้ามา จะได้รู้ว่าลูกค้ามาเช็คอินยัง ถ้าไม่มาเช็คอินตามเวลาจะยกเลิกการจองอัตโนมัติ
           โดยยึดค่ามัดจำไว้ แต่ก็มีการเก็บข้อมูลเอาไว้ เพื่อเป็นประวัติ คิดว่าอาจจะไม่ต้องมีการลบ แต่มีการแก้ไขพอ หรือลบได้นะ เผื่อกรณีซ้ำซ้อน
           ค่อยประชุมอีกครั้ง
    */

    //ลบข้อมูลลูกค้าตามรหัสบัตร
    public boolean removeCustomer(int numberRoom, int idCart){
        if (mapCustomer.containsKey(numberRoom)) {
            /* อธิบาย : ดึงข้อมูล key ลบถ้า mapCustomer.getidCart() ตรงกับ idCart ที่ return เพราะมันเปรียบเทียบ ให้ค่า true พร้อมลบข้อมูลได้*/
            return mapCustomer.get(numberRoom).removeIf(c-> c.getidCart() == idCart);
        }
       
        return false;
    }

    //คิดว่าตรงหน้า gui เมื่อจะเข้าไปแก้ไขข้อมูลลูกค้าน่าจะมีการแสดงข้อมูลอยู่แล้วถ้าลูกค้าจะแก้ตรงไหนก็ส่งค่ามาบันทึกใหม่
    //แก้ไขข้อมูลลูกค้า
    public boolean replaceCustomer(int numberRoom,int idCart,Customer newCustomer){
        if (mapCustomer.containsKey(numberRoom)) {
            List<Customer> customers = mapCustomer.get(numberRoom);
            for(int i = 0 ; i < customers.size(); i++){
                if (customers.get(i).getidCart() == idCart) {
                    customers.set(i, newCustomer);
                    return true;
                }
            }
        }        
        return false;
    }

    //เคลียร์ hash รีเซ็ตคลังข้อมูล
    public void removeAllCustomer(){
        mapCustomer.clear();
    }

    // คิดว่าควรมีเขียนใน csv ด้วยว่าห้องนี้ ประวัตลูกค้าอะไรบลา ๆ 
    /*  true เพราะจะได้เก็บไฟล์ข้อมูลการเข้าพักของลูกค้าได้ แต่ถ้ารับหลายรอบข้อมูลจะซึ้าเยอะ
        แต่ก็มีข้อย้อนแย้งเพราะถ้าเราบันทึกแก้ใน hash เราจะบันทึกไปทีเดียว แต่อาจจะแบ่ง 2 ไฟล์ 
        คือเขียนต่อไปเลย แต่เก็บเป็น file ประวัติลูกค้า ส่วนตัวของ เก็บข้อมูลก่อนเพื่อให้ระบบมันมาจัดการกับข้อมูลอัพเดทล่าสุดได้
        คิดว่าอาจจะต้องทำแยกเป็น saveToCSV เพื่อเป็นฐานข้อมูลล่าสุด กับ UpdateHistory เพื่อเป็นฐานข้อมูลประวัติของการใช้บริการทั้งหมด */

    public void saveToCSV(){
        //กดปิดโปรแกรม จะเรียก method นี้ โหลดข้อมูลกลายเป็น CSV (ไว้ restore ตอนเปิดระบบใหม่)
        File fi = null;
        FileWriter fw = null; 
        BufferedWriter bw = null;
        try {
            fi = new File(".//File/Customer.csv");
            fw = new FileWriter(fi,false); //flase บันทึกใหม่เป็นไฟล์อัพเดท
            bw = new BufferedWriter(fw);
            //จะวน for เข้าถึงตัว key ทั้งหมด
             for(Integer room: mapCustomer.keySet()){
                for(Customer customer : mapCustomer.get(room)){
                bw.write(room + "," + customer.getidCart() + ","
                        +customer.getFirstnameCustomer() + "," 
                        + customer.getLastnameCustomer() + "," 
                        + customer.getDateCheckin()+ ","
                        + customer.getDateCheckout() + "," 
                        + customer.getDateBooking()+ ","
                        + customer.getStatusCustomer());
                bw.newLine(); 
                }
            }
            
        } catch (Exception e) {
            // อาจมีการขึ้นแจ้งเตือนถ้ามีความผิดพลาดแบบ pop up
            System.out.println(e);
        }finally{  //รอปรับ
            try {
                bw.close(); 
                fw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
    }
}

    public void UpdateHistory(){
        //กดปิดโปรแกรม จะเรียก method นี้ โหลดข้อมูลกลายเป็น CSV (ไว้ restore ตอนเปิดระบบใหม่)
        File fi = new File(".//File/Customer_History.csv");
        FileWriter fw = null; 
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(fi,true); //true เพราะจะบันทึกประวัติการเข้าพักต่อกันเรื่อย ๆ 
            bw = new BufferedWriter(fw);
            //จะวน for เข้าถึงตัว key ทั้งหมด
             for(Integer room: mapCustomer.keySet()){
                for(Customer customer : mapCustomer.get(room)){
                bw.write(room + "," + customer.getidCart() + ","
                        +customer.getFirstnameCustomer() + "," 
                        + customer.getLastnameCustomer() + "," 
                        + customer.getDateCheckin()+ ","
                        + customer.getDateCheckout() + "," 
                        + customer.getDateBooking()+ ","
                        + customer.getStatusCustomer());
                bw.newLine(); 
                }
            }
            
        } catch (Exception e) {
            // อาจมีการขึ้นแจ้งเตือนถ้ามีความผิดพลาดแบบ pop up
            System.out.println(e);
        }finally{  //รอปรับ
            try {
                bw.close(); 
                fw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
    }
}


    public boolean loadFromCSV(){
         File fi = new File(".//File/Customer.csv");

        //ถ้าไม่มีไฟล์ตั้งต้นให้โหลดข้อมูลเข้า hash
        /*if (!fi.exists()) {
            System.out.println("ไม่พบไฟล์ Room.csv (เริ่มต้นด้วยข้อมูลว่าง)");
            return false;
       }*/

        FileReader fr = null;
        BufferedReader br = null;
        try {
            
            fr = new FileReader(fi);
            br = new BufferedReader(fr);
            String s ;
            while ((s = br.readLine()) != null) {
                String[] parts = s.split(","); //จะทำการสร้างสตริง เพื่อแบ่ง ข้อมูลตาม (,)
                if (parts.length == 8) {
                    int numberRoom = Integer.parseInt(parts[0]);
                   int idCard = Integer.parseInt(parts[1]);
                   String firstname = parts[2] ; // ที่เป็นแบบนี้ได้เลยเพราะมันเป็นสตริงอยู่แล้ว
                   String lastname = parts[3];
                   String checkin = parts[4];
                   String checkout = parts[5];
                   String booking = parts[6];
                   String status = parts[7];

                addCustomer(numberRoom,new Customer(idCard, firstname, lastname, checkin, checkout,booking, status));
            }
            }
        } catch (Exception e) {
            System.out.println();
        }finally { // รอปรับ
            try {
                br.close(); fr.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
            return true;
        }
}

