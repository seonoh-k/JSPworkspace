package com.nonage.dao;

import com.nonage.dto.OrderVO;
import com.nonage.dto.QnaVO;
import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QnaDAO {

    private QnaDAO() {
    }

    private static QnaDAO instance = new QnaDAO();

    public static QnaDAO getInstance() {
        return instance;
    }

    public ArrayList<QnaVO> selectQnaList(String userid) {

        String sql = "select * from qna where id = ?";
        ArrayList<QnaVO> qnaList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                QnaVO qna = new QnaVO();
                qna.setQseq(rs.getInt("qseq"));
                qna.setSubject(rs.getString("subject"));
                qna.setContent(rs.getString("content"));
                qna.setId(rs.getString("id"));
                qna.setIndate(rs.getTimestamp("indate"));
                qna.setReply(rs.getString("reply"));
                qna.setRep(rs.getString("rep"));
                qnaList.add(qna);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return qnaList;
    }

    public QnaVO selectQna(int qseq) {

        String sql = "select * from qna where qseq = ?";
        QnaVO qna = new QnaVO();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, qseq);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                qna.setQseq(rs.getInt("qseq"));
                qna.setSubject(rs.getString("subject"));
                qna.setContent(rs.getString("content"));
                qna.setId(rs.getString("id"));
                qna.setIndate(rs.getTimestamp("indate"));
                qna.setReply(rs.getString("reply"));
                qna.setRep(rs.getString("rep"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return qna;
    }

    public void insertQna(QnaVO qna, String userid) {

        String sql = "insert into qna (qseq, id, subject, content) values (qna_seq.nextval, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userid);
            pstmt.setString(2, qna.getSubject());
            pstmt.setString(3, qna.getContent());

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
    }

    public ArrayList<QnaVO> adminQnaList() {
        ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();

        String sql =  "SELECT qseq, subject, id, indate, rep FROM qna ORDER BY qseq DESC";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()){
                QnaVO qna = new QnaVO();
                qna.setQseq(rs.getInt("qseq"));
                qna.setSubject(rs.getString("subject"));
                qna.setId(rs.getString("id"));
                qna.setRep(rs.getString("rep"));
                qna.setIndate(rs.getTimestamp("indate"));

                qnaList.add(qna);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return qnaList;
    }

    public void adminQnaInsertReply(QnaVO qnaVO) {
        String sql = "UPDATE qna SET reply = ?, rep = 2 WHERE qseq = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, qnaVO.getReply());
            pstmt.setInt(2, qnaVO.getQseq());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
    }
}
