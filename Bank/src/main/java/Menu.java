import Entity.Bank;
import Service.BankBranchService;
import Service.BankService;
import Service.ClerkService;
import Service.LoginService;

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
    private LoginService loginService = new LoginService();
    private ClerkService clerkService = new ClerkService();


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
        else{
            String resultFind = loginService.findLogin(username,password);
            if (resultFind == null ) {
                System.out.println("you enter a wrong username and password,please be carefully!");
            }
            else if( resultFind.equals("BOSS"))
                bossMenu();
            else if( resultFind.equals("CLERK"))
                System.out.println("clerkMenu");
                //clerkMenu();
            else if( resultFind.equals("CUSTOMER"))
                System.out.println("customer menu");
                //customerMenu();
        }
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
                    int result = bankBranchService.addBankBranch();
                    if(result == 1 )
                        System.out.println("This name Bank you enter doesn't Exists!");
                    else if(result == 2)
                        System.out.println("This code Branch already Exists!");
                    else
                        System.out.println("This branch Bank you enter successful added!");
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

    //::::>
    public void bossMenu() throws SQLException {
        isTrue = true;
        while(isTrue) {
            System.out.println("*** Boss Menu ***");
            System.out.println("1-add clerk.");
            System.out.println("2-Exit.");
            System.out.print("Please select a number:");
            command = input.nextInt();
            input.nextLine();
            switch(command){
                case 1:
                    String result = clerkService.addClerk(username);
                    System.out.println( result + " successful added!");
                    break;

                case 2:
                    System.out.println("Good luck!");
                    isTrue = false;
                    break;

                default:
                    System.out.println("you enter a wrong number");

            }//switch
        }//while

    }//bossMenu
































}
