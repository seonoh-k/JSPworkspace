package com.saeyan.dao;

import com.saeyan.dto.MemberVO;
import lombok.NoArgsConstructor;
import util.DBManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@NoArgsConstructor
public class MemberDAO {

    private static MemberDAO instance = new MemberDAO();

    public static MemberDAO getInstance() {
        return instance;
    }

    public int userCheck(String userid, String pwd) {

        int result = 0;
        String sql = "SELECT PWD FROM MEMBER WHERE USERID = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                if(rs.getString("pwd").equals(pwd)){
                    result = 1;
                }else{
                    result = 0;
                }
            }else{
                result = -1;
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null) {
                    rs.close();
                }
                if(pstmt != null) {
                    pstmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public MemberVO getMember(String userid) {

        MemberVO mVO = null;

        String sql = "SELECT * FROM MEMBER WHERE USERID = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                mVO = new MemberVO();
                mVO.setName(rs.getString("NAME"));
                mVO.setUserid(rs.getString("USERID"));
                mVO.setPwd(rs.getString("PWD"));
                mVO.setEmail(rs.getString("EMAIL"));
                mVO.setPhone(rs.getString("PHONE"));
                mVO.setAdmin(rs.getInt("ADMIN"));
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null) {
                    rs.close();
                }
                if(pstmt != null) {
                    pstmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        return mVO;
    }
}
