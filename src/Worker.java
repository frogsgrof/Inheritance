public class Worker extends Person {

    private double hourlyPayRate;

    public Worker() {
        super();
        hourlyPayRate = 0;
    }

    public Worker(String id, String firstName, String lastName, String title, int yearOfBirth, double hourlyPayRate) {
        super(id, firstName, lastName, title, yearOfBirth);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked) {
        if (hoursWorked <= 40)
            return hoursWorked * hourlyPayRate;

        return ((hoursWorked - 40) * 1.5 + 40) * hourlyPayRate;
    }

    protected double calculateOvertimePay(double hoursWorked) {
        return hoursWorked * hourlyPayRate * 1.5;
    }

    public String displayWeeklyPay(double hoursWorked) {
        double regHours,
                overtimeHours,
                rPay,
                tPay = calculateWeeklyPay(hoursWorked);

        String regPay,
                overtimePay,
                totalPay = String.format("$%.2f", tPay);

        if (hoursWorked <= 40) {
            regHours = hoursWorked;
            regPay = totalPay;
            overtimeHours = 0;
            overtimePay = "$0.00";
        } else {
            regHours = 40;
            rPay = calculateWeeklyPay(40);
            regPay = String.format("$%.2f", rPay);
            overtimeHours = hoursWorked - 40;
            overtimePay = String.format("$%.2f", tPay - rPay);
        }

        return String.format(Main.getDivider() +
                        "%n%-22s  %3.1f   %25s  %8s%n" +
                        Main.getDivider() +
                        "===========%n%-22s  %3.1f   %36s  %8s%n" +
                        "%-22s  %3.1f   %36s  %8s%n" +
                        Main.getDivider() + "===========\n",
                "Total hours worked:", hoursWorked, "Total paycheck:",
                totalPay, "Regular hours worked:", regHours, "Amount earned from regular hours:", regPay,
                "Overtime hours worked:", overtimeHours, "Amount earned from overtime:", overtimePay);
    }

    public String getTableRow(double hoursWorked) {
        double regHours = hoursWorked,
                overtime;

        if (regHours <= 40)
            overtime = 0;
        else {
            regHours = 40;
            overtime = hoursWorked - regHours;
        }

        String regPay = String.format("$%.2f", calculateWeeklyPay(regHours)),
                overPay = String.format("$%.2f", calculateOvertimePay(overtime)),
                totalPay = String.format("$%.2f", calculateWeeklyPay(hoursWorked));

        return String.format("%6s   %11.1f   %8s   %8.1f   %8s   %10s", getID(), regHours,
                regPay, overtime, overPay, totalPay);
    }
}
