/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.entities;

/**
 *
 * @author nguye
 */
public class Business extends Employee {
    private double doanhSo;
    private double hoaHong;
    
    private double tinhHoaHong(double doanhSo) {
        if (doanhSo < 5000000) {
            return 0;
        } else if (doanhSo < 10000000) {
            return doanhSo * 0.05;
        } else if (doanhSo < 20000000) {
            return doanhSo * 0.1;
        } else {
            return doanhSo * 0.2;
        }
    } 
    
    public Business() {
    }

    public Business(double doanhSo, double hoaHong, String name, String id, boolean gender, String dBirth, long basicSalary, byte seniority) {
        super(name, id, gender, dBirth, basicSalary, seniority);
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
    }
 
    public double getHoaHong() {
        return hoaHong;
    }

    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        if (doanhSo >= 0) {
            this.doanhSo = doanhSo;
            this.hoaHong = tinhHoaHong(doanhSo);
        } else {
            System.out.println("Doanh số không được âm.");
        }
    }

    @Override
    public void tinhLuong() {
        double real = getBasicSalary() * getLevel() + doanhSo * hoaHong;
        setRealSalary((long) real);
    }

    @Override
    public void xuatThongTinNV() {
        super.xuatThongTinNV();
        System.out.println("Doanh số: " + doanhSo);
        System.out.println("Hoa hồng: " + hoaHong);
    }

     
}
