package Repository;

import Entity.BankBranch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankBranchRepository implements Repository<BankBranch> {
    private Connection connection;

    //::::>
    public BankBranchRepository() {
        try {
            connection = Singleton.getInstance().getConnection();
            String createTable = "CREATE TABLE IF NOT EXISTS BankBranch(id serial," +
                    "nameBank varchar(50) REFERENCES Bank(nameBank)," +
                    "codeBranch varchar(50) PRIMARY KEY," +
                    "BossFullName varchar(50)," +
                    "nationalId varchar(50)," +
                    "password varchar(50) )";
            PreparedStatement preparedStatement = connection.prepareStatement(createTable);
            preparedStatement.execute();
        }catch (SQLException | ClassNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void add(BankBranch bankBranch) {
        try {
            String insertBank = "INSERT INTO BankBranch (nameBank,codeBranch,BossfullName,nationalId,password) VALUES (?, ?, ?, ?, ?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(insertBank);
            preparedStatement.setString(1, bankBranch.getNameBank());
            preparedStatement.setString(2, bankBranch.getCodeBranch());
            preparedStatement.setString(3, bankBranch.getBossFullName());
            preparedStatement.setString(4, bankBranch.getNationalId());
            preparedStatement.setString(5, bankBranch.getPassword());
            preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public int find(String input) {
        try {
            String find = "SELECT * FROM BankBranch WHERE codeBranch = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(find);
            preparedStatement.setString(1, input);
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


    public String findCodeBranch(String nationalId) {
        try {
            String findCode = "SELECT * FROM BankBranch WHERE nationalId = ? ";
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
