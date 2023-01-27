import java.util.Scanner;

class MainThread extends Thread {
    private int basicSalary;
    private int allowances;
    private int EPF;
    private int perDayPayment;
    private int noOfDays;
    private int finalSalary;
    private int employerContribution;
    private AllowancesThread thread2;
    private EPFThread thread3;

    public MainThread(int perDayPayment, int noOfDays) {
        this.perDayPayment = perDayPayment;
        this.noOfDays = noOfDays;
    }

    public void run() {
        basicSalary = perDayPayment * noOfDays;
        thread2 = new AllowancesThread(basicSalary);
        thread3 = new EPFThread(basicSalary, noOfDays);
        thread2.start();
        thread3.start();
        try {
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        allowances = thread2.getAllowances();
        EPF = thread3.getEPF();
        employerContribution = thread3.getEmployerContribution();
        System.out.println("Basic salary : " + basicSalary);
       
        finalSalary = basicSalary + allowances - EPF + employerContribution;
        printResults();
    }

    private void printResults() {
        System.out.println("Allowances: " + allowances);
        System.out.println("EPF: " + EPF);
        System.out.println("Employer Contribution: " + employerContribution);

       System.out.println("----------------------------------");
        System.out.println("Final Salary: " + finalSalary);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter per day payment : ");
        int perDayPayment = sc.nextInt();
        System.out.println("Enter number of days worked :");
        int noOfDays = sc.nextInt();
        MainThread mainThread = new MainThread(perDayPayment, noOfDays);
        mainThread.start();
    }
}

class AllowancesThread extends Thread {
    private int basicSalary;
    private int allowances;

    public AllowancesThread(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void run() {
        allowances = (int) (basicSalary * 0.05);
    }

    public int getAllowances() {
        return allowances;
    }
}

class EPFThread extends Thread {
    private int basicSalary;
    private int noOfDays;
    private int EPF;
    private int employerContribution;

    public EPFThread(int basicSalary, int noOfDays) {
        this.basicSalary = basicSalary;
        this.noOfDays = noOfDays;
    }

    public void run() {
        int totalMonthlyEarnings = basicSalary ;
        EPF = (int) (totalMonthlyEarnings * 0.08);
        employerContribution = (int) (totalMonthlyEarnings * 0.12);
    }

    public int getEPF() {
        return EPF;
    }

    public int getEmployerContribution() {
        return employerContribution;
    }
}

