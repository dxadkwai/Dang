package BankAccountManagement;

public class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, double balance, String accountHolderName) {
        super(accountNumber, balance, accountHolderName);
    }



    @Override
    public void withdraw(double amount) {
        double currentBalance = getBalance();
        if(currentBalance - amount >=-500) {
            deposit(-amount);
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }
    
}
