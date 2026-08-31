package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.LibraryBean;
import com.rays.util.JDBCDataSource;

public class LibraryModel {

    public void add(LibraryBean bean) throws SQLException {

        Connection conn = null;

        try {

            conn = JDBCDataSource.getConnection();
            conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(
                    "insert into library_data values(?, ?, ?, ?, ?)");

            pstmt.setInt(1, bean.getLibraryId());
            pstmt.setString(2, bean.getLibraryName());
            pstmt.setString(3, bean.getAddress());
            pstmt.setInt(4, bean.getTotalBooks());
            pstmt.setString(5, bean.getContactNo());

            int i = pstmt.executeUpdate();

            conn.commit();

            System.out.println("record inserted successfully: " + i);

        } catch (Exception e) {

            e.printStackTrace();

            if (conn != null) {
                conn.rollback();
            }

            throw new SQLException(e);

        } finally {

            if (conn != null) {
                conn.close();
            }
        }
    }


    public void update(LibraryBean bean) throws SQLException {

        Connection conn = null;

        try {

            conn = JDBCDataSource.getConnection();
            conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(
                    "update library_data set libraryName = ?, address = ?, totalBooks = ?, contactNo = ? where libraryId = ?");

            pstmt.setString(1, bean.getLibraryName());
            pstmt.setString(2, bean.getAddress());
            pstmt.setInt(3, bean.getTotalBooks());
            pstmt.setString(4, bean.getContactNo());
            pstmt.setInt(5, bean.getLibraryId());

            int i = pstmt.executeUpdate();

            conn.commit();

            System.out.println("record updated successfully: " + i);

        } catch (Exception e) {

            e.printStackTrace();

            if (conn != null) {
                conn.rollback();
            }

            throw new SQLException(e);

        } finally {

            if (conn != null) {
                conn.close();
            }
        }
    }


    public void delete(int id) throws SQLException {

        Connection conn = null;

        try {

            conn = JDBCDataSource.getConnection();
            conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(
                    "delete from library_data where libraryId = ?");

            pstmt.setInt(1, id);

            int i = pstmt.executeUpdate();

            conn.commit();

            System.out.println("record deleted successfully: " + i);

        } catch (Exception e) {

            e.printStackTrace();

            if (conn != null) {
                conn.rollback();
            }

            throw new SQLException(e);

        } finally {

            if (conn != null) {
                conn.close();
            }
        }
    }


    // Search method
    public List<LibraryBean> search(LibraryBean bean, int pageNo, int pageSize)
            throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<LibraryBean> list = new ArrayList<LibraryBean>();

        int start = (pageNo - 1) * pageSize;

        try {

            conn = JDBCDataSource.getConnection();

            String sql = "select * from library_data limit ?, ?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, start);
            pstmt.setInt(2, pageSize);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                LibraryBean b = new LibraryBean();

                b.setLibraryId(rs.getInt("libraryId"));
                b.setLibraryName(rs.getString("libraryName"));
                b.setAddress(rs.getString("address"));
                b.setTotalBooks(rs.getInt("totalBooks"));
                b.setContactNo(rs.getString("contactNo"));

                list.add(b);
            }

        } catch (Exception e) {

            e.printStackTrace();

            throw new SQLException(e);

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