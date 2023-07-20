/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment .entities;

/**
 *
 * @author nguye
 */
public abstract class Employee {
    protected String name;
    protected String id;
    protected boolean gender;
    protected String dBirth;
    protected long basicSalary;
    protected byte level = 1;
    protected long realSalary;
    protected byte seniority;

    public Employee() {
    }

    public Employee(String name, String id, boolean gender, String dBirth, long basicSalary, byte seniority) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.dBirth = dBirth;
        this.basicSalary = basicSalary;
        this.seniority = seniority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public boolean getGender() {
        return gender;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getdBirth() {
        return dBirth;
    }

    public void setdBirth(String dBirth) {
        this.dBirth = dBirth;
    }

    public long getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(long basicSalary) {
        this.basicSalary = basicSalary;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public long getRealSalary() {
        return realSalary;
    }

    public void setRealSalary(long realSalary) {
        this.realSalary = realSalary;
    }

    public byte getSeniority() {
        return seniority;
    }

    public void setSeniority(byte seniority) {
        this.seniority = seniority;
    }
 
    public void tinhLuong(){
        realSalary =  getBasicSalary() *  getLevel();
    }
    public void xuatThongTinNV(){  
        System.out.println("Ten nhan vien: "+getName());
        System.out.println("Ma nhan vien: "+getId());
        System.out.println("Gioi tinh: "+getGender());
        System.out.println("Ngay sinh: "+getdBirth());
        System.out.println("Luong can ban: "+getBasicSalary());
        System.out.println("He so luong: "+getLevel());
        System.out.println("Luong thuc lanh: "+getRealSalary());
        System.out.println("Tham nien: "+getSeniority());
      }

     
    
    
}       