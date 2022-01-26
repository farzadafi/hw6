package Repository;

import Entity.Transaction;
import Entity.TypeTransaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository implements Repository<Transaction> {
    private Connection connection;

    public TransactionRepository() {
        try {
            connection = Singleton.getInstance().getConnection();
            String createTable = "CREATE TABLE IF NOT EXISTS TransactionTable(id serial," +
                    "accountnumber varchar(10)," +
                    "originCardNumber varchar(20)," +
                    "destinationCardNumber varchar(20)," +
                    "amount varchar(50)," +
                    "dateT date," +
                    "timet time," +
                    "typeTransaction varchar(20))";
            PreparedStatement preparedStatement = connection.prepareStatement(createTable);
            preparedStatement.execute();
        }catch (SQLException | ClassNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }


    @Override
    public void add(Transaction transaction) {
        try {
            String insertTransaction = "INSERT INTO TransactionTable (accountnumber,originCardNumber,destinationCardNumber,amount,dateT,timeT,typeTransaction) VALUES (?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(insertTransaction);
            preparedStatement.setString(1, transaction.getAccountNumber());
            preparedStatement.setString(2, transaction.getOriginCardNumber());
            preparedStatement.setString(3, transaction.getDestinationCardNumber());
            preparedStatement.setString(4, transaction.getAmount());
            preparedStatement.setDate(5, transaction.getDate());
            preparedStatement.setTime(6, transaction.getTime());
            preparedStatement.setString(7, String.valueOf(transaction.getTypeTransaction()));
            preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
    }

    public List<Transaction> findAllTransaction(String accountNumber, Date date) {
        try {
            String find = "SELECT * FROM TransactionTable WHERE accountnumber = ? AND dateT >= ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(find);
            preparedStatement.setString(1, accountNumber);
            preparedStatement.setDate(2, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Transaction> transactionList = new ArrayList<>();
            while (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setAccountNumber(resultSet.getString("accountnumber"));
                transaction.setOriginCardNumber(resultSet.getString("originCardNumber"));
                transaction.setDestinationCardNumber(resultSet.getString("destinationCardNumber"));
                transaction.setAmount(resultSet.getString("amount"));
                transaction.setDate(resultSet.getDate("dateT"));
                transaction.setTime(resultSet.getTime("timeT"));
                transaction.setTypeTransaction(TypeTransaction.valueOf(resultSet.getString("typeTransaction")));
                transactionList.add(transaction);
            }
            return transactionList;
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }


    @Override
    public int find(String input) {
        return 0;
    }
}
