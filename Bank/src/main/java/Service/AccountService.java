package Service;

import Entity.Account;
import Entity.TypeAccount;
import Repository.AccountRepository;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class AccountService {
    private Scanner input = new Scanner(System.in);
    private ClerkService clerkService = new ClerkService();
    private LoginService loginService = new LoginService();
    private String codeBranch,nationalId,accountNumber;
    private AccountRepository accountRepository = new AccountRepository();
    private Double budget;
    Random random = new Random();

    public AccountService() throws SQLException, ClassNotFoundException {
    }

    //::::>
    public int addAccount(String nationalIdClerk) throws SQLException {
        codeBranch = clerkService.findCodeBranch(nationalIdClerk);
        while(true){
            System.out.print("Enter nationalId(username):");
            nationalId = input.nextLine();
            if( loginService.findNationalId(nationalId) == 0 ) {
                System.out.println("You enter a wrong national Id!");
            }
            else
                break;
        }
        String number;
        while(true) {
            number = String.valueOf(random.nextInt(11111111,99999999));
            if( accountRepository.find(number) == 0 )
                break;
        }
        System.out.print("Enter budget:");
        budget = input.nextDouble();
        Account newAccount = new Account(codeBranch,nationalId,number,budget, TypeAccount.ACTIVE);
        accountRepository.add(newAccount);
        return 1;
    }

    public void showAccountForCustomer(String nationalIdCustomer) throws SQLException {
        accountRepository.showAccount(nationalIdCustomer);
    }

    public int showAccount(String nationalId) throws SQLException {
        return accountRepository.showAccount(nationalId);
    }

    public int findAccountNumber(String number) throws SQLException {
        return accountRepository.find(number);
    }

    public String returnAccountNumber(int id) throws SQLException {
        return accountRepository.returnAccountNumber(id);
    }

    public String returnAmount(String accountNumber) throws SQLException {
        return accountRepository.returnAmount(accountNumber);
    }

    public void depositCard(Double amount,String accountNumber) throws SQLException {
        accountRepository.depositCard(amount,accountNumber);
    }

    public void withdrawCard(Double amount,String accountNumber) throws SQLException {
        accountRepository.withdrawCard(amount,accountNumber);
    }

    public void showAccountForClerk() throws SQLException {
        System.out.print("Enter Customer national Id:");
        nationalId = input.nextLine();
        accountRepository.showAccountForClerk(nationalId);
    }








}
