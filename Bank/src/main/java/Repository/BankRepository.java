package Repository;

import Entity.Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankRepository implements Repository<Bank>{
    private Connection connection;

    //::::>
    public BankRepository() {
        try {
            connection = Singleton.getInstance().getConnection();
            String createTableBank = "CREATE TABLE IF NOT EXISTS Bank(id serial,nameBank varchar(50) PRIMARY KEY)";
            PreparedStatement preparedStatement = connection.prepareStatement(createTableBank);
            preparedStatement.execute();
        }catch (SQLException | ClassNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    //::::>
    public void add(Bank bank) throws SQLException {
        try {
            String insertBank = "INSERT INTO Bank (nameBank) VALUES (?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(insertBank);
            preparedStatement.setString(1, bank.getName());
            preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
    }

    //::::>
    public int find(String name) throws SQLException {
        try {
            String find = "SELECT * FROM Bank WHERE nameBank = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(find);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return 1;
            else
                return 0;
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return 0;
    }



}//
