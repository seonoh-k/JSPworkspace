package com.nonage.dao;

import com.nonage.dto.MemberVO;
import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

    private MemberDAO() {
    }

    private static MemberDAO instance = new MemberDAO();

    public static MemberDAO getInstance() {
        return instance;
    }


    public int confirmId(String id) {

        String sql = "select * from member where id = ?";
        int message = 0;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()){
                message = 1;
            }else {
                message = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return message;

    }

    public void insertMember(MemberVO member) {

        String sql = "insert into member (id, pwd, name, email, zip_num, address, phone) values (?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPwd());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getEmail());
            pstmt.setString(5, member.getZipNum());
            pstmt.setString(6, member.getAddress());
            pstmt.setString(7, member.getPhone());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
    }

    public MemberVO getMember(String id, String pwd) {

        String sql = "select * from member where id = ? and pwd = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        MemberVO member = new MemberVO();

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();
            if (rs.next()){
                member.setId(rs.getString("id"));
                member.setPwd(rs.getString("pwd"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setZipNum(rs.getString("zip_num"));
                member.setAddress(rs.getString("address"));
                member.setPhone(rs.getString("phone"));
                member.setUseyn(rs.getString("useyn"));
                member.setIndate(rs.getTimestamp("indate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return member;
    }
}
