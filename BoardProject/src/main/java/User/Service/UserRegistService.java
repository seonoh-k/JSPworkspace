package User.Service;

import static Util.DBUtil.*;
import User.DAO.UserDAO;
import User.DTO.UserDTO;

import java.sql.Connection;


public class UserRegistService {

    public boolean registUser(UserDTO newUser) throws Exception{

        boolean isRegistSuccess = false;

        Connection con = getConnection();
        UserDAO userDAO = new UserDAO(con);

        int isRegisted = userDAO.insertUser(newUser);

        if(isRegisted != 0) {
            isRegistSuccess = true;
            commit(con);
        }else {
            rollback(con);
        }

        return isRegistSuccess;
    }
}
