
package com.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.BookBean;
import com.rays.model.BookModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

@WebServlet("/BookCtl")
public class BookCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doGet() method");

		ServletUtility.forward("BookView.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");

		BookBean bean = new BookBean();
		BookModel model = new BookModel();

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		int publicationYear = Integer.parseInt(request.getParameter("publicationYear"));

		try {

			bean.setBookId(bookId);
			bean.setTitle(title);
			bean.setAuthor(author);
			bean.setPrice(price);
			bean.setPublicationYear(publicationYear);

			model.add(bean);

			request.setAttribute("successMsg", "Book saved successfully");

		} catch (Exception e) {

			request.setAttribute("errorMsg", "Book already exists");

			e.printStackTrace();
		}

		ServletUtility.forward("BookView.jsp", request, response);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    System.out.println("request method == " + request.getMethod());

	    if (request.getMethod().equalsIgnoreCase("POST")) {

	        if (InputValidatorUtility.bookValidator(request) == false) {

	            ServletUtility.forward("BookView.jsp", request, response);
	            return;
	        }
	    }

	    super.service(request, response);
	}
}

