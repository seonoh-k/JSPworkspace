package com.saeyan.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ProductVO;
import util.DBManager;
public class ProductDAO {
    private ProductDAO() {}

    private static ProductDAO instance = new ProductDAO();

    public static ProductDAO getInstance() {
        return instance;
    }

    // c
    public void insertProduct(ProductVO pVO) {
        String sql = "insert into product values(product_seq.nextval, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pVO.getName());
            pstmt.setInt(2, pVO.getPrice());
            pstmt.setString(3, pVO.getPictureUrl());
            pstmt.setString(4, pVO.getDescription());
            pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt);
        }
    }
    // r
    public List<ProductVO> selectAllProducts() {
        // 최근 등록한 상품 먼저 출력하기
        String sql = "select * from product order by code desc";
        List<ProductVO> list = new ArrayList<ProductVO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                ProductVO pVO = new ProductVO();
                pVO.setCode(rs.getInt("code"));
                pVO.setName(rs.getString("name"));
                pVO.setPrice(rs.getInt("price"));
                pVO.setPictureUrl(rs.getString("pictureUrl"));
                pVO.setDescription(rs.getString("description"));
                list.add(pVO);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt, rs);
        }
        return list;
    }

    public ProductVO selectProductByCode(String code) {

        String sql = "select * from product where code like ? order by code desc";
        ProductVO pVO = new ProductVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, code);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                pVO.setCode(rs.getInt("code"));
                pVO.setName(rs.getString("name"));
                pVO.setPrice(rs.getInt("price"));
                pVO.setPictureUrl(rs.getString("pictureUrl"));
                pVO.setDescription(rs.getString("description"));
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt, rs);
        }


        return pVO;
    }

    // u
    public void updateProduct(ProductVO pVO) {
        String sql = "update product set name = ?, price = ?, pictureurl = ?, description = ? where code = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pVO.getName());
            pstmt.setInt(2, pVO.getPrice());
            pstmt.setString(3, pVO.getPictureUrl());
            pstmt.setString(4, pVO.getDescription());
            pstmt.setInt(5, pVO.getCode());
            pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt);
        }
    }

    // d
    public void deleteProduct(String code) {
        String sql = "delete product where code = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, code);
            pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt);
        }
    }

}
