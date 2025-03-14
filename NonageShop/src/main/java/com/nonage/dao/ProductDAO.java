package com.nonage.dao;

import com.nonage.dto.ProductVO;
import util.DBManager;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {

    private ProductDAO() {
    }

    private static ProductDAO instance = new ProductDAO();

    public static ProductDAO getInstance() {
        return instance;
    }

    //신상품
    public ArrayList<ProductVO> listNewProduct() {

        ArrayList<ProductVO> productList = new ArrayList<>();
        String sql = "select * from new_pro_view";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()){
                ProductVO product = new ProductVO();
                product.setPseq(rs.getInt("pseq"));
                product.setName(rs.getString("name"));
                product.setPrice2(rs.getInt("price2"));
                product.setImage(rs.getString("image"));
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return productList;
    }


    //베스트상품
    public ArrayList<ProductVO> listBestProduct() {

        ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
        String sql = "select *  from best_pro_view";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductVO product = new ProductVO();
                product.setPseq(rs.getInt("pseq"));
                product.setName(rs.getString("name"));
                product.setPrice2(rs.getInt("price2"));
                product.setImage(rs.getString("image"));
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return productList;
    }

    public ProductVO getProduct(String pseq) {

        String sql = "select * from product where pseq = ?";
        ProductVO product = new ProductVO();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pseq);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                product.setPseq(rs.getInt("pseq"));
                product.setName(rs.getString("name"));
                product.setKind(rs.getString("kind"));
                product.setPrice2(rs.getInt("price2"));
                product.setContent(rs.getString("content"));
                product.setImage(rs.getString("image"));
                product.setUseyn(rs.getString("useyn"));
                product.setBestyn(rs.getString("bestyn"));
                product.setIndate(rs.getTimestamp("indate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return product;
    }

    public ArrayList<ProductVO> getProductListByKind(String kind) {

        ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
        String sql = "select *  from product where kind = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kind);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductVO product = new ProductVO();
                product.setPseq(rs.getInt("pseq"));
                product.setName(rs.getString("name"));
                product.setPrice2(rs.getInt("price2"));
                product.setImage(rs.getString("image"));
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return productList;
    }
}
