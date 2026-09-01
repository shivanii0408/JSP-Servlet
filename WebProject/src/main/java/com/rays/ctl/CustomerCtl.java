
package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.CustomerBean;
import com.rays.model.CustomerModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

@WebServlet("/CustomerCtl")
public class CustomerCtl extends HttpServlet {
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doGet() method");

		ServletUtility.forward("CustomerView.jsp", request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");
		
		CustomerBean bean= new CustomerBean();
		CustomerModel model=new CustomerModel();

		long customerId = Integer.parseInt(request.getParameter("customerId"));
		String customerName = request.getParameter("customerName");
		String email = request.getParameter("email");
		String phoneNo = request.getParameter("phoneNo");
		String address = request.getParameter("address");
	

//		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setCustomerId(customerId);
			bean.setCustomerName(customerName);
			bean.setEmail(email);
			bean.setPhoneNo(phoneNo);
			bean.setAddress(address);
			
			model.add(bean);

			request.setAttribute("successMsg", "Customer saved successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "loginId already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("CustomerView.jsp", request, response);

	}

}