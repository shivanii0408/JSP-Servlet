package com.rays.ctl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.rays.bean.VendorBean;
import com.rays.model.VendorModel;
import com.rays.util.ServletUtility;

@WebServlet("/VendorListCtl")
public class VendorListCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VendorModel model = new VendorModel();
		VendorBean bean = new VendorBean();

		try {
			List<VendorBean> list = model.search(bean, 1, 5);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ServletUtility.forward("VendorListView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}