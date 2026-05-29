package BankAccountManagement;

public class SavingsAccount extends BankAccount {
    
    
    public SavingsAccount(String accountNumber, double balance, String accountHolderName) {
        super(accountNumber, balance, accountHolderName);
    }

    
    @Override
    public void withdraw(double amount) {
        double currentBalance = getBalance();
        if(currentBalance - amount>= 100) {
            deposit(-amount);

        } else {
            System.out.println("Insufficient funds. Minimum balance of $100 required.");
        }
        
    }

    



    
}
