package User.DAO;

import User.DTO.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static User.Util.UserUtil.*;
public class UserDAO {
    Connection con;

    public UserDAO(Connection con) {
        this.con = con;
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
