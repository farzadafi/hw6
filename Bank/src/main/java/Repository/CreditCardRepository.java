package Repository;

import Entity.CreditCard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreditCardRepository implements Repository<CreditCard> {
    private Connection connection = Singleton.getInstance().getConnection();

    public CreditCardRepository() throws SQLException, ClassNotFoundException {
        String createTable ="CREATE TABLE IF NOT EXISTS " +
                "CreditCard(id serial," +
                "accountnumber varchar(10) REFERENCES Account(accountnumber)," +
                "cardNumber varchar(30) PRIMARY KEY," +
                "cvv2 varchar(10)," +
                "expireDate varchar(20)," +
                "password varchar(50) ," +
                "status varchar(20))";
        PreparedStatement preparedStatement = connection.prepareStatement(createTable);
        preparedStatement.execute();
    }

    @Override
    public void add(CreditCard creditCard) throws SQLException {
        String insertCard = " INSERT INTO CreditCard(accountnumber,cardNumber,cvv2,expireDate,status) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertCard);
        preparedStatement.setString(1,creditCard.getAccountNumber());
        preparedStatement.setString(2,creditCard.getCardNumber());
        preparedStatement.setString(3,creditCard.getCvv2());
        preparedStatement.setString(4,creditCard.getDate());
        preparedStatement.setString(5, String.valueOf(creditCard.getTypeAccount()));
        preparedStatement.executeUpdate();
    }

    @Override
    public int find(String input) throws SQLException {
        String find = "SELECT * FROM CreditCard WHERE cardNumber = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(find);
        preparedStatement.setString(1,input);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next())
            return 1;
        else
            return 0;
    }
}
