package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.HotelBean;
import com.rays.util.JDBCDataSource;

public class HotelModel {

    // ADD
    public void add(HotelBean bean) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = JDBCDataSource.getConnection();

            String sql = "insert into hotel_data "
                    + "(HotelId, HotelName, Location, Rating, ContactNo) "
                    + "values (?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);

            pstmt.setLong(1, bean.getHotelId());
            pstmt.setString(2, bean.getHotelName());
            pstmt.setString(3, bean.getLocation());
            pstmt.setDouble(4, bean.getRating());
            pstmt.setString(5, bean.getContactNo());

            int i = pstmt.executeUpdate();

            System.out.println(
                    "record inserted successfully: " + i);

        } catch (Exception e) {

            e.printStackTrace();

            throw new SQLException(
                    "Hotel insertion failed", e);

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    // UPDATE
    public void update(HotelBean bean) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = JDBCDataSource.getConnection();

            String sql = "update hotel_data set "
                    + "HotelName = ?, "
                    + "Location = ?, "
                    + "Rating = ?, "
                    + "ContactNo = ? "
                    + "where HotelId = ?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, bean.getHotelName());
            pstmt.setString(2, bean.getLocation());
            pstmt.setDouble(3, bean.getRating());
            pstmt.setString(4, bean.getContactNo());
            pstmt.setLong(5, bean.getHotelId());

            int i = pstmt.executeUpdate();

            System.out.println(
                    "record updated successfully: " + i);

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    // DELETE
    public void delete(Long id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = JDBCDataSource.getConnection();

            String sql =
                    "delete from hotel_data where HotelId = ?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setLong(1, id);

            int i = pstmt.executeUpdate();

            System.out.println(
                    "record deleted successfully: " + i);

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    // SEARCH
    public List<HotelBean> search(
            HotelBean bean,
            int pageNo,
            int pageSize) throws SQLException {

        List<HotelBean> list =
                new ArrayList<HotelBean>();

        StringBuffer sql =
                new StringBuffer(
                        "select * from hotel_data where 1=1");

        if (bean != null) {

            if (bean.getHotelId() != null
                    && bean.getHotelId() > 0) {

                sql.append(
                        " and HotelId = "
                        + bean.getHotelId());
            }

            if (bean.getHotelName() != null
                    && bean.getHotelName().length() > 0) {

                sql.append(
                        " and HotelName like '"
                        + bean.getHotelName()
                        + "%'");
            }

            if (bean.getLocation() != null
                    && bean.getLocation().length() > 0) {

                sql.append(
                        " and Location like '"
                        + bean.getLocation()
                        + "%'");
            }
        }

        int pageNoIndex =
                (pageNo - 1) * pageSize;

        sql.append(
                " limit "
                + pageNoIndex
                + ", "
                + pageSize);

        System.out.println(
                "sql===> " + sql);

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = JDBCDataSource.getConnection();

            pstmt = conn.prepareStatement(
                    sql.toString());

            rs = pstmt.executeQuery();

            while (rs.next()) {

                HotelBean hBean =
                        new HotelBean();

                hBean.setHotelId(
                        rs.getLong("HotelId"));

                hBean.setHotelName(
                        rs.getString("HotelName"));

                hBean.setLocation(
                        rs.getString("Location"));

                hBean.setRating(
                        rs.getDouble("Rating"));

                hBean.setContactNo(
                        rs.getString("ContactNo"));

                list.add(hBean);
            }

        } finally {

            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }

        return list;
    }
}