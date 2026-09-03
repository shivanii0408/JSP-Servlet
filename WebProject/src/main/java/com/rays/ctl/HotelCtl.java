package com.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.HotelBean;
import com.rays.model.HotelModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

@WebServlet("/HotelCtl")
public class HotelCtl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("this is doGet() method");

        ServletUtility.forward("HotelView.jsp", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("this is doPost() method");

        HotelBean bean = new HotelBean();
        HotelModel model = new HotelModel();

        try {

            Long hotelId =
                    Long.parseLong(request.getParameter("hotelId"));

            String hotelName =
                    request.getParameter("hotelName");

            String location =
                    request.getParameter("location");

            Double rating =
                    Double.parseDouble(request.getParameter("rating"));

            String contactNo =
                    request.getParameter("contactNo");

            bean.setHotelId(hotelId);
            bean.setHotelName(hotelName);
            bean.setLocation(location);
            bean.setRating(rating);
            bean.setContactNo(contactNo);

            model.add(bean);

            request.setAttribute("successMsg",
                    "Hotel saved successfully");

        } catch (Exception e) {

            request.setAttribute("errorMsg",
                    "Hotel could not be saved");

            e.printStackTrace();
        }

        ServletUtility.forward("HotelView.jsp",
                request, response);
    }

    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(
                "request method == " + request.getMethod());

        if (request.getMethod().equalsIgnoreCase("POST")) {

            if (InputValidatorUtility.HotelValidator(request) == false) {

                ServletUtility.forward(
                        "HotelView.jsp",
                        request,
                        response);

                return;
            }
        }

        super.service(request, response);
    }
}