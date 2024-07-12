package application;

import entities1.Departament;
import entities1.HourContract;
import entities1.Worker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter department's name: ");
        String departamentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.println("Name: ");
        String workerName = sc.nextLine();
        System.out.println("Level: ");
        String workerLevel = sc.nextLine();
        System.out.println("Base Salary: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, workerLevel.valueOf(workerLevel),
                baseSalary, new Departament(departamentName));

        System.out.println("How many contracts to this worker?");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter contract #" + (i + 1) + " data: ");
            System.out.println("Data ( DD/MM/YYYY)): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.println("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.println("Duration (hours) ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);

        }

        System.out.println();
        System.out.println("Enter month and year to calculete income (MM/YYYY)");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName() );
        System.out.println("Departament: " + worker.getDepartament());
        System.out.println("Income for: " + monthAndYear + " : " + String.format("%.2f", worker.income(year, month)));


        sc.close();
    }
}