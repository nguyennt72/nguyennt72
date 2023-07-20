/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.Validation;

/**
 *
 * @author nguye
 */
public class Validation {
    public static boolean validateEmployeeData(String id, String name, double basicSalary, int seniority, String dob) {
        return validateMaSo(id) && validateTen(name) && validateLuong(basicSalary)
                && validateThamNien(seniority) && validateNgaySinh(dob);
    }

    public static boolean validateMaSo(String maSo) {
        // Kiểm tra mã số không được trùng và bắt đầu bằng "HR" theo sau là 5 chữ số (ví dụ HR00111)
        return maSo.matches("^HR\\d{5}$");
    }

    public static boolean validateTen(String ten) {
        // Kiểm tra tên không được bỏ trống và tối đa 50 ký tự
        return !ten.isEmpty() && ten.length() <= 50;
    }

    public static boolean validateLuong(double luong) {
        // Kiểm tra lương căn bản là số và lớn hơn 0
        return luong > 0;
    }

    public static boolean validateThamNien(int thamNien) {
        // Kiểm tra thâm niên là số và lớn hơn hoặc bằng 0
        return thamNien >= 0;
    }

    public static boolean validateNgaySinh(String ngaySinh) {
        // Kiểm tra ngày sinh với định dạng dd/mm/yyyy
        if (!ngaySinh.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            return false;
        }

        // Kiểm tra tuổi phải lớn hơn hoặc bằng 18
        int day = Integer.parseInt(ngaySinh.substring(0, 2));
        int month = Integer.parseInt(ngaySinh.substring(3, 5));
        int year = Integer.parseInt(ngaySinh.substring(6, 10));
        int currentYear = java.time.Year.now().getValue();

        if (currentYear - year < 18) {
            return false;
        } else if (currentYear - year == 18) {
            int currentMonth = java.time.MonthDay.now().getMonthValue();
            if (month > currentMonth) {
                return false;
            } else if (month == currentMonth) {
                int currentDay = java.time.LocalDate.now().getDayOfMonth();
                if (day > currentDay) {
                    return false;
                }
            }
        }

        return true;
    }
}