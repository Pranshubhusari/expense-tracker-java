package tracker;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

    public class ExpenseManager {
        private List<Expense> expenses;
        private static final String FILE_NAME = "expenses.csv";

        public ExpenseManager() {
            expenses = new ArrayList<>();
            loadExpenses();
        }

        public void addExpense(Expense expense) {
            expenses.add(expense);
            saveExpenses();
        }

        public void viewExpenses() {
            if (expenses.isEmpty()) {
                System.out.println("No expenses recorded yet.");
                return;
            }
            for (Expense e : expenses) {
                System.out.println(e);
            }
        }

        public void generateReport() {
            double total = 0;
            Map<String, Double> categoryTotals = new HashMap<>();

            for (Expense e : expenses) {
                total += e.getAmount();
                categoryTotals.put(e.getCategory(),
                        categoryTotals.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
            }

            System.out.println("==== Expense Report ====");
            System.out.println("Total: " + total);
            for (String category : categoryTotals.keySet()) {
                System.out.println(category + ": " + categoryTotals.get(category));
            }
        }

        private void saveExpenses() {
            try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
                for (Expense e : expenses) {
                    pw.println(e.toCSV());
                }
            } catch (IOException e) {
                System.out.println("Error saving expenses: " + e.getMessage());
            }
        }

        private void loadExpenses() {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    LocalDate date = LocalDate.parse(parts[0]);
                    String category = parts[1];
                    double amount = Double.parseDouble(parts[2]);
                    String description = parts[3];
                    expenses.add(new Expense(date, category, amount, description));
                }
            } catch (IOException e) {
                // file may not exist on first run
            }
        }
    }

