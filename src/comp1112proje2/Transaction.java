package comp1112proje2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Transaction {

    int transactionID;
    double amount;
    Date transactionDate;
    String type;
    int transactionCounter = 1000;

    Transaction() {
    }

    public long generateAccountNumberLong() {
        Random rm = new Random();
        return rm.nextLong(100000000);
    }

    Transaction(double amont, Date transDate, String type, long transactionID, ArrayList List) {
        this.transactionDate = transDate;
        if (type != "Withdrawal" && type != "Deposit" && type != "Transfer") {
            System.out.println("Invalid type try again!");
        } else {
            this.type = type;
        }
        this.transactionID = (int) generateAccountNumberLong();
        transactionCounter++;
        List.add(this);
        this.amount = amont;
    }

    void Withdrawal(double withdrawalAmount) {
        //a.lowerToBalance(withdrawalAmount);
    }

    void deposit(double depositValue) {
        //a.addToBalance(depositValue);
    }

    @Override
    public String toString() {
        return "Amount:" + this.amount + " Date:" + this.transactionDate + " Type:" + this.type + " Transaction ID:" + this.transactionID;
    }

}
