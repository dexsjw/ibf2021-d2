package ibf2021;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankAccount {
    private String name;
    private String accountNumber;
    private float accountBalance;
    private List<String> transactions;
    private boolean isClosed = false;
    private String accountCreateDate;
    private String accountCloseDate;

    //Constructors
    public BankAccount(String accName) {
        this.name = accName;
        this.accountNumber = Double.toString((Math.random())*1000000000);
        this.accountBalance = 0f;
        accountCreateDate = dateTime();
    }

    public BankAccount(String accName, float accBalance) {
        this.name = accName;
        this.accountBalance = accBalance;
        accountCreateDate = dateTime();
    }


    //Methods
    private String dateTime() {
        LocalDateTime dateTimeNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = dateTimeNow.format(formatter);
        return dateTime;
    }

    //getter for name
    public String getName() {
        return name;
    }

    //getter for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    //getter for accountBalance
    public float getAccountBalance() {
        return accountBalance;
    }

    //setter for accountBalance
    public void setAccountBalance(float accBalance) {
        this.accountBalance = accBalance;
    }

    //getter for transactions
    public List<String> getTransactions() {
        return transactions;
    }

    //getter for isClosed
    public boolean getIsClosed() {
        return isClosed;
    }

    //setter for isClosed
    public void setIsClosed(boolean closed) {
        this.isClosed = closed;
        if (this.isClosed == true) {
            accountCloseDate = dateTime();
        } else {
            accountCloseDate = null;
        }
    }

    //getter for accountCreateDate
    public String getAccountCreateDate() {
        return accountCreateDate;
    }

    //getter for accountCloseDate
    public String getAccountCloseDate() {
        return accountCloseDate;
    }


    public void deposit(float depositAmount) {

        if (depositAmount < 0 || (isClosed == true)) {
            throw new IllegalArgumentException();
        
        } else {
            String depositTransaction = "Deposit $" + depositAmount + " at " + dateTime();
            transactions.add(depositTransaction);
            accountBalance += depositAmount;
        }
    }

    public void withdraw(float withdrawAmount) {

        if (withdrawAmount < 0 || (isClosed == true)) {
            throw new IllegalArgumentException();
        
        } else {
            String withdrawTransaction = "Withdraw $" + withdrawAmount + " at " + dateTime();
            transactions.add(withdrawTransaction);
            accountBalance += withdrawAmount;
        }
    }
}