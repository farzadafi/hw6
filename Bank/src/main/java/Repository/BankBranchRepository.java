package Repository;

import Entity.BankBranch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankBranchRepository implements Repository<BankBranch> {
    private Connection connection = Singleton.getInstance().getConnection();

    public BankBranchRepository() throws SQLException, ClassNotFoundException {
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
