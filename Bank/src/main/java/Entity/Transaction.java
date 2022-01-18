package Entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private String accountNumber,originCardNumber,destinationCardNumber,amount;
    private Date date;
    private Time time;
    private TypeTransaction typeTransaction;

    public Transaction(String accountNumber, String originCardNumber, String destinationCardNumber, String amount, Date date, Time time, TypeTransaction typeTransaction) {
        this.accountNumber = accountNumber;
        this.originCardNumber = originCardNumber;
        this.destinationCardNumber = destinationCardNumber;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.typeTransaction = typeTransaction;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOriginCardNumber() {
        return originCardNumber;
    }

    public String getDestinationCardNumber() {
        return destinationCardNumber;
    }

    public String getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }
}
