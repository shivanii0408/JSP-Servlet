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
	
	public static boolean bookValidator(HttpServletRequest request) {

	    String bookId = request.getParameter("bookId");

	    String title = request.getParameter("title");

	    String author = request.getParameter("author");

	    String price = request.getParameter("price");

	    String publicationyear = request.getParameter("publicationyear");

	    boolean pass = true;


	   
	    if (bookId == null || bookId.trim().equals("")) {

	        pass = false;
	        request.setAttribute("bookId", "Book ID is required");

	    } else if (!bookId.matches("[0-9]+")) {

	        pass = false;
	        request.setAttribute("bookId", "Book ID must contain only numbers");
	    }


	    if (title == null || title.trim().equals("")) {

	        pass = false;
	        request.setAttribute("title", "Title is required");

	    } else if (!title.matches("[a-zA-Z ]+")) {

	        pass = false;
	        request.setAttribute("title", "Title must contain only alphabets");

	    } else if (title.length() > 45) {

	        pass = false;
	        request.setAttribute("title", "Title must not exceed 45 characters");
	    }


	    
	    if (author == null || author.trim().equals("")) {

	        pass = false;
	        request.setAttribute("author", "Author is required");

	    } else if (!author.matches("[a-zA-Z ]+")) {

	        pass = false;
	        request.setAttribute("author", "Author must contain only alphabets");

	    } else if (author.length() > 45) {

	        pass = false;
	        request.setAttribute("author", "Author must not exceed 45 characters");
	    }


	   
	    if (price == null || price.trim().equals("")) {

	        pass = false;
	        request.setAttribute("price", "Price is required");

	    } else if (!price.matches("[0-9]+(\\.[0-9]+)?")) {

	        pass = false;
	        request.setAttribute("price", "Price must be a valid number");
	    }


	 
	    if (publicationyear == null || publicationyear.trim().equals("")) {

	        pass = false;
	        request.setAttribute("publicationyear", "Publication year is required");

	    } else if (!publicationyear.matches("[0-9]{4}")) {

	        pass = false;
	        request.setAttribute("publicationyear", "Publication year must contain 4 digits");
	    }


	    return pass;
	}
}