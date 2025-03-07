package User.Service;

import Comment.DTO.CommentDTO;
import User.DAO.UserDAO;

import java.sql.Connection;

import static Util.DBUtil.*;
public class UserLoginService {
    public boolean userLogin(String id, String pwd) {

        boolean isLoginSuccess = false;
        Connection con = getConnection();
        UserDAO userDAO = new UserDAO(con);

        try {
            isLoginSuccess = userDAO.login(id, pwd);
        }catch(Exception e) {
            e.printStackTrace();
        }

        return isLoginSuccess;
    }
}
