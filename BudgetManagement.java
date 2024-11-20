package storeManagement;

import java.util.*;
import java.time.LocalDateTime;

class BudgetManagement{
    private double dailyRevenue;
    private double monthlyRevenue;
    private double expenses;
    private Vector<transactions> transactionsList;

    public BudgetManagement() {
        this.dailyRevenue = 0.0;
        this.monthlyRevenue = 0.0;
        this.expenses = 0.0;
        this.transactionsList = new Vector<>();
    }
    public void addRevenue(double price) {
        dailyRevenue += price;
        monthlyRevenue += price;
        transactions.add(new Transaction("Revenue", price, LocalDateTime.now()));
    }
    public void addExpense(double _expenses) {
        expenses += _expenses;
        transactions.add(new Transaction("Expense", _expenses, LocalDateTime.now()));
    }
    public double getDailyRevenue() {
        return dailyRevenue;
    }

    public double getMonthlyRevenue() {
        return monthlyRevenue;
    }

    public double getExpenses() {
        return expenses;
    }

    public void resetDailyRevenue() {
        dailyRevenue = 0.0;
    }

    public void resetMonthlyRevenue() {
        monthlyRevenue = 0.0;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
