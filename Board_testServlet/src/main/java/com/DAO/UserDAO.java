package com.DAO;

import com.domain.User;

import static com.db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    Connection con;

    public UserDAO(Connection con) {
        this.con = con;
    }

    public int insertUser(User newUser) throws Exception{

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
