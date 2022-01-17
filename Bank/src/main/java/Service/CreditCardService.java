package Service;

import Entity.Account;
import Entity.CreditCard;
import Entity.TypeAccount;
import Repository.CreditCardRepository;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class CreditCardService {
    private AccountService accountService = new AccountService();
    private Random random = new Random();
    private CustomerService customerService = new CustomerService();
    private String nationalId,name = "empty",accountNumber,cardNumber,cvv2,expireDate;
    private Scanner input = new Scanner(System.in);
    private LoginService loginService = new LoginService();
    private CreditCardRepository creditCardRepository = new CreditCardRepository();

    public CreditCardService() throws SQLException, ClassNotFoundException {
    }

    public int addCard() throws SQLException {
        while(true){
            System.out.print("Enter national Id customer(cancel):");
            nationalId = input.nextLine();
            if( nationalId.equals("cancel"))
                return 0;
            if( loginService.findNationalId(nationalId) == 0 ) {
                System.out.println("You enter a wrong national Id!");
            }
            else
                break;
        }

        name = customerService.findName(nationalId);
        if ( name.equals("null")){
            System.out.println("you enter a wrong national id!");
            return 0;
        }
        System.out.println( name + " have this account :");
        int result = accountService.showAccount(nationalId);
        if( result == 0 ){
            System.out.println(name + " unfortunately doesn't have any active account!");
            return 0;
        }

        System.out.print("Enter number's account for add card:");
        int number = input.nextInt();
        input.nextLine();
        accountNumber = accountService.returnAccountNumber(number);
        if ( accountService.findAccountNumber(accountNumber) == 0 ){
            System.out.println("this account number is not define!");
            return 0;
        }
        if( creditCardRepository.findActiveCard(accountNumber) == 1 ){
            System.out.println("This account you enter have an active card!");
            return 0;
        }

        while(true){
            cardNumber = String.valueOf(random.nextLong(111111111111L,999999999999L));
            if( creditCardRepository.find(cardNumber) == 0 )
                break;
        }
        cvv2 = String.valueOf(random.nextInt(1111,9999));
        int year = java.time.LocalDate.now().getYear() + 4 ;
        int month = java.time.LocalDate.now().getMonthValue();
        expireDate = (String.valueOf(year)) + "-" + (String.valueOf(month));
        CreditCard newCreditCard = new CreditCard(accountNumber,cardNumber,cvv2,expireDate,TypeAccount.ACTIVE);
        creditCardRepository.add(newCreditCard);
        return 1;
    }





}
