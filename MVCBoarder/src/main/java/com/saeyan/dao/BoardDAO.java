package com.saeyan.dao;

import com.saeyan.dto.BoardVO;
import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    private BoardDAO() {
    }

    private static BoardDAO instance = new BoardDAO();

    public static BoardDAO getInstance() {
        return instance;
    }

    public List<BoardVO> selectAllBoards() {

        String sql = "select * from board order by num desc";
        List<BoardVO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                BoardVO bVo = new BoardVO();
                bVo.setNum(rs.getInt("num"));
                bVo.setName(rs.getString("name"));
                bVo.setEmail(rs.getString("email"));
                bVo.setPass(rs.getString("pass"));
                bVo.setTitle(rs.getString("title"));
                bVo.setContent(rs.getString("content"));
                bVo.setReadcount(rs.getInt("readcount"));
                bVo.setWritedate(rs.getTimestamp("writedate"));
                list.add(bVo);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt, rs);
        }

        return list;
    }

    public int getListCount() {

        int count = 0;

        String sql = "select count(*) from board";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                // count(*) 함수를 컬럼명으로 사용할 수 없음
                count = rs.getInt(1);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt, rs);
        }

        return count;
    }

    public List<BoardVO> getBoardList(int page, int limit) {

        String sql = "select  num,pass,name,email,title,content,readcount,writedate" +
                " from (" +
                "            select rownum rm,b1.* " +
                "            from ( " +
                "                       select * " +
                "                       from board " +
                "                       order by num desc " +
                "                     ) b1 " +
                "        )b2 " +
                " where rm >= ? and rm <= ? ";

        int startrow = (page - 1) * limit + 1;
        int endrow = startrow + limit - 1;

        List<BoardVO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, startrow);
            pstmt.setInt(2, endrow);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                BoardVO bVo = new BoardVO();
                bVo.setNum(rs.getInt("num"));
                bVo.setName(rs.getString("name"));
                bVo.setEmail(rs.getString("email"));
                bVo.setPass(rs.getString("pass"));
                bVo.setTitle(rs.getString("title"));
                bVo.setContent(rs.getString("content"));
                bVo.setReadcount(rs.getInt("readcount"));
                bVo.setWritedate(rs.getTimestamp("writedate"));
                list.add(bVo);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt, rs);
        }

        return list;
    }

    public void insertBoard(BoardVO bVo) {

        String sql = "insert into board (num, name, email, pass, title, content) values(board_seq.nextval, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bVo.getName());
            pstmt.setString(2, bVo.getEmail());
            pstmt.setString(3, bVo.getPass());
            pstmt.setString(4, bVo.getTitle());
            pstmt.setString(5, bVo.getContent());
            pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt);
        }
    }

    public void updateReadCount(String num) {

        String sql = "update board set readcount = readcount+1 where num =?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt);
        }
    }

    public BoardVO selectOneBoardByNum(String num) {

        String sql = "select * from board where num = ?";
        BoardVO bVo = new BoardVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                bVo.setNum(rs.getInt("num"));
                bVo.setName(rs.getString("name"));
                bVo.setEmail(rs.getString("email"));
                bVo.setPass(rs.getString("pass"));
                bVo.setTitle(rs.getString("title"));
                bVo.setContent(rs.getString("content"));
                bVo.setReadcount(rs.getInt("readcount"));
                bVo.setWritedate(rs.getTimestamp("writedate"));
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt, rs);
        }

        return bVo;
    }

    public void updateBoard(BoardVO bVo) {

    }

    public BoardVO checkPassWord(String pass, String num) {

        String sql = "select * from board where num = ? and pass like ?";
        BoardVO bVo = new BoardVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            pstmt.setString(2, pass);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                bVo.setNum(rs.getInt("num"));
                bVo.setName(rs.getString("name"));
                bVo.setEmail(rs.getString("email"));
                bVo.setPass(rs.getString("pass"));
                bVo.setTitle(rs.getString("title"));
                bVo.setContent(rs.getString("content"));
                bVo.setReadcount(rs.getInt("readcount"));
                bVo.setWritedate(rs.getTimestamp("writedate"));
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt, rs);
        }

        return bVo;
    }

    public void deleteBoard(String num) {

        String sql = "delete board where num = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt);
        }
    }
}
