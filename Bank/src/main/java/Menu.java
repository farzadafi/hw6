import Entity.Bank;
import Service.BankBranchService;
import Service.BankService;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private Scanner input = new Scanner(System.in);
    private int command;
    private String username,password;
    private boolean isTrue = true;
    private Bank bank = new Bank();
    private BankService bankService = new BankService();
    private BankBranchService bankBranchService = new BankBranchService();

    public Menu() throws SQLException, ClassNotFoundException {
    }

    //::::>
    public int publicMenu(){
        System.out.println("***WELCOME***");
        System.out.println("1-signIn(Enter)");
        System.out.println("2-Exit");
        System.out.print("Please select a number:");
        command = input.nextInt();
        input.nextLine();
        switch(command){
            case 1:
                return 1;

            case 2:
                return 2;

            default:
                return 0;
        }
    }

    //::::>
    public void enterMenu() throws SQLException {
        System.out.print("Please enter your username:");
        username = input.nextLine();
        System.out.print("Please enter your password:");
        password = input.nextLine();
        if( username.equals("admin") && password.equals("admin") )
            adminMenu();
    }

    //::::>
    public void adminMenu() throws SQLException {
        isTrue = true;
        while(isTrue) {
            System.out.println("*** Admin Menu ***");
            System.out.println("1-Add Bank.");
            System.out.println("2-add Bank Branch.");
            System.out.println("3-Exit.");
            command = input.nextInt();
            input.nextLine();
            switch (command)
            {
                case 1:
                    if( bankService.addBank() == 2 )
                        System.out.println("Bank you enter successful added!");
                    else
                        System.out.println("This name you enter before added!");
                    break;

                case 2:
                    bankBranchService.addBankBranch();
                    break;

                case 3:
                    System.out.println("Good luck!");
                    isTrue = false;
                    break;

                default:
                    System.out.println("you enter a wrong number!");
            }//switch

        }//while


    }//adminMenu
































}
