package com.rays.util;

import javax.servlet.http.HttpServletRequest;

public class InputValidatorUtility {

	public static boolean loginValidator(HttpServletRequest request) {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		boolean pass = true;

		if (login.equals("")) {
			pass = false;
			request.setAttribute("login", "loginId is required");
		}

		if (password.equals("")) {
			pass = false;
			request.setAttribute("password", "password is required");
		} else if (password.length() < 8 || password.length() > 12) {
			pass = false;
			request.setAttribute("password", "password length should be > 8 or == 12");
		}

		return pass;

	}

	public static boolean userValidator(HttpServletRequest request) {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");

		boolean pass = true;

		if (firstName.equals("")) {
			pass = false;
			request.setAttribute("firstName", "firstname is required");
		}
		 else if (firstName.matches("[a-zA-Z]+")) {
			pass = false;
			request.setAttribute("firstName", "firstname is required");
		}
		
		if (lastName.equals("")) {
			pass = false;
			request.setAttribute("lastName", "lastName is required");
		}
		 else if (lastName.matches("[a-zA-Z]+")) {
			pass = false;
			request.setAttribute("lastName", "lastName is required");
		}
		
		if (login.equals("")) {
			pass = false;
			request.setAttribute("login", "loginId is required");
		}
		
		if (password.equals("")) {
			pass = false;
			request.setAttribute("password", "password is required");
		} else if (password.length() < 8 || password.length() > 12) {
			pass = false;
			request.setAttribute("password", "password length should be > 8 or == 12");
		}
		
		if (dob.equals("")) {
			pass = false;
			request.setAttribute("dob", "dob is required");
		}

		return pass;

	}
	
	
	public static boolean vendorValidator(HttpServletRequest request) {

	    String vendorId = request.getParameter("vendorId");
	    String vendorName = request.getParameter("vendorName");
	    String mobileNo = request.getParameter("mobileNo");
	    String address = request.getParameter("address");
	    String serviceType = request.getParameter("serviceType");

	    boolean pass = true;

	    // Vendor ID validation
	    if (vendorId == null || vendorId.trim().equals("")) {
	        pass = false;
	        request.setAttribute("vendorId", "Vendor ID is required");
	    }

	    // Vendor Name validation
	    if (vendorName == null || vendorName.trim().equals("")) {
	        pass = false;
	        request.setAttribute("vendorName", "Vendor Name is required");
	    } else if (!vendorName.matches("[a-zA-Z ]+")) {
	        pass = false;
	        request.setAttribute("vendorName", "Only alphabets are allowed");
	    }

	    // Mobile Number validation
	    if (mobileNo == null || mobileNo.trim().equals("")) {
	        pass = false;
	        request.setAttribute("mobileNo", "Mobile number is required");
	    } else if (!mobileNo.matches("[0-9]{10}")) {
	        pass = false;
	        request.setAttribute("mobileNo", "Mobile number must contain 10 digits");
	    }

	    // Address validation
	    if (address == null || address.trim().equals("")) {
	        pass = false;
	        request.setAttribute("address", "Address is required");
	    }

	    // Service Type validation
	    if (serviceType == null || serviceType.trim().equals("")) {
	        pass = false;
	        request.setAttribute("serviceType", "Service Type is required");
	    }

	    return pass;
	}

	
	
	public static boolean libraryValidator(HttpServletRequest request) {

	    String libraryId = request.getParameter("libraryId");
	    String libraryName = request.getParameter("libraryName");
	    String address = request.getParameter("address");
	    String totalBooks = request.getParameter("totalBooks");
	    String contactNo = request.getParameter("contactNo");

	    boolean pass = true;

	    
	    if (libraryId == null || libraryId.trim().equals("")) {

	        pass = false;
	        request.setAttribute("libraryId", "Library ID is required");

	    } else if (!libraryId.matches("[0-9]+")) {

	        pass = false;
	        request.setAttribute("libraryId", "Library ID must contain only digits");
	    }

	   
	    if (libraryName == null || libraryName.trim().equals("")) {

	        pass = false;
	        request.setAttribute("libraryName", "Library Name is required");

	    } else if (!libraryName.matches("[a-zA-Z ]+")) {

	        pass = false;
	        request.setAttribute("libraryName", "Only alphabets are allowed");
	    }

	    
	    if (address == null || address.trim().equals("")) {

	        pass = false;
	        request.setAttribute("address", "Address is required");
	    }

	   
	    if (totalBooks == null || totalBooks.trim().equals("")) {

	        pass = false;
	        request.setAttribute("totalBooks", "Total Books is required");

	    } else if (!totalBooks.matches("[0-9]+")) {

	        pass = false;
	        request.setAttribute("totalBooks", "Total Books must contain only digits");
	    }

	    
	    if (contactNo == null || contactNo.trim().equals("")) {

	        pass = false;
	        request.setAttribute("contactNo", "Contact Number is required");

	    } else if (!contactNo.matches("[0-9]{10}")) {

	        pass = false;
	        request.setAttribute("contactNo",
	                "Contact Number must contain 10 digits");
	    }

	    return pass;
	}
}