package FactoryMethodPattern;
/**
 * Interface (Room) สำหรับประเภทห้อง
 */
public interface DepositRoom{
    //ราคาของประเภทแต่ละห้อง
    // แต่บังเอิญว่าตัวของ Room มีราคา ควรจัดการโครงสร้างนี้ไงดีนะ

    public double getPrice();
    public String getDescription();
}
