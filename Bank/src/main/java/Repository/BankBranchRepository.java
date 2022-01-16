package Repository;

import Entity.BankBranch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankBranchRepository implements Repository<BankBranch> {
    private Connection connection = Singleton.getInstance().getConnection();

    //::::>
    public BankBranchRepository() throws SQLException, ClassNotFoundException {
        String createTable = "CREATE TABLE IF NOT EXISTS BankBranch(id serial," +
                                                                    "nameBank varchar(50) REFERENCES Bank(nameBank)," +
                                                                    "codeBranch varchar(50) PRIMARY KEY,"+
                                                                    "BossFullName varchar(50)," +
                                                                    "nationalId varchar(50)," +
                                                                    "password varchar(50) )";
        PreparedStatement preparedStatement = connection.prepareStatement(createTable);
        preparedStatement.execute();
    }

    @Override
    public void add(BankBranch bankBranch) throws SQLException {

    }

    @Override
    public int find(String input) throws SQLException {
        String find = "SELECT * FROM BankBranch WHERE codeBranch = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(find);
        preparedStatement.setString(1,input);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next())
            return 1;
        else
            return 0;
    }
}
