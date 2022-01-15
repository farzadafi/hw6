package Repository;

import java.sql.Connection;
import java.sql.SQLException;

public class BankRepository {
    private Connection connection = Singleton.getInstance().getConnection();

    public BankRepository() throws SQLException, ClassNotFoundException {

    }
}
