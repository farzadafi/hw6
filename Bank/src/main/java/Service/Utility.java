package Service;

import Service.Exception.InvalidName;

import java.util.Scanner;

public class Utility {
    private String firstName;
    private Scanner input = new Scanner(System.in);
    private InvalidName invalidName = new InvalidName();



    public String setFirstName(){
        while(true){
            System.out.print("Enter first name(just alpha):");
            try {
                firstName = input.nextLine();
                invalidName.checkName(firstName);
                break;
            }catch (InvalidName except){
                System.out.println(except.getMessage());
            }
        }
        return firstName;
    }

}
