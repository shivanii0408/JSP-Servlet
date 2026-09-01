package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.VendorBean;
import com.rays.util.JDBCDataSource;

public class VendorModel {

	public void add(VendorBean bean) throws SQLException {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"insert into vendor_data values(?, ?, ?, ?, ?)");

			pstmt.setInt(1, bean.getVendorId());

			pstmt.setString(2, bean.getVendorName());

			pstmt.setString(3, bean.getMobileNo());

			pstmt.setString(4, bean.getAddress());

			pstmt.setString(5, bean.getServiceType());

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

	public void update(VendorBean bean) throws SQLException {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update vendor_data set vendorName = ?, mobileNo = ?, address = ?, serviceType = ? where vendorId = ?");

			pstmt.setString(1, bean.getVendorName());

			pstmt.setString(2, bean.getMobileNo());

			pstmt.setString(3, bean.getAddress());

			pstmt.setString(4, bean.getServiceType());

			pstmt.setInt(5, bean.getVendorId());

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
					"delete from vendor_data where vendorId = ?");

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
	public List<VendorBean> search(VendorBean bean, int pageNo, int pageSize)
			throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<VendorBean> list = new ArrayList<VendorBean>();

		int start = (pageNo - 1) * pageSize;

		try {

			conn = JDBCDataSource.getConnection();

			String sql = "select * from vendor_data limit ?, ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, start);
			pstmt.setInt(2, pageSize);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				VendorBean b = new VendorBean();

				b.setVendorId(rs.getInt("vendorId"));

				b.setVendorName(rs.getString("vendorName"));

				b.setMobileNo(rs.getString("mobileNo"));

				b.setAddress(rs.getString("address"));

				b.setServiceType(rs.getString("serviceType"));

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