package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.BookBean;
import com.rays.bean.UserBean;
import com.rays.model.BookModel;
import com.rays.util.ServletUtility;

@WebServlet("/BookListCtl")
public class BookListCtl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BookBean bean = new BookBean();
        BookModel model = new BookModel();

        try {

            List<BookBean > list = model.search(bean, 1, 5);

            request.setAttribute("list", list);

        } catch (Exception e) {
            e.printStackTrace();
        }

        ServletUtility.forward("BookListView.jsp", request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	 BookBean bean = new BookBean();
         BookModel model = new BookModel();

         
         String op= request.getParameter("operation");
         String[] ids= request.getParameterValues("ids");
         
         if (op.equals("delete")) {
 			if (ids != null && ids.length > 0) {

 				for (String id : ids) {
 					try {
 						model.delete(Integer.parseInt(id));
 						request.setAttribute("successMsg", "record deleted successfully");
 					} catch (Exception e) {
 						e.printStackTrace();
 					}
 				}

 			} else {
 				request.setAttribute("errorMsg", "select at least one record to delete");
 			}
 		}

 		if (op.equals("search")) {
 			bean.setTitle(request.getParameter("firstName"));
 			bean.setAuthor(request.getParameter("Author"));
 		}

 		try {
 			List<BookBean> list = model.search(bean, 1, 5);
 			request.setAttribute("list", list);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}

 		ServletUtility.forward("BookListView.jsp", request, response);

 	}
 		
    }
