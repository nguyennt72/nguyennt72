/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.main;

import assignment.Validation.Validation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author nguye
 */
class HR {
    private ArrayList<String> employeeList;

    public HR() {
        employeeList = new ArrayList<>();
    }

    public void nhapDS() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng nhân viên: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("Nhập thông tin nhân viên thứ " + (i + 1) + ":");
            System.out.print("Mã số: HR"); 
            String id = "HR" + String.format("%05d", scanner.nextInt());
            scanner.nextLine();

            System.out.print("Tên: ");
            String name = scanner.nextLine();

            System.out.print("Lương căn bản: ");
            double basicSalary = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Thâm niên: ");
            int seniority = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Giới tính (Nam = true, Nữ = false): ");
            boolean gender = scanner.nextBoolean();
            scanner.nextLine();

            System.out.print("Ngày sinh (dd/mm/yyyy): ");
            String dBirth = scanner.nextLine();
            
            if (!Validation.validateEmployeeData(id, name, basicSalary, seniority, dBirth)) {
                System.out.println("Thông tin nhân viên không hợp lệ. Vui lòng nhập lại.");
                i--; // Lặp lại lần nhập này
                continue;
            }

            String employeeInfo = id + ";" + name + ";" + basicSalary + ";" + seniority + ";" + gender + ";" + dBirth;
            String employeeInfo = new 
            employeeList.add(employeeInfo);
        }
    }

    public void xuatToanBoDS() {
        for (String employee : employeeList) {
            String[] employeeInfo = employee.split(";");
            String id = employeeInfo[0];
            String name = employeeInfo[1];
            double basicSalary = Double.parseDouble(employeeInfo[2]);
            int seniority = Integer.parseInt(employeeInfo[3]);
            boolean gender = Boolean.parseBoolean(employeeInfo[4]);
            String dBirth = employeeInfo[5];

            String genderStr = gender ? "Nam" : "Nữ";
            System.out.println("Mã số: " + id + ", Tên: " + name + ", Giới tính: " + genderStr + ", Ngày sinh: " + dBirth + ", Lương căn bản: " + basicSalary);
        }
    }

    public void xuatNVTheoLoai(String loaiNV) {
        for (String employee : employeeList) {
            String[] employeeInfo = employee.split(";");
            String id = employeeInfo[0];
            String name = employeeInfo[1];
            double basicSalary = Double.parseDouble(employeeInfo[2]);
            int seniority = Integer.parseInt(employeeInfo[3]);
            boolean gender = Boolean.parseBoolean(employeeInfo[4]);
            String dBirth = employeeInfo[5];  
        }
    }

    public void tinhLuongTB() {
        double totalSalary = 0;
        for (String employee : employeeList) {
            String[] employeeInfo = employee.split(";");
            double basicSalary = Double.parseDouble(employeeInfo[2]);
            totalSalary += basicSalary;
        }
        double averageSalary = totalSalary / employeeList.size();
        System.out.println("Lương trung bình toàn công ty: " + averageSalary);
    }

    public void timLuongCaoNhat() {
        double maxSalary = Double.MIN_VALUE;
        String highestPaidEmployee = null;
        for (String employee : employeeList) {
            String[] employeeInfo = employee.split(";");
            double basicSalary = Double.parseDouble(employeeInfo[2]);
            if (basicSalary > maxSalary) {
                maxSalary = basicSalary;
                highestPaidEmployee = employee;
            }
        }
        if (highestPaidEmployee != null) {
            String[] employeeInfo = highestPaidEmployee.split(";");
            String id = employeeInfo[0];
            String name = employeeInfo[1];
            double basicSalary = Double.parseDouble(employeeInfo[2]);
            int seniority = Integer.parseInt(employeeInfo[3]);
            boolean gender = Boolean.parseBoolean(employeeInfo[4]);
            String dob = employeeInfo[5];

            String genderStr = gender ? "Nam" : "Nữ";
            System.out.println("Nhân viên có lương cao nhất:");
            System.out.println("Mã số: " + id + ", Tên: " + name + ", Giới tính: " + genderStr + ", Ngày sinh: " + dob + ", Lương căn bản: " + basicSalary);
        }
    }

    public void timLuongThapNhat() {
        double minSalary = Double.MAX_VALUE;
        String lowestPaidEmployee = null;
        for (String employee : employeeList) {
            String[] employeeInfo = employee.split(";");
            double basicSalary = Double.parseDouble(employeeInfo[2]);
            if (basicSalary < minSalary) {
                minSalary = basicSalary;
                lowestPaidEmployee = employee;
            }
        }
        if (lowestPaidEmployee != null) {
            String[] employeeInfo = lowestPaidEmployee.split(";");
            String id = employeeInfo[0];
            String name = employeeInfo[1];
            double basicSalary = Double.parseDouble(employeeInfo[2]);
            int seniority = Integer.parseInt(employeeInfo[3]);
            boolean gender = Boolean.parseBoolean(employeeInfo[4]);
            String dob = employeeInfo[5];

            String genderStr = gender ? "Nam" : "Nữ";
            System.out.println("Nhân viên có lương thấp nhất:");
            System.out.println("Mã số: " + id + ", Tên: " + name + ", Giới tính: " + genderStr + ", Ngày sinh: " + dob + ", Lương căn bản: " + basicSalary);
        }
    }

    public void timKiemNV(String keyword) {
        ArrayList<String> searchResults = new ArrayList<>();
        for (String employee : employeeList) {
            String[] employeeInfo = employee.split(";");
            String id = employeeInfo[0];
            String name = employeeInfo[1];
            if (id.equals(keyword) || name.contains(keyword)) {
                searchResults.add(employee);
            }
        }
        if (searchResults.isEmpty()) {
            System.out.println("Không tìm thấy kết quả phù hợp.");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (String employee : searchResults) {
                String[] employeeInfo = employee.split(";");
                String id = employeeInfo[0];
                 String name = employeeInfo[1];
                double basicSalary = Double.parseDouble(employeeInfo[2]);
                int seniority = Integer.parseInt(employeeInfo[3]);
                boolean gender = Boolean.parseBoolean(employeeInfo[4]);
                String dob = employeeInfo[5];

                String genderStr = gender ? "Nam" : "Nữ";
                System.out.println("Mã số: " + id + ", Tên: " + name + ", Giới tính: " + genderStr + ", Ngày sinh: " + dob + ", Lương căn bản: " + basicSalary);
            }
        }
    }

    public void sapXepNV() {
        Collections.sort(employeeList, new Comparator<String>() {
            @Override
            public int compare(String emp1, String emp2) {
                String[] emp1Info = emp1.split(";");
                String[] emp2Info = emp2.split(";");

                String name1 = emp1Info[1];
                String name2 = emp2Info[1];
                int nameComparison = name1.compareTo(name2);
                if (nameComparison != 0) {
                    return nameComparison;
                }

                double basicSalary1 = Double.parseDouble(emp1Info[2]);
                double basicSalary2 = Double.parseDouble(emp2Info[2]);
                return Double.compare(basicSalary2, basicSalary1);
            }
        });

        System.out.println("Danh sách nhân viên sau khi sắp xếp:");
        for (String employee : employeeList) {
            String[] employeeInfo = employee.split(";");
            String id = employeeInfo[0];
            String name = employeeInfo[1];
            double basicSalary = Double.parseDouble(employeeInfo[2]);
            int seniority = Integer.parseInt(employeeInfo[3]);
            boolean gender = Boolean.parseBoolean(employeeInfo[4]);
            String dob = employeeInfo[5];

            String genderStr = gender ? "Nam" : "Nữ";
            System.out.println("Mã số: " + id + ", Tên: " + name + ", Giới tính: " + genderStr + ", Ngày sinh: " + dob + ", Lương căn bản: " + basicSalary);
        }
    }

    public void xoaNVTheoMa(String maNV) {
        boolean removed = false;
        for (int i = 0; i < employeeList.size(); i++) {
            String employee = employeeList.get(i);
            String[] employeeInfo = employee.split(";");
            String id = employeeInfo[0];
            if (id.equals(maNV)) {
                employeeList.remove(i);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Xoá nhân viên thành công.");
        } else {
            System.out.println("Không tìm thấy nhân viên có mã số " + maNV);
        }
    }

    public void capNhatNVTheoMa(String maNV) {
        boolean updated = false;
        for (int i = 0; i < employeeList.size(); i++) {
            String employee = employeeList.get(i);
            String[] employeeInfo = employee.split(";");
            String id = employeeInfo[0];
            if (id.equals(maNV)) {
                System.out.println("Nhập thông tin cập nhật cho nhân viên có mã số " + maNV + ":");
                System.out.print("Tên: ");
                String name = new Scanner(System.in).nextLine();
                System.out.print("Lương căn bản: ");
                double basicSalary = new Scanner(System.in).nextDouble();
                System.out.print("Thâm niên: ");
                int seniority = new Scanner(System.in).nextInt();
                System.out.print("Giới tính (Nam = true, Nữ = false): ");
                boolean gender = new Scanner(System.in).nextBoolean();
                System.out.print("Ngày sinh (dd/mm/yyyy): ");
                String dBirth = new Scanner(System.in).nextLine();

                String updatedEmployee = id + ";" + name + ";" + basicSalary + ";" + seniority + ";" + gender + ";" + dBirth;
                employeeList.set(i, updatedEmployee);
                updated = true;
                break;
            }
        }
        if (updated) {
            System.out.println("Cập nhật nhân viên thành công.");
        } else {
            System.out.println("Không tìm thấy nhân viên có mã số " + maNV);
        }
    }

    public static void main(String[] args) {
        HR hr = new HR();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Nhập danh sách nhân viên");
            System.out.println("2. Xuất toàn bộ danh sách nhân viên");
            System.out.println("3. Xuất danh sách nhân viên theo loại");
            System.out.println("4. Tính và hiển thị lương trung bình toàn công ty");
            System.out.println("5. Tìm và hiển thị nhân viên có lương cao nhất");
            System.out.println("6. Tìm và hiển thị nhân viên có lương thấp nhất");
            System.out.println("7. Tìm kiếm nhân viên theo mã số hoặc tên");
            System.out.println("8. Sắp xếp và hiển thị danh sách nhân viên theo tên");
            System.out.println("9. Xoá nhân viên theo mã số");
            System.out.println("10. Cập nhật thông tin nhân viên theo mã số");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    hr.nhapDS();
                    break;
                case 2:
                    hr.xuatToanBoDS();
                    break;
                case 3:
                    System.out.print("Nhập loại nhân viên (kinh doanh hoặc hành chính): ");
                    String loaiNV = scanner.nextLine();
                    hr.xuatNVTheoLoai(loaiNV);
                    break;
                case 4:
                    hr.tinhLuongTB();
                    break;
                case 5:
                    hr.timLuongCaoNhat();
                    break;
                case 6:
                    hr.timLuongThapNhat();
                    break;
                case 7:
                    System.out.print("Nhập mã số hoặc tên nhân viên cần tìm: ");
                    String keyword = scanner.nextLine();
                    hr.timKiemNV(keyword);
                    break;
                case 8:
                    hr.sapXepNV();
                    break;
                case 9:
                    System.out.print("Nhập mã số nhân viên cần xoá: ");
                    String maNV = scanner.nextLine();
                    hr.xoaNVTheoMa(maNV);
                    break;
                case 10:
                    System.out.print("Nhập mã số nhân viên cần cập nhật: ");
                    String maNVToUpdate = scanner.nextLine();
                    hr.capNhatNVTheoMa(maNVToUpdate);
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}