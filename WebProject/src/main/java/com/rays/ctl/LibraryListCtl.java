package com.rays.ctl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.LibraryBean;
import com.rays.model.LibraryModel;
import com.rays.util.ServletUtility;

@WebServlet("/LibraryListCtl")
public class LibraryListCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LibraryModel model = new LibraryModel();
		LibraryBean bean = new LibraryBean();

		try {
			List<LibraryBean> list = model.search(bean, 1, 5);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ServletUtility.forward("LibraryListView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
	}

}