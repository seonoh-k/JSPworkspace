package com.nonage.dao;

import com.nonage.dto.CartVO;
import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CartDAO {

    private CartDAO() {
    }

    private static CartDAO instance = new CartDAO();

    public static CartDAO getInstance() {
        return instance;
    }

    public void insertCart(CartVO cart) {

        String sql = "insert into cart (cseq, id, pseq, quantity) values (cart_seq.nextval, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cart.getId());
            pstmt.setInt(2, cart.getPseq());
            pstmt.setInt(3, cart.getQuantity());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }

    }
}
