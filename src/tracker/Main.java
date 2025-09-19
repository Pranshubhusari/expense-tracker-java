package tracker;
    import java.time.LocalDate;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            ExpenseManager manager = new ExpenseManager();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n==== Expense Tracker ====");
                System.out.println("1. Add Expense");
                System.out.println("2. View Expenses");
                System.out.println("3. Generate Report");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter category: ");
                        String category = sc.nextLine();
                        System.out.print("Enter amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter description: ");
                        String desc = sc.nextLine();
                        manager.addExpense(new Expense(LocalDate.now(), category, amount, desc));
                        System.out.println("Expense added!");
                        break;

                    case 2:
                        manager.viewExpenses();
                        break;

                    case 3:
                        manager.generateReport();
                        break;

                    case 4:
                        System.out.println("Exiting... Goodbye!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }
    }

