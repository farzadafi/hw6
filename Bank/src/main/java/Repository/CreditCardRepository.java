package Repository;

import Entity.CreditCard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreditCardRepository implements Repository<CreditCard> {
    private Connection connection = Singleton.getInstance().getConnection();

    public CreditCardRepository() throws SQLException, ClassNotFoundException {
        String createTable ="CREATE TABLE IF NOT EXISTS " +
                "CreditCard(id serial," +
                "accountnumber varchar(10) REFERENCES Account(accountnumber)," +
                "cardNumber varchar(30) PRIMARY KEY," +
                "cvv2 varchar(10) REFERENCES BankBranch(codeBranch)," +
                "expireDate DATA ," +
                "password varchar(50) ," +
                "status varchar(20))";
        PreparedStatement preparedStatement = connection.prepareStatement(createTable);
        preparedStatement.execute();
    }

    @Override
    public void add(CreditCard creditCard) throws SQLException {

    }

    @Override
    public int find(String input) throws SQLException {
        return 0;
    }
}
