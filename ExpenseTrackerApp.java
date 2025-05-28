 import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a single expense
class Expense {
    private LocalDate date; // Date of the Expense
    private String category; // Category of the Expense
    private double amount; // Amount spent

    public Expense(LocalDate date, String category, double amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return date + ", " + category + ", $" + amount;
    }
}

// Main class for the Expense Tracker application
public class ExpenseTrackerApp {
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    System.out.println("Goodbye! Have A Nice Day Sir/Ma'am!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addExpense() {
        System.out.print("Enter date (YYYY-MM-DD): ");
        String dateInput = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateInput);

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        expenses.add(new Expense(date, category, amount));
        System.out.println("\nExpense added successfully.");
    }

    private static void viewExpenses() {
        System.out.println("All Expenses:");
        for (int i = 0; i < expenses.size(); i++) {
            Expense expense = expenses.get(i);
            System.out.println(expense);
        }
    }
}