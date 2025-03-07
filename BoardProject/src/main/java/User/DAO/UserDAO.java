package User.DAO;

import User.DTO.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Util.DBUtil.*;
public class UserDAO {
    Connection con;

    public UserDAO(Connection con) {
        this.con = con;
    }

    public boolean login(int id, String pwd) throws Exception {

        String sql = "SELECT USER_ID, USER_PASS FROM USERS WHERE USER_ID = ? AND USER_PASS = ?";
        PreparedStatement psmt = null;
        ResultSet rs = null;
        boolean isLoginSuccess = false;

        try {

            psmt = con.prepareStatement(sql);

            psmt.setInt(1,id);
            psmt.setString(2,pwd);

            rs = psmt.executeQuery();

            if(rs != null) {
                isLoginSuccess = true;
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            close(rs);
            close(psmt);
        }
        return isLoginSuccess;
    }
    public int insertUser(UserDTO newUser) throws Exception{

        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement psmt = null;
        int result = 0;

        try {

            psmt = con.prepareStatement(sql);

            psmt.setInt(1, newUser.getUser_id());
            psmt.setString(2, newUser.getUser_email());
            psmt.setString(3, newUser.getUser_name());
            psmt.setString(4, newUser.getUser_pass());
            psmt.setString(5, newUser.getUser_gender());
            psmt.setDate(6, newUser.getUser_birth());


            result = psmt.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            close(psmt);
        }

        return result;
    }
}
