package BankAccountManagement;

public abstract class BankAccount {

    private String accountNumber;
    private double balance;
    private String accountHolderName;
    
    public BankAccount(String accountNumber,double balance, String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.balance=balance;
        this.accountHolderName=accountHolderName;
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println("Deposited: " + amount);
        
    }
    public abstract void withdraw(double amount);

    public String getAccountNumber(){
        return accountNumber;

    }

    public double getBalance(){
        return balance;
    }

    public String getAccountHolderName(){
        return accountHolderName;

    }
}  

