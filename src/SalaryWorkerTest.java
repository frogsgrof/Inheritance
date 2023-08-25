import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest {

    SalaryWorker salaryWorker;

    @BeforeEach
    void setUp() {
        salaryWorker = new SalaryWorker("000003", "Dominique", "Hyatt", "Dr.", 1962, 85000);
    }

    @Test
    void calculateWeeklyPay() {
        assertEquals(85000.0 / 52.0, salaryWorker.calculateWeeklyPay(40));
        assertEquals(85000.0 / 52.0, salaryWorker.calculateWeeklyPay(0));
        assertEquals(85000.0 / 52.0, salaryWorker.calculateWeeklyPay(400));
    }

    @Test
    void displayWeeklyPay() {
        salaryWorker.displayWeeklyPay(1);
    }

    @Test
    void getTableRow() {
        Main.printHeader();
        System.out.println(salaryWorker.getTableRow());
    }

    @Test
    void getAnnualSalary() {
        assertEquals(85000, salaryWorker.getAnnualSalary());
    }

    @Test
    void setAnnualSalary() {
        assertEquals(85000, salaryWorker.getAnnualSalary());
        salaryWorker.setAnnualSalary(100000);
        assertEquals(100000, salaryWorker.getAnnualSalary());
    }
}