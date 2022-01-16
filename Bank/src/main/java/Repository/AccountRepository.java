package Repository;

import Entity.Account;

import java.sql.SQLException;

public class AccountRepository implements Repository<Account> {

    @Override
    public void add(Account account) throws SQLException {

    }

    @Override
    public int find(String input) throws SQLException {
        return 0;
    }
}
