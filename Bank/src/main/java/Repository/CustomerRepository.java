package Repository;

import Entity.Customer;

import java.sql.SQLException;

public class CustomerRepository implements Repository<Customer> {
    @Override
    public void add(Customer customer) throws SQLException {

    }

    @Override
    public int find(String input) throws SQLException {
        return 0;
    }
}
