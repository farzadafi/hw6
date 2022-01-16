package Manager;

import Entity.Bank;
import Service.BankService;

import java.sql.SQLException;
import java.util.Scanner;

public class BankManager {
    private Scanner input = new Scanner(System.in);
    private BankService bankService;
    private String name;

    public int addBank() throws SQLException {
        System.out.print("Please enter name of Bank for add:");
        name = input.nextLine();
        Bank newBank = new Bank(name);
        return bankService.addBank(newBank);
    }
}
