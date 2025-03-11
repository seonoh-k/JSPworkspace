package User.DAO;

import static Util.DBUtil.*;
import User.DTO.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDAO {
    Connection con;

    public UserDAO(Connection con) {
        this.con = con;
    }

    public int login(String id, String pwd) throws Exception {

        String sql = "SELECT USER_NO FROM USERS WHERE USER_ID = ? AND USER_PASS = ?";

        try (PreparedStatement psmt = con.prepareStatement(sql)) {

            psmt.setString(1,id);
            psmt.setString(2,pwd);

            try (ResultSet rs = psmt.executeQuery()) {
                if(rs.next()) {
                    return rs.getInt("USER_NO");
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int insertUser(UserDTO newUser) throws Exception{

        String sql = "INSERT INTO USERS VALUES (USER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
        int result = 0;

        try (PreparedStatement psmt = con.prepareStatement(sql)) {

            psmt.setString(1, newUser.getUser_id());
            psmt.setString(2, newUser.getUser_email());
            psmt.setString(3, newUser.getUser_name());
            psmt.setString(4, newUser.getUser_pass());
            psmt.setString(5, newUser.getUser_gender());
            psmt.setDate(6, newUser.getUser_birth());


            result = psmt.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
