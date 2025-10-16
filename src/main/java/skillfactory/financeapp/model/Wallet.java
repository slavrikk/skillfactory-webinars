package skillfactory.financeapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wallet {
    private List<Transaction> transactions;
    private Map<String, Double> budgets;

    public Wallet() {
        this.transactions = new ArrayList<>();
        this.budgets = new HashMap<>();
    }

    // Getters and setters
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Map<String, Double> getBudgets() {
        return budgets;
    }

    public void setBudgets(Map<String, Double> budgets) {
        this.budgets = budgets;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void setBudget(String category, Double amount) {
        budgets.put(category, amount);
    }

    public Double getBudget(String category) {
        return budgets.get(category);
    }
}