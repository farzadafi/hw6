package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginRepository {
    private Connection connection = Singleton.getInstance().getConnection();

    public LoginRepository() throws SQLException, ClassNotFoundException {
        String createTable = "CREATE TABLE IF NOT EXISTS Login(id serial,username varchar(50) PRIMARY KEY,password varchar(50),kind varchar(50) )";
        PreparedStatement preparedStatement = connection.prepareStatement(createTable);
        preparedStatement.execute();
    }
}
