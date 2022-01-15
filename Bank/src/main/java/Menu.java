import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    int command;

    public int publicMenu(){
        System.out.println("***WELCOME***");
        System.out.println("1-signUp(Register)");
        System.out.println("2-signIn(Enter)");
        System.out.println("3-Exit");
        System.out.print("Please select a number:");
        command = input.nextInt();
        input.nextLine();
        switch(command){
            case 1:
                return 1;

            case 2:
                return 2;

            case 3:
                return 3;

            default:
                return 0;
        }
    }
































}
