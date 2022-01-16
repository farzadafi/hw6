package Repository;

import Entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountRepository implements Repository<Account> {
    private Connection connection = Singleton.getInstance().getConnection();;

    //::::>
    public AccountRepository() throws SQLException, ClassNotFoundException {
        String createTable ="CREATE TABLE IF NOT EXISTS " +
                "Account(id serial," +
                "codeBranch varchar(50) REFERENCES BankBranch(codeBranch)," +
                "nationalId varchar(50) REFERENCES Customer(nationalId)," +
                "accountNumber varchar(50) ," +
                "budget bigint, " +
                "status varchar(50))";
        PreparedStatement preparedStatement = connection.prepareStatement(createTable);
        preparedStatement.execute();
    }

    @Override
    public void add(Account account) throws SQLException {

    }

    @Override
    public int find(String input) throws SQLException {
        return 0;
    }
}
