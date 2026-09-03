package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.HotelBean;
import com.rays.bean.ProductBean;
import com.rays.model.ProductModel;
import com.rays.util.ServletUtility;

@WebServlet("/ProductListCtl")
public class ProductListCtl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

    	ProductBean bean = new ProductBean();
    	ProductModel model = new ProductModel();

        try {

            List<ProductBean> list =
                    model.search(bean, 1, 5);

            request.setAttribute("list", list);

        } catch (Exception e) {

            e.printStackTrace();
        }

        ServletUtility.forward(
                "ProductListView.jsp",
                request,
                response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

    	ProductBean bean = new ProductBean();
    	ProductModel model = new ProductModel();

        String op =
                request.getParameter("operation");

        String[] ids =
                request.getParameterValues("ids");

        // DELETE
        if ("delete".equals(op)) {

            if (ids != null && ids.length > 0) {

                for (String id : ids) {

                    try {

                        model.delete(
                                Long.parseLong(id));

                        request.setAttribute(
                                "successMsg",
                                "Record deleted successfully");

                    } catch (Exception e) {

                        e.printStackTrace();

                        request.setAttribute(
                                "errorMsg",
                                "Record could not be deleted");
                    }
                }

            } else {

                request.setAttribute(
                        "errorMsg",
                        "Select at least one record to delete");
            }
        }

        
        // SEARCH
        if ("search".equals(op)) {

            bean.setProductName(
                    request.getParameter("productName"));

            bean.setCategory(
                    request.getParameter("category"));
        }

        try {

            List<ProductBean> list =
                    model.search(bean, 1, 5);

            request.setAttribute(
                    "list", list);

        } catch (Exception e) {

            e.printStackTrace();
        }

        ServletUtility.forward(
                "ProductListView.jsp",
                request,
                response);
    }
       
}