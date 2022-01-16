import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    int command;
    String username,password;

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
                return 2;

            case 2:
                return 3;

            default:
                return 0;
        }
    }

    //::::>
    public void enterMenu(){
        System.out.print("Please enter your username:");
        username = input.nextLine();
        System.out.print("Please enter your password:");
        password = input.nextLine();
        if( username.equals("admin") && password.equals("admin") )
            adminMenu();
    }

    //::::>
    public void adminMenu(){
        System.out.println("*** Admin Menu ***");
        System.out.println("1-Add Bank.");
        System.out.println("2-add Bank Branch.");
        System.out.println("3-Exit.");
        command = input.nextInt();
        input.nextLine();


    }
































}
