package Service;

import Repository.LoginRepository;

import java.sql.SQLException;

public class LoginService {
    private LoginRepository loginRepository = new LoginRepository();

    public LoginService() throws SQLException, ClassNotFoundException {
    }

    //::::>
    public int findNationalId(String nationalId) throws SQLException {
        return loginRepository.find(nationalId);
    }


}//
