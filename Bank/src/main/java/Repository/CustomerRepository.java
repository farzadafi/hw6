package Repository;

import Entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRepository implements Repository<Customer> {
    Connection connection = Singleton.getInstance().getConnection();

    public CustomerRepository() throws SQLException, ClassNotFoundException {
        String createTable ="CREATE TABLE IF NOT EXISTS " +
                "Customer(id serial," +
                "fullName varchar(50)," +
                "nationalId varchar(50) PRIMARY KEY ," +
                "codeBranch varchar(50)," + "" +
                "password varchar(50))";
        PreparedStatement preparedStatement = connection.prepareStatement(createTable);
        preparedStatement.execute();
    }

    @Override
    public void add(Customer customer) throws SQLException {

    }

    @Override
    public int find(String input) throws SQLException {
        return 0;
    }
}
