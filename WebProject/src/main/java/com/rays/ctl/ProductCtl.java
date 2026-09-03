package com.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.ProductBean;
import com.rays.model.ProductModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

@WebServlet("/ProductCtl")
public class ProductCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doGet() method");

		ServletUtility.forward("ProductView.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    System.out.println("this is doPost() method");

	    ProductBean bean = new ProductBean();
	    ProductModel model = new ProductModel();

	    try {

	        String productName = request.getParameter("productName");

	        Double price = Double.parseDouble(
	                request.getParameter("price"));

	        int quantity = Integer.parseInt(
	                request.getParameter("quantity"));

	        String category = request.getParameter("category");

	        bean.setProductName(productName);
	        bean.setPrice(price);
	        bean.setQuantity(quantity);
	        bean.setCategory(category);

	        model.add(bean);

	        request.setAttribute(
	                "successMsg",
	                "Product saved successfully");

	    } catch (Exception e) {

	        request.setAttribute(
	                "errorMsg",
	                "Product could not be saved");

	        e.printStackTrace();
	    }

	    ServletUtility.forward(
	            "ProductView.jsp",
	            request,
	            response);
	}
}