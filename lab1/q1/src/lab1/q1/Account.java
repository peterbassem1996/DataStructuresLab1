package lab1.q1;

import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double interestRate;
    private Date dateCreated;

    public Account() {
        this.id = 0;
        this.balance = 0;
        this.interestRate = 0.045;
        this.dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.interestRate = 0.045;
        this.dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getDate() {
        return dateCreated.toString();
    }

    public double getMonthlyInterestRate() {
        return (interestRate / 12) * balance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public String toString() {
        return "Account: " + id + " Balance: " + balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            if (((Account) obj).getBalance() == balance) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
