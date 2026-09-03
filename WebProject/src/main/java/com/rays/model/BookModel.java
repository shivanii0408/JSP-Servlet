package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.BookBean;
import com.rays.util.JDBCDataSource;

public class BookModel {

	public void add(BookBean bean) throws SQLException {

	    Connection conn = null;
	    PreparedStatement pstmt = null;

	    try {

	        conn = JDBCDataSource.getConnection();

	        conn.setAutoCommit(false);

	        pstmt = conn.prepareStatement(
	                "insert into book_data values(?, ?, ?, ?, ?)");

	        pstmt.setInt(1, bean.getBookId());
	        pstmt.setString(2, bean.getTitle());
	        pstmt.setString(3, bean.getAuthor());
	        pstmt.setInt(4, bean.getPrice());
	        pstmt.setInt(5, bean.getPublicationYear());

	        int i = pstmt.executeUpdate();

	        conn.commit();

	        System.out.println("Record inserted successfully: " + i);

	    } catch (Exception e) {

	        e.printStackTrace();

	        if (conn != null) {
	            conn.rollback();
	        }

	    } finally {

	        if (pstmt != null) {
	            pstmt.close();
	        }

	        if (conn != null) {
	            conn.close();
	        }
	    }
	}

	public void update(BookBean bean) throws SQLException {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update book_data set title = ?, author = ?, price = ?, publicationYear = ? where bookId = ?");

			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getAuthor());
			pstmt.setInt(3, bean.getPrice());
			pstmt.setInt(4, bean.getPublicationYear());
			pstmt.setInt(5, bean.getBookId());

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
					"delete from book_data where bookId = ?");

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

	// SEARCH METHOD
	public List<BookBean> search(BookBean bean, int pageNo, int pageSize)
			throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<BookBean> list = new ArrayList<BookBean>();

		try {

			conn = JDBCDataSource.getConnection();

			int startIndex = (pageNo - 1) * pageSize;

			String sql = "select * from book_data limit ?, ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, startIndex);
			pstmt.setInt(2, pageSize);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				BookBean book = new BookBean();

				book.setBookId(rs.getInt("bookId"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				book.setPublicationYear(rs.getInt("publicationYear"));

				list.add(book);
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