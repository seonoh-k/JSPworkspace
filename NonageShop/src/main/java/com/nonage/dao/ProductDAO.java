package com.nonage.dao;

import com.nonage.dto.ProductVO;
import util.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                product.setPrice1(rs.getInt("price1"));
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

    public int getListCount() {

        int count = 0;

        String sql = "select count(*) from product";
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
    public ArrayList<ProductVO> adminProductList(int page, int limit) {

        String sql = "select  pseq, name, price1, price2, indate, useyn" +
                " from (" +
                "            select rownum rm,p1.* " +
                "            from ( " +
                "                       select * " +
                "                       from product " +
                "                       order by indate desc " +
                "                     ) p1 " +
                "        )p2 " +
                " where rm >= ? and rm <= ? ";

        int startrow = (page - 1) * limit + 1;
        int endrow = startrow + limit - 1;
        ArrayList<ProductVO> productList = new ArrayList<>();

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
                ProductVO product = new ProductVO();
                product.setPseq(rs.getInt("pseq"));
                product.setName(rs.getString("name"));
                product.setPrice1(rs.getInt("price1"));
                product.setPrice2(rs.getInt("price2"));
                product.setIndate(rs.getTimestamp("indate"));
                product.setUseyn(rs.getString("useyn"));
                productList.add(product);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt, rs);
        }
        return productList;
    }

    // 관리자 페이지 상품 등록
    public void adminProductInsert(ProductVO product) {

        String sql = "insert into product (pseq, name, kind, price1, price2, price3, content, image)" +
                " values (product_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getKind());
            pstmt.setInt(3, product.getPrice1());
            pstmt.setInt(4, product.getPrice2());
            pstmt.setInt(5, product.getPrice3());
            pstmt.setString(6, product.getContent());
            pstmt.setString(7, product.getImage());

            pstmt.executeUpdate();

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt);
        }
    }

    public int getSearchListCount(String name) {

        int count = 0;

        String sql = "select count(*) from product where name like '%'||?||'%'";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
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

    // 관리자 페이지 상품 검색
    public ArrayList<ProductVO> adminProductSearchList(String name, int page, int limit) {

        ArrayList<ProductVO> productList = new ArrayList<>();
        String sql = "select  *" +
                " from (" +
                "            select rownum rm,p1.* " +
                "            from ( " +
                "                       select * " +
                "                       from product where name like '%'||?||'%' " +
                "                       order by indate desc " +
                "                     ) p1 " +
                "        )p2 " +
                " where rm >= ? and rm <= ? ";

        int startrow = (page - 1) * limit + 1;
        int endrow = startrow + limit - 1;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, startrow);
            pstmt.setInt(3, endrow);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductVO product = new ProductVO();
                product.setPseq(rs.getInt("pseq"));
                product.setName(rs.getString("name"));
                product.setPrice1(rs.getInt("price1"));
                product.setPrice2(rs.getInt("price2"));
                product.setIndate(rs.getTimestamp("indate"));
                product.setUseyn(rs.getString("useyn"));
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return productList;
    }

    // 관리자 페이지 상품 수정
    public void adminProductUpdate(ProductVO product) {

        String sql = "update product set name = ?, kind = ?, price1 = ?, price2 = ?, price3 = ?, " +
                        "content = ?, image = ?, useyn = ?, bestyn = ? where pseq = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getKind());
            pstmt.setInt(3, product.getPrice1());
            pstmt.setInt(4, product.getPrice2());
            pstmt.setInt(5, product.getPrice3());
            pstmt.setString(6, product.getContent());
            pstmt.setString(7, product.getImage());
            pstmt.setString(8, product.getUseyn());
            pstmt.setString(9, product.getBestyn());
            pstmt.setInt(10, product.getPseq());

            pstmt.executeUpdate();

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt);
        }
    }
}
