package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.ProductBean;
import com.rays.util.JDBCDataSource;

public class ProductModel {

   
        public void add(ProductBean bean) throws SQLException {

            Connection conn = null;
            PreparedStatement pstmt = null;

            try {

                conn = JDBCDataSource.getConnection();

                String sql = "insert into product_data "
                        + "(productId, productName, price, quantity, category) "
                        + "values (?, ?, ?, ?, ?)";

                pstmt = conn.prepareStatement(sql);

                pstmt.setLong(1, bean.getProductId());
                pstmt.setString(2, bean.getProductName());
                pstmt.setDouble(3, bean.getPrice());
                pstmt.setInt(4, bean.getQuantity());
                pstmt.setString(5, bean.getCategory());

                int i = pstmt.executeUpdate();

                System.out.println("record inserted successfully: " + i);

            } catch (Exception e) {

                e.printStackTrace();

                throw new SQLException("Product insertion failed", e);

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
        public void update(ProductBean bean) throws SQLException {

            Connection conn = null;
            PreparedStatement pstmt = null;

            try {

                conn = JDBCDataSource.getConnection();

                String sql = "update product_data set "
                        + "productName = ?, "
                        + "price = ?, "
                        + "quantity = ?, "
                        + "category = ? "
                        + "where productId = ?";

                pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, bean.getProductName());
                pstmt.setDouble(2, bean.getPrice());
                pstmt.setInt(3, bean.getQuantity());
                pstmt.setString(4, bean.getCategory());
                pstmt.setLong(5, bean.getProductId());

                int i = pstmt.executeUpdate();

                System.out.println("record updated successfully: " + i);

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
                    "delete from product_data where productId = ?";

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
    public List<ProductBean> search(ProductBean bean, int pageNo, int pageSize) throws SQLException {

        List<ProductBean> list = new ArrayList<ProductBean>();

        StringBuffer sql = new StringBuffer(
                "select * from product_data where 1=1");

        if (bean != null) {

            if (bean.getProductId() != null && bean.getProductId() > 0) {

                sql.append(" and productId = " + bean.getProductId());
            }

            if (bean.getProductName() != null
                    && bean.getProductName().length() > 0) {

                sql.append(" and productName like '"
                        + bean.getProductName() + "%'");
            }

            if (bean.getPrice() != null && bean.getPrice() > 0) {

                sql.append(" and price = " + bean.getPrice());
            }

            if (bean.getQuantity() > 0) {

                sql.append(" and quantity = " + bean.getQuantity());
            }

            if (bean.getCategory() != null
                    && bean.getCategory().length() > 0) {

                sql.append(" and category like '"
                        + bean.getCategory() + "%'");
            }
        }

        int pageNoIndex = (pageNo - 1) * pageSize;

        sql.append(" limit " + pageNoIndex + ", " + pageSize);

        System.out.println("sql===> " + sql);

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = JDBCDataSource.getConnection();

            pstmt = conn.prepareStatement(sql.toString());

            rs = pstmt.executeQuery();

            while (rs.next()) {

                ProductBean pBean = new ProductBean();

                pBean.setProductId(rs.getLong("productId"));

                pBean.setProductName(rs.getString("productName"));

                pBean.setPrice(rs.getDouble("price"));

                pBean.setQuantity(rs.getInt("quantity"));

                pBean.setCategory(rs.getString("category"));

                list.add(pBean);
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