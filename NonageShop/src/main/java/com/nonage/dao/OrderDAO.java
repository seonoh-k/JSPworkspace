package com.nonage.dao;

import com.nonage.dto.CartVO;
import com.nonage.dto.OrderVO;
import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderDAO {

    private OrderDAO() {
    }

    private static OrderDAO instance = new OrderDAO();

    public static OrderDAO getInstance() {
        return instance;
    }

    public int insertOrder(ArrayList<CartVO> cartList, String userid) {


        int maxOseq = 0;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();

            String insertOrder = "insert into orders (oseq, id) values (orders_seq.nextval, ?)";

            pstmt = conn.prepareStatement(insertOrder);
            pstmt.setString(1, userid);
            pstmt.executeUpdate();

            pstmt.close();

            // 현재 주문한 주문 번호 조회
            String selectMaxOseq = "select max(oseq) from orders";
            pstmt = conn.prepareStatement(selectMaxOseq);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                maxOseq = rs.getInt(1);
            }

            for(CartVO cart : cartList) {
                insertOrderDetail(cart, maxOseq);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
        return maxOseq;
    }

    public void insertOrderDetail(CartVO cart, int maxOseq) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String insertOrderDetail = "insert into order_detail (odseq, pseq, oseq, quantity) values (order_detail_seq.nextval, ?, ?, ?)";

            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(insertOrderDetail);

            pstmt.setInt(1, cart.getPseq());
            pstmt.setInt(2, maxOseq);
            pstmt.setInt(3, cart.getQuantity());
            pstmt.executeUpdate();
            pstmt.close();

            String updateCartResult = "update cart set result = 2 where cseq = ?";

            pstmt = conn.prepareStatement(updateCartResult);
            pstmt.setInt(1, cart.getCseq());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
    }

    public ArrayList<OrderVO> listOrderById(String userid, String result, int oseq) {

        String sql = "select * from order_view where id = ? and oseq = ? and result like '%'||?||'%'";

        ArrayList<OrderVO> orderList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userid);
            pstmt.setInt(2, oseq);
            pstmt.setString(3, result);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                OrderVO order = new OrderVO();
                order.setOdseq(rs.getInt(1));
                order.setOseq(rs.getInt(2));
                order.setId(rs.getString(3));
                order.setIndate(rs.getTimestamp(4));
                order.setPseq(rs.getInt(5));
                order.setQuantity(rs.getInt(6));
                order.setMname(rs.getString(7));
                order.setZipNum(rs.getString(8));
                order.setAddress(rs.getString(9));
                order.setPhone(rs.getString(10));
                order.setPname(rs.getString(11));
                order.setPrice2(rs.getInt(12));
                orderList.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return orderList;
    }

    public int getListCount() {

        int count = 0;

        String sql = "select count(*) from order_view";
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

    // 관리자 페이지 상품 리스트
    public ArrayList<OrderVO> adminOrderList(int page, int limit) {

        String sql = "select  *" +
                " from (" +
                "            select rownum rm,p1.* " +
                "            from ( " +
                "                       select * " +
                "                       from order_view " +
                "                       order by indate desc " +
                "                     ) p1 " +
                "        )p2 " +
                " where rm >= ? and rm <= ? ";

        int startrow = (page - 1) * limit + 1;
        int endrow = startrow + limit - 1;
        ArrayList<OrderVO> orderList = new ArrayList<>();

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
                OrderVO order = new OrderVO();
                order.setOseq(rs.getInt("oseq"));
                order.setId(rs.getString("id"));
                order.setIndate(rs.getTimestamp("indate"));
                order.setPseq(rs.getInt("pseq"));
                order.setQuantity(rs.getInt("quantity"));
                order.setMname(rs.getString("mname"));
                order.setPname(rs.getString("pname"));
                order.setPrice2(rs.getInt("price2"));
                order.setResult(rs.getString("result"));
                orderList.add(order);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt, rs);
        }
        return orderList;
    }

    public int getSearchListCount(String pname) {

        int count = 0;

        String sql = "select count(*) from order_view where pname like '%'||?||'%'";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pname);
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

    // 관리자 페이지 상품 리스트
    public ArrayList<OrderVO> adminOrderSearchList(String pname, int page, int limit) {

        String sql = "select  *" +
                " from (" +
                "            select rownum rm,p1.* " +
                "            from ( " +
                "                       select * " +
                "                       from order_view where pname like '%'||?||'%'" +
                "                       order by indate desc " +
                "                     ) p1 " +
                "        )p2 " +
                " where rm >= ? and rm <= ? ";

        int startrow = (page - 1) * limit + 1;
        int endrow = startrow + limit - 1;
        ArrayList<OrderVO> orderList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pname);
            pstmt.setInt(2, startrow);
            pstmt.setInt(3, endrow);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                OrderVO order = new OrderVO();
                order.setOseq(rs.getInt("oseq"));
                order.setId(rs.getString("id"));
                order.setIndate(rs.getTimestamp("indate"));
                order.setPseq(rs.getInt("pseq"));
                order.setQuantity(rs.getInt("quantity"));
                order.setMname(rs.getString("mname"));
                order.setPname(rs.getString("pname"));
                order.setPrice2(rs.getInt("price2"));
                order.setResult(rs.getString("result"));
                orderList.add(order);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt, rs);
        }
        return orderList;
    }

    public OrderVO getOrder(String oseq) {

        String sql = "select * from order_view where oseq = ?";
        OrderVO order = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, oseq);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                order = new OrderVO();
                order.setOdseq(rs.getInt("odseq"));
                order.setOseq(rs.getInt("oseq"));
                order.setId(rs.getString("id"));
                order.setIndate(rs.getTimestamp("indate"));
                order.setPseq(rs.getInt("pseq"));
                order.setQuantity(rs.getInt("quantity"));
                order.setMname(rs.getString("mname"));
                order.setZipNum(rs.getString("zip_num"));
                order.setAddress(rs.getString("address"));
                order.setPhone(rs.getString("phone"));
                order.setPname(rs.getString("pname"));
                order.setPrice2(rs.getInt("price2"));
                order.setResult(rs.getString("result"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return order;
    }
}
