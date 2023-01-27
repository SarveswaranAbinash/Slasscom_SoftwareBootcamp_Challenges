import java.util.Scanner;

public class Salary_Calculation extends Thread {
    static double basicSalary;
    static double allowances;
    static double epf;
    static double employerContribution;

    public static void main(String[] args) {
        // Inputs
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter per day payment : ");
        int perDayPayment = sc.nextInt();
        System.out.println("Enter number of days worked :");
        int noOfDays = sc.nextInt();

        // Calculate basic salary
        basicSalary = perDayPayment * noOfDays;
        System.out.println("Basic salary : " + basicSalary);

        // Create threads for allowances and EPF calculations
        Salary_Calculation thread2 = new Salary_Calculation();
        thread2.setName("Thread 2");
        Salary_Calculation thread3 = new Salary_Calculation();
        thread3.setName("Thread 3");

        // Start threads
        thread2.start();
        thread3.start();

        // Wait for threads to finish
        try {
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Main thread calculates final salary
        double finalSalary = basicSalary + allowances - epf + employerContribution;
        System.out.println("----------------------------------------------------------");
        System.out.println("Final Salary: " + finalSalary);
    }

    public void run() {
        if (getName().equals("Thread 2")) {
            // calculate allowances
            allowances = basicSalary * 0.05;
            System.out.println("Allowances: " + allowances);
        } else if (getName().equals("Thread 3")) {
            // calculate EPF and employer contribution
            epf = basicSalary * 0.08;
            employerContribution = basicSalary * 0.12;
            System.out.println("EPF: " + epf);
            System.out.println("Employer Contribution: " + employerContribution);
        }
    }
}
