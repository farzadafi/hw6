package Repository;

import Entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository implements Repository<Customer> {
    private Connection connection;

    public CustomerRepository() {
        try {
            connection = Singleton.getInstance().getConnection();
            String createTable = "CREATE TABLE IF NOT EXISTS " +
                    "Customer(id serial," +
                    "fullName varchar(50)," +
                    "nationalId varchar(50) PRIMARY KEY ," +
                    "codeBranch varchar(50) REFERENCES BankBranch(codeBranch)," +
                    "password varchar(50))";
            PreparedStatement preparedStatement = connection.prepareStatement(createTable);
            preparedStatement.execute();
        }catch (SQLException | ClassNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void add(Customer customer) {
        try {
            String insertCustomer = " INSERT INTO Customer(fullName,nationalId,codeBranch,password) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertCustomer);
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getNationalId());
            preparedStatement.setString(3, customer.getCodeBranch());
            preparedStatement.setString(4, customer.getPassword());
            preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public int find(String input) {
        return 0;
    }

    //::::>
    public String findName(String nationalId) {
        try {
            String find = "SELECT * FROM Customer WHERE nationalId = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(find);
            preparedStatement.setString(1, nationalId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return resultSet.getString("fullName");
            else
                return "null";
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return "null";
    }
}
