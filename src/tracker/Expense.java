package tracker;

import java.time.LocalDate;

public class Expense {
        private LocalDate date;
        private String category;
        private double amount;
        private String description;

        public Expense(LocalDate date, String category, double amount, String description) {
            this.date = date;
            this.category = category;
            this.amount = amount;
            this.description = description;
        }

        public LocalDate getDate() { return date; }
        public String getCategory() { return category; }
        public double getAmount() { return amount; }
        public String getDescription() { return description; }

        @Override
        public String toString() {
            return date + " | " + category + " | " + amount + " | " + description;
        }

        public String toCSV() {
            return date + "," + category + "," + amount + "," + description;
        }
    }

