package Repository;

import Entity.Transaction;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionRepository implements Repository<Transaction> {
    private Connection connection = Singleton.getInstance().getConnection();

    public TransactionRepository() throws SQLException, ClassNotFoundException {
        String createTable = "CREATE TABLE IF NOT EXISTS TransactionTable(id serial," +
                "accountnumber varchar(10)," +
                "originCardNumber varchar(20),"+
                "destinationCardNumber varchar(20)," +
                "amount varchar(50)," +
                "dateT date," +
                "timet time," +
                "typeTransaction varchar(20))";
        PreparedStatement preparedStatement = connection.prepareStatement(createTable);
        preparedStatement.execute();
    }


    @Override
    public void add(Transaction transaction) throws SQLException {
        String insertTransaction = "INSERT INTO TransactionTable (accountnumber,originCardNumber,destinationCardNumber,amount,dataT,timeT,typeTransaction) VALUES (?, ?, ?, ?, ?, ?, ?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(insertTransaction);
        preparedStatement.setString(1,transaction.getAccountNumber());
        preparedStatement.setString(2,transaction.getOriginCardNumber());
        preparedStatement.setString(3,transaction.getDestinationCardNumber());
        preparedStatement.setString(4,transaction.getAmount());
        preparedStatement.setDate(5, (Date) transaction.getDate());
        preparedStatement.setTime(6,transaction.getTime());
        preparedStatement.setString(7, String.valueOf(transaction.getTypeTransaction()));
        preparedStatement.executeUpdate();
    }

    @Override
    public int find(String input) throws SQLException {
        return 0;
    }
}
