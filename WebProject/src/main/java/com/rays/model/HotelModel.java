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

	public void add(HotelBean bean) throws SQLException {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"insert into hotel_data values(?, ?, ?, ?, ?)");

			pstmt.setLong(1, bean.getHotelId());
			pstmt.setString(2, bean.getHotelName());
			pstmt.setString(3, bean.getLocation());
			pstmt.setDouble(4, bean.getRating());
			pstmt.setString(5, bean.getContactNo());

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

	public void update(HotelBean bean) throws SQLException {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update hotel_data set HotelName = ?, Location = ?, Rating = ?, ContactNo = ? where HotelId = ?");

			pstmt.setLong(1, bean.getHotelId());
			pstmt.setString(2, bean.getHotelName());
			pstmt.setString(3, bean.getLocation());
			pstmt.setDouble(4, bean.getRating());
			pstmt.setString(5, bean.getContactNo());
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

			PreparedStatement pstmt = conn.prepareStatement(
					"delete from hotel_data where hotelId = ?");

			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record deleted successfully: " + i);

		} catch (Exception e) {

			e.printStackTrace();
			conn.rollback();

		} finally {

			conn.close();
		}
	}

	

	
}