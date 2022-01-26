package Repository;

import Entity.Clerk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClerkRepository implements Repository<Clerk> {
    private Connection connection;

    public ClerkRepository() {
        try {
            connection = Singleton.getInstance().getConnection();
            String createTable = "CREATE TABLE IF NOT EXISTS " +
                    "Clerk(id serial," +
                    "fullName varchar(50)," +
                    "nationalId varchar(50) PRIMARY KEY ," +
                    "codeBranch varchar(50)," + "" +
                    "password varchar(50))";
            PreparedStatement preparedStatement = connection.prepareStatement(createTable);
            preparedStatement.execute();
        }catch (SQLException | ClassNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void add(Clerk clerk) {
        try {
            String insert = " INSERT INTO Clerk(fullName,nationalId,codeBranch,password) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, clerk.getFullName());
            preparedStatement.setString(2, clerk.getNationalId());
            preparedStatement.setString(3, clerk.getCodeBranch());
            preparedStatement.setString(4, clerk.getPassword());
            preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public int find(String input) {
        return 0;
    }


    public String findCodeBranch(String nationalId) {
        try {
            String findCode = "SELECT * FROM Clerk WHERE nationalId = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(findCode);
            preparedStatement.setString(1, nationalId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return resultSet.getString("codeBranch");
            else
                return null;
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
