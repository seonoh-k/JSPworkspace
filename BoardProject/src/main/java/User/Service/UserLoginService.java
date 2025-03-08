package User.Service;

import Comment.DTO.CommentDTO;
import User.DAO.UserDAO;

import java.sql.Connection;

import static Util.DBUtil.*;
public class UserLoginService {
    public int userLogin(String id, String pwd) {

        boolean isLoginSuccess = false;
        Connection con = getConnection();
        UserDAO userDAO = new UserDAO(con);
        int user_no = 0;

        try {
            user_no = userDAO.login(id, pwd);
        }catch(Exception e) {
            e.printStackTrace();
        }

        return user_no;
    }
}
