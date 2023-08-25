import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Worker> workers = new ArrayList<>();

        Worker w1 = new Worker("000000", "Rubi", "Larson", "Ms.", 1953, 24.5);
        Worker w2 = new Worker("000001", "Marvin", "Monahan", "Mr.", 1979, 20.5);
        Worker w3 = new Worker("000002", "Amos", "Pacocha", "Mr.", 1979, 11.30);
        Worker s1 = new SalaryWorker("000003", "Dominique", "Hyatt", "Dr.", 1962, 85000);
        Worker s2 = new SalaryWorker("000004", "Karina", "Cummings", "Mrs.", 1955, 51200);
        Worker s3 = new SalaryWorker("000005", "Joselyn", "Homenick", "Mrs.", 1944, 24300);

        workers.add(w1);
        workers.add(w2);
        workers.add(w3);
        workers.add(s1);
        workers.add(s2);
        workers.add(s3);

        // prints table

        for (int i = 1; i <= 3; i++) {
            printDivider();
            System.out.println("WEEK " + i);
            printDivider();
            printHeader();
            if (i == 2)
                for (Worker worker : workers)
                    System.out.println(worker.getTableRow(50));
            else
                for (Worker worker : workers)
                    System.out.println(worker.getTableRow(40));
        }
        printDivider();
    }

    public static String getDivider() {
        return "==================================================================";
    }

    private static void printDivider() {
        System.out.println(getDivider());
    }

    public static void printHeader() {
        System.out.printf("%6s   %11s   %8s   %8s   %8s   %10s%n", "ID", "1st 40 HRS.", "AMOUNT",
                "OVERTIME", "AMOUNT", "TOTAL");
    }
}
