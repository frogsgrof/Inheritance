import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    Worker worker;

    @BeforeEach
    void setUp() {
        worker = new Worker("000000", "Rubi", "Larson", "Ms.", 1953, 24.5);
    }

    @Test
    void calculateWeeklyPay() {
        assertEquals(980, worker.calculateWeeklyPay(40));
        assertEquals(5684, worker.calculateWeeklyPay(168));
        assertEquals(0, worker.calculateWeeklyPay(0));
    }

    @Test
    void displayWeeklyPay() {
        System.out.println(worker.displayWeeklyPay(50) + "\n");
    }

    @Test
    void getTableRow() {
        Main.printHeader();
        System.out.println(worker.getTableRow(50));
    }

    @Test
    void getHourlyPayRate() {
        assertEquals(24.5, worker.getHourlyPayRate());
    }

    @Test
    void setHourlyPayRate() {
        assertEquals(24.5, worker.getHourlyPayRate());
        worker.setHourlyPayRate(99);
        assertEquals(99, worker.getHourlyPayRate());
    }
}