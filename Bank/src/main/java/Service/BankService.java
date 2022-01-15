package Service;

import Entity.Bank;
import Repository.BankRepository;

import java.sql.SQLException;

public class BankService {
    BankRepository bankRepository = new BankRepository();

    public BankService() throws SQLException, ClassNotFoundException {
    }

    //::::>
    public int importBank(Bank bank) throws SQLException {
        int find = bankRepository.findBank(bank);
        if(find == 1)
            return find;
        else{
            bankRepository.importBank(bank);
            return 2;
        }
    }





















}
