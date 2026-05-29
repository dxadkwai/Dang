package BankAccountManagement;

import java.util.ArrayList;
import java.util.List;

public class BankService {
    private List<BankAccount> accounts = new ArrayList<>();
    

    public BankAccount createSavingsAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        SavingsAccount acc = new SavingsAccount(accNo, name, initialDeposit);
        accounts.add(acc);
        return acc;
    }

    // Create Current Account
    public BankAccount createCurrentAccount(String accNo, String name, double initialDeposit) {
        CurrentAccount acc = new CurrentAccount(accNo, name, initialDeposit);
        accounts.add(acc);
        return acc;
    }


    public void findAccount(String accountNumber){
        for (int i =0; i<accounts.length; i++){
            if (accounts.getAccountNumber().equals(accountNumber)) {

            }
        }
    }

}
