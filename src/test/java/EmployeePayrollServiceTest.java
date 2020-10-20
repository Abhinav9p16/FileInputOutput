import com.cg.employeepayroll.EmployeePayrollData;
import com.cg.employeepayroll.EmployeePayrollFileIOService;
import com.cg.employeepayroll.EmployeePayrollService;
import org.junit.*;
import java.util.*;
import static com.cg.employeepayroll.EmployeePayrollService.IOService.FILE_IO;
import static com.cg.employeepayroll.EmployeePayrollFileIOService.*;

public class EmployeePayrollServiceTest {
    @Test
    public void givenEmployeesWrittenFileShdMatchEntries(){
        EmployeePayrollData[] arrayOfEmps = {
                new EmployeePayrollData(1,"Jeff Bezos",100000.0) ,
                new EmployeePayrollData(2,"Bill Gates",200000.0),
                new EmployeePayrollData(2,"Mark Zuckerberg",300000.0)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService= new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayrollData(FILE_IO);
        employeePayrollService.printData(FILE_IO);
        long entries = employeePayrollService.countEntries(FILE_IO);
        Assert.assertEquals(3,entries);
    }
    @Test
    public void givenFileOnReadMatchCount(){
       EmployeePayrollService employeePayrollService = new EmployeePayrollService();
       long entries = employeePayrollService.readEmployeePayrollData(FILE_IO);
       Assert.assertEquals(0,entries);
    }
}
