package Service;

import Service.Exception.InvalidCodeBranch;
import Service.Exception.InvalidName;

import java.util.Scanner;

public class Utility {
    private String firstName,codeBranch;
    private Scanner input = new Scanner(System.in);
    private InvalidName invalidName = new InvalidName();
    private InvalidCodeBranch invalidCodeBranch = new InvalidCodeBranch();



    public String setBankName(){
        while(true){
            System.out.print("Enter name(just alpha):");
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

    public String setCodeBranch(){
        while(true){
            System.out.print("Enter code Branch(just number):");
            try {
                codeBranch = input.nextLine();
                invalidCodeBranch.codeBranchChecker(codeBranch);
                break;
            }catch (InvalidCodeBranch except){
                System.out.println(except.getMessage());
            }
        }
        return codeBranch;
    }

}//
