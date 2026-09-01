
package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.VendorBean;
import com.rays.model.VendorModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

@WebServlet("/VendorCtl")
public class VendorCtl extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    System.out.println("request method == " + request.getMethod());

	    if (request.getMethod().equalsIgnoreCase("POST")) {

	        if (InputValidatorUtility.vendorValidator(request) == false) {

	            ServletUtility.forward("VendorView.jsp", request, response);
	            return;
	        }
	    }

	    super.service(request, response);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doGet() method");

		ServletUtility.forward("VendorView.jsp", request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");
		
		VendorBean bean = new VendorBean();
		VendorModel model = new VendorModel();

		int vendorId = Integer.parseInt(request.getParameter("vendorId"));
		String vendorName = request.getParameter("vendorName");
		String mobileNo = request.getParameter("mobileNo");
		String address = request.getParameter("address");
		String serviceType = request.getParameter("serviceType");

//		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setVendorId(vendorId);
			bean.setVendorName(vendorName);
			bean.setMobileNo(mobileNo);
			bean.setAddress(address);
			bean.setServiceType(serviceType);
			model.add(bean);

			request.setAttribute("successMsg", "vendor saved successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "loginId already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("VendorView.jsp", request, response);

	}

}