package comp1112proje2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

public abstract class Account{

    protected String accountNumber;
    protected double balance;
    protected String accountHolder;
    protected static int accounter = 0;
    protected String password;

    private static int accountCount = 0;
    ArrayList<Account> allAccounts = new ArrayList<>();

    Account() {
    }

    Account(int accNum, double bal, String own, String pass) {
        this.accountHolder = own;
        this.accountNumber = generateAccountNumber();
        this.balance = bal;
        this.password = pass;
        allAccounts.add(this);
    }

    public String generateAccountNumber() {
        Random rm = new Random();
        return String.format("%08d", rm.nextInt(100000000));
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public static int getCustomerCount() {
        return accounter;
    }

    public void setCustomerCount(int acountter) {
        accounter = acountter;
    }

    public void addToBalance(double adding) {
        this.balance += adding;
    }

    public void lowerToBalance(double subtraction) {
        this.balance -= subtraction;
    }

    public String getOwner() {
        return this.accountHolder;
    }
    public abstract void interestApply();
    public String toString(){
    return "Account Owner:" + this.accountHolder+"\n"+"Account Number:" + this.accountNumber + "\n" + "Balance:" + this.balance;
    }
   
}
