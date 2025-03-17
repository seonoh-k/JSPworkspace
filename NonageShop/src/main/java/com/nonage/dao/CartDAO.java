package com.nonage.dao;

import com.nonage.dto.CartVO;
import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    public ArrayList<CartVO> listCart(String userid) {

        String sql = "select * from cart_view where id = ? order by cseq desc";
        ArrayList<CartVO> cartList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                CartVO cart = new CartVO();
                cart.setCseq(rs.getInt(1));
                cart.setId(rs.getString(2));
                cart.setPseq(rs.getInt(3));
                cart.setMname(rs.getString(4));
                cart.setPname(rs.getString(5));
                cart.setQuantity(rs.getInt(6));
                cart.setIndate(rs.getTimestamp(7));
                cart.setPrice2(rs.getInt(8));
                cartList.add(cart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return cartList;
    }

    public void deleteCart(int cseq) {

        String sql = "delete cart where cseq = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cseq);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
    }
}
