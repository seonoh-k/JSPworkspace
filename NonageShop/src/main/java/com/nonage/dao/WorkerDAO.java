package com.nonage.dao;

import com.nonage.dto.QnaVO;
import com.nonage.dto.WorkerVO;
import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WorkerDAO {

    private WorkerDAO() {
    }

    private static WorkerDAO instance = new WorkerDAO();

    public static WorkerDAO getInstance() {
        return instance;
    }

    // 관리자 페이지 로그인
    public WorkerVO getAdmin(String id, String pwd) {

        String sql = "select * from worker where id = ? and pwd = ?";
        WorkerVO admin = new WorkerVO();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                admin.setId(rs.getString("id"));
                admin.setPwd(rs.getString("pwd"));
                admin.setName(rs.getString("name"));
                admin.setPhone(rs.getString("phone"));
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt, rs);
        }

        return admin;
    }
}
