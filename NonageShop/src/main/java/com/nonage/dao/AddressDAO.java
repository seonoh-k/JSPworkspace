package com.nonage.dao;

import com.nonage.dto.AddressVO;
import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AddressDAO {

    private AddressDAO() {
    }

    private static AddressDAO instance = new AddressDAO();

    public static AddressDAO getInstance() {
        return instance;
    }

    public ArrayList<AddressVO> selectAddressByDong(String dong) {

        String sql = "select * from address where dong like ?";
        ArrayList<AddressVO> addressList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dong);
            rs = pstmt.executeQuery();

            while (rs.next()){
                AddressVO address = new AddressVO();
                address.setZipNum(rs.getString("zip_num"));
                address.setSido(rs.getString("sido"));
                address.setGugun(rs.getString("gugun"));
                address.setDong(rs.getString("dong"));
                address.setZipCode(rs.getString("zip_code"));
                address.setBunji(rs.getString("bunji"));
                addressList.add(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return addressList;
    }
}
