package ibf2021;

public class FixedDepositAccount extends BankAccount {
    
    private float interest = 3.0f;
    private int durationInMonth = 6;
    private boolean isInterestChanged = false;
    private boolean isDurationChanged = false;

    //Constructors
    public FixedDepositAccount(String name, Float balance){
        super(name, balance);
    }

    public FixedDepositAccount(String name, Float balance, Float interest){
        super(name, balance);
        this.interest = interest;
    }

    public FixedDepositAccount(String name, Float balance, Float interest, Integer duration){
        super(name, balance);
        this.interest = interest;
        this.durationInMonth = duration;
    }


    //Methods
    @Override
    public void deposit(float depositAmount) { };

    @Override
    public void withdraw(float withdrawAmount) { };

    public float getBalance(float interest, int duration) {
        float balance = super.getAccountBalance() * ((interest/100) * (duration/12)); 
        return balance;
    }

    public void setInterest(float interestRate) {
        
        if (isInterestChanged == true) {
            throw new IllegalArgumentException();
        
        } else {
            this.interest = interestRate;
            isInterestChanged = true;
        }
    }

    public void setDurationInMonth(int duration) {
        
        if (isDurationChanged == true) {
            throw new IllegalArgumentException();
        
        } else {
            this.durationInMonth = duration;
            isDurationChanged = true;
        }
    }
}
