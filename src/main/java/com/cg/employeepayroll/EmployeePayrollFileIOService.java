package com.cg.employeepayroll;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
public class EmployeePayrollFileIOService {
    private List<EmployeePayrollData> employeePayrollList ;

    public static String PAYROLL_FILE_NAME = "payroll-file.txt";
    public enum IOService {FILE_IO,CONSOLE_IO}
    public EmployeePayrollFileIOService(){}
    public EmployeePayrollFileIOService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    public void writeData(List<EmployeePayrollData> employeePayrollList){
        StringBuffer empBuffer = new StringBuffer();
        employeePayrollList.forEach(employee ->{String empDataString = employee.toString().concat("\n");
        empBuffer.append(empDataString);});
        try { Files.write(Paths.get(PAYROLL_FILE_NAME),empBuffer.toString().getBytes());
        }catch (IOException e){ e.printStackTrace(); }
    }

    public void printData(){
        try { Files.lines(new File("payroll-file.txt").toPath()).forEach(System.out::println);
        }catch (IOException e){ System.out.println("Exception"); }
    }
  /*  public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File("payroll-file.txt").toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        } return entries;
    }

    public List<EmployeePayrollData> readData() {
        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        try{
            Files.lines(new File("payroll-file.txt").toPath()).map(line-> line.trim()).forEach(line-> System.out.println(line));
        }catch (IOException e){
            e.printStackTrace();
        }
        return employeePayrollList;
    }*/
}
