package Service;

import Entity.BankBranch;
import Entity.TypeUser;
import Repository.BankBranchRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class BankBranchService {
    private BankService bankService = new BankService();
    private BankBranchRepository bankBranchRepository = new BankBranchRepository();
    private LoginService loginService = new LoginService();
    private Scanner input = new Scanner(System.in);
    private String nameBank,bossFullName,nationalId,password,codeBranch;
    private Utility utility = new Utility();

    public BankBranchService() throws SQLException, ClassNotFoundException {
    }

    //::::>
    public int addBankBranch() throws SQLException {
        System.out.print("Enter bank name:");
        nameBank = input.nextLine();
        if( bankService.findBankName(nameBank) == 0 ) {
            return 1;
        }
        codeBranch = utility.setCodeBranch();
        if( bankBranchRepository.find(codeBranch) == 1 ){
            return 2;
        }
        System.out.println("boss full name");
        bossFullName = utility.setName();
        while(true){
            System.out.println("national Id(username)");
            nationalId = utility.setNationalId();
            if( loginService.findNationalId(nationalId) == 1 ) {
                System.out.println("you enter a wrong national id");
            }
            else
                break;
        }
        System.out.println("password for " + bossFullName + ":" );
        password = utility.setPassword();
        loginService.addNewLogin(nationalId,password, TypeUser.BOSS);
        BankBranch newBankBranch = new BankBranch(nameBank,codeBranch,bossFullName,nationalId,password);
        bankBranchRepository.add(newBankBranch);
        return 3;
    }

    //::::>
    public String findCodeBranch(String nationalId) throws SQLException {
        return bankBranchRepository.findCodeBranch(nationalId);
    }






}//
