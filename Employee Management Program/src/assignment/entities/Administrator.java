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
public class Administrator extends Employee {
    private long bonusSalary;

    public Administrator() {
    }

    public Administrator(long bonusSalary, String name, String id, boolean gender, String dBirth, long basicSalary, byte seniority) {
        super(name, id, gender, dBirth, basicSalary, seniority);
        this.bonusSalary = bonusSalary;
    }

    public long getBonusSalary() {
        return bonusSalary;
    }

    public void setBonusSalary(long bonusSalary) {
        if (bonusSalary >= 0) {
            this.bonusSalary = bonusSalary;
        } else {
            System.out.println("Phụ cấp không được âm.");
        }
    }

    @Override
    public void tinhLuong() {
        double real = getBasicSalary() * getLevel() + bonusSalary;
        setRealSalary((long) real);
    }

    @Override
    public void xuatThongTinNV() {
        super.xuatThongTinNV();  
    }
    
    
    
    
}
