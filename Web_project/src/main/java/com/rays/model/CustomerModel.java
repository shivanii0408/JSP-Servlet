package com.rays.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rays.bean.CustomerBean;
import com.rays.util.JDBCDataSource;
import com.rays.util.JDBCDataSource;

public class CustomerModel {

	public void add(CustomerBean bean) throws SQLException {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into customer_data values( ?, ?, ?, ?, ?)");

			pstmt.setLong(1, bean.getCustomerId());
			pstmt.setString(2, bean.getCustomerName());
			pstmt.setString(3, bean.getEmail());
			pstmt.setString(4, bean.getPhoneNo());
			pstmt.setString(5, bean.getAddress());

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record inserted successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public void update(CustomerBean bean) throws SQLException {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update customer_data set customerName = ?, email = ?, phoneNo = ?, address = ? where customerId = ?");

			pstmt.setLong(1, bean.getCustomerId());
			pstmt.setString(2, bean.getCustomerName());
			pstmt.setString(3, bean.getEmail());
			pstmt.setString(4, bean.getPhoneNo());
			pstmt.setString(5, bean.getAddress());

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record updated successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public void delete(int id) throws SQLException {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from customer_data where cutomerId = ?");

			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record delete successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	// SEARCH METHOD
	public List<CustomerBean> search(CustomerBean bean, int pageNo, int pageSize)
			throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<CustomerBean> list = new ArrayList<CustomerBean>();

		try {

			conn = JDBCDataSource.getConnection();

			int startIndex = (pageNo - 1) * pageSize;

			String sql = "select * from customer_data limit ?, ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, startIndex);
			pstmt.setInt(2, pageSize);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				CustomerBean customer = new CustomerBean();

				customer.setCustomerId(rs.getLong("customerId"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setEmail(rs.getString("email"));
				customer.setPhoneNo(rs.getString("phoneNo"));
				customer.setAddress(rs.getString("address"));

				list.add(customer);
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