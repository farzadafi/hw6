package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankRepository {
    private Connection connection = Singleton.getInstance().getConnection();

    public BankRepository() throws SQLException, ClassNotFoundException {
        String createTableBank = "CREATE TABLE IF NOT EXISTS Bank (id serial,name varchar(50)) ";
        PreparedStatement preparedStatement = connection.prepareStatement(createTableBank);
        preparedStatement.execute();
    }
}
