package com.service;

import com.DAO.UserDAO;

import com.db.JdbcUtil.*;
import com.domain.User;

import java.sql.Connection;

import static com.db.JdbcUtil.*;

public class UserRegistService {

    public boolean registUser(User newUser) throws Exception{

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
