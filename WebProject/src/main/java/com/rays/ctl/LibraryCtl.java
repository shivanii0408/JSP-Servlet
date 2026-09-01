
package com.rays.ctl;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.LibraryBean;
import com.rays.bean.VendorBean;
import com.rays.model.LibraryModel;
import com.rays.model.VendorModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

@WebServlet("/LibraryCtl")
public class LibraryCtl extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    System.out.println("request method == " + request.getMethod());

	    if (request.getMethod().equalsIgnoreCase("POST")) {

	        if (InputValidatorUtility.vendorValidator(request) == false) {

	            ServletUtility.forward("LibraryView.jsp", request, response);
	            return;
	        }
	    }

	    super.service(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doGet() method");

		ServletUtility.forward("LibraryView.jsp", request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");
		
	LibraryBean bean = new LibraryBean ();
	LibraryModel model = new LibraryModel();

		int libraryId = Integer.parseInt(request.getParameter("libraryId"));
		String libraryName = request.getParameter("libraryName");
		String address = request.getParameter("address");
		int totalBooks = Integer.parseInt(request.getParameter("totalBooks"));
		String contactNo = request.getParameter("contactNo");

//		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setLibraryId(libraryId);
			bean.setLibraryName(libraryName);
			bean.setAddress(address);
		bean.setTotalBooks(totalBooks);
		bean.setContactNo(contactNo);
			model.add(bean);

			request.setAttribute("successMsg", "Library saved successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "loginId already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("LibraryView.jsp", request, response);

	}

}