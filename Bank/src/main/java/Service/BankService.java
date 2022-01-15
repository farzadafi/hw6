package Service;

import Repository.BankRepository;

import java.sql.SQLException;

public class BankService {
    BankRepository bankRepository = new BankRepository();

    public BankService() throws SQLException, ClassNotFoundException {
    }
}
