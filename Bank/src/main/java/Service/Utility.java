package Service;

import Service.Exception.InvalidCodeBranch;
import Service.Exception.InvalidName;
import Service.Exception.InvalidNationalId;

import java.util.Scanner;

public class Utility {
    private String Name,codeBranch,nationalId;
    private Scanner input = new Scanner(System.in);
    private InvalidName invalidName = new InvalidName();
    private InvalidCodeBranch invalidCodeBranch = new InvalidCodeBranch();
    private InvalidNationalId invalidNationalId = new InvalidNationalId();



    public String setName(){
        while(true){
            System.out.print("Enter name(just alpha):");
            try {
                Name = input.nextLine();
                invalidName.checkName(Name);
                break;
            }catch (InvalidName except){
                System.out.println(except.getMessage());
            }
        }
        return Name;
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

    public String setNationalId(){
        while(true){
            System.out.print("Enter National Id(just number):");
            try {
                nationalId = input.nextLine();
                invalidNationalId.nationalIdChecker(nationalId);
                break;
            }catch (InvalidNationalId except){
                System.out.println(except.getMessage());
            }
        }
        return nationalId;
    }

}//
