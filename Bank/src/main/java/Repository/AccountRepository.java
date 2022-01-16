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
                "accountnumber varchar(50) ," +
                "budget DECIMAL, " +
                "status varchar(50))";
        PreparedStatement preparedStatement = connection.prepareStatement(createTable);
        preparedStatement.execute();
    }

    @Override
    public void add(Account account) throws SQLException {
        String insertAccount = " INSERT INTO Account(codeBranch,nationalId,accountnumber,budget,status) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertAccount);
        preparedStatement.setString(1,account.getCodeBranch());
        preparedStatement.setString(2,account.getNationalId());
        preparedStatement.setString(3,account.getAccountNumber());
        preparedStatement.setDouble(4,account.getBudget());
        preparedStatement.setString(5, String.valueOf(account.getTypeAccount()));
        preparedStatement.executeUpdate();
    }

    @Override
    public int find(String input) throws SQLException {
        return 0;
    }
}
