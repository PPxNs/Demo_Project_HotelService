package Model;
/*
 * class no.4 จะเป็นคลังเก็บข้อมูลลูกค้า จะเก็บข้อมูลคล้ายห้องแต่จะใช้ key เป็นตัวหมายเลขห้อง
 */

import java.io.*;
import java.util.HashMap;

public class CustomerRepository {
    //คีย์เราจะดึงฐานข้อมูลมาจาก room โดยตัวคีย์จะเป็นตัวของเลขห้องเชื่อมกับผู้เข้าใช้
    HashMap<Integer, Customer> mapCustomer = new HashMap<Integer, Customer>();
    

    //เพิ่มลูกค้าเข้าห้อง กำลังคิดว่า ถ้าทำเป็น dictionary แบบ linklist น่าจะดีกว่า เพราะมันต้องมีคนใช้ห้องเดียวกัน หลายคนได้
    public boolean addCustomer(int numberRoom,int idCart,String firstnameCustomer, String lastnameCustomer, 
                               String dateCheckin, String dateCheckout, String statusCustomer){
        if (!mapCustomer.containsKey(numberRoom)) {
            mapCustomer.put(numberRoom, new Customer(idCart, firstnameCustomer,lastnameCustomer, dateCheckin, dateCheckout,statusCustomer));
            return true;
        }
        return false;
    }

    public boolean removeCustomer(){
    
        /* ข้อสงสัย ถ้าเราลบ key ข้อมูลมันจะหายทั้งหมดมั้ยนะ หรือควรจะให้มีแค่ฟังก์ชัน แก้ไขข้อมูล แต่ถ้าลูกค้ายกเลิก 
           เราจะรู้ได้ไงล่ะ คิดว่าอาจจะเพิ่มเติมตัว สถานะเข้ามา จะได้รู้ว่าลูกค้ามาเช็คอินยัง ถ้าไม่มาเช็คอินตามเวลาจะยกเลิกการจองอัตโนมัติ
           โดยยึดค่ามัดจำไว้ แต่ก็มีการเก็บข้อมูลเอาไว้ เพื่อเป็นประวัติ คิดว่าอาจจะไม่ต้องมีการลบ แต่มีการแก้ไขพอ หรือลบได้นะ เผื่อกรณีซ้ำซ้อน
           ค่อยประชุมอีกครั้ง
        */
        return false;
    }

    //คิดว่าตรงหน้า gui เมื่อจะเข้าไปแก้ไขข้อมูลลูกค้าน่าจะมีการแสดงข้อมูลอยู่แล้วถ้าลูกค้าจะแก้ตรงไหนก็ส่งค่ามาบันทึกใหม่
    public boolean replaceCustomer(int numberRoom,int idCart,String firstnameCustomer, String lastnameCustomer, 
                                   String dateCheckin, String dateCheckout, String statusCustomer){
        if (!mapCustomer.containsKey(numberRoom)) {
            return false;
        }else
            mapCustomer.put(numberRoom,new Customer(idCart, firstnameCustomer, lastnameCustomer, dateCheckin, dateCheckout, statusCustomer));
        return true;
        
    }

    //เคลียร์ hash รีเซ็ตคลังข้อมูล
    public void removeAllRoom(){
        mapCustomer.clear();
    }

    public void saveToCSV(){
        //กดปิดโปรแกรม จะเรียก method นี้
        File fi = null;
        FileWriter fw = null; 
        BufferedWriter bw = null;
        try {
            fi = new File(".//File/Customer.csv");
            fw = new FileWriter(fi,true); // true เพราะจะได้เก็บไฟล์ข้อมูลการเข้าพักของลูกค้าได้
            bw = new BufferedWriter(fw);

            //จะวน for เข้าถึงตัว key ทั้งหมด
             for(Integer key : mapCustomer.keySet()){
                Customer customer = mapCustomer.get(key); // ดึงข้อมูลของคีย์นั้น ๆ มาใช้คลาสของ Room จะได้ดึงค่าข้อมูลมา
                bw.write(customer.getidCart()+ ","+customer.getFirstnameCustomer()+ "," + customer.getLastnameCustomer()
                + "," + customer.getDateCheckin()+ ","+ customer.getDateCheckout() + "," + customer.getStatusCustomer());
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
