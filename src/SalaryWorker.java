public class SalaryWorker extends Worker {

    private double annualSalary;

    public SalaryWorker() {
        super();
        annualSalary = 0.0;
    }

    public SalaryWorker(String id, String firstName, String lastName, String title, int yearOfBirth,
                        double annualSalary) {
        super(id, firstName, lastName, title, yearOfBirth, 0);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52;
    }

    @Override
    protected double calculateOvertimePay(double hoursWorked) {
        return calculateWeeklyPay(0);
    }

    public String displayWeeklyPay(double hoursWorked) {
        return "Approximate pay per week (based on annual salary): $" + calculateWeeklyPay(0);
    }

    @Override
    public String getTableRow(double hoursWorked) {
        double regHours = hoursWorked,
                overtime;

        if (regHours <= 40)
            overtime = 0;
        else {
            regHours -= 40;
            overtime = hoursWorked - regHours;
        }

        String pay = String.format("$%.2f", calculateWeeklyPay(0));

        return String.format("%6s   %11.1f   %8s   %8.1f   %8s   %10s", getID(), regHours,
                "N/A", overtime, "N/A", pay);
    }
}
