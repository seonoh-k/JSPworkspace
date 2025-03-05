package board.dao;

import static board.db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    Connection con;

    public UserDAO(Connection con) {
        this.con = con;
    }

    public int insertUser(User newUser) throws Exception{

        String sql = "INSERT INTO USER VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement psmt = null;
        int result = 0;

        try {

            psmt = con.prepareStatement(sql);

            psmt.setInt(1, newUser.getUser_id());
            psmt.setString(2, newUser.getUser_email());
            psmt.setInt(3, newUser.getUser_name());
            psmt.setInt(4, newUser.getUser_pass());
            psmt.setInt(5, newUser.getUser_gender());
            psmt.setInt(6, newUser.getUser_birth());


            result = psmt.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            close(psmt);
        }

        return result;
    }
}
