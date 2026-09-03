<%@ page language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Hotel View</title>

</head>

<body>

<%
String succ = (String) request.getAttribute("successMsg");
String err = (String) request.getAttribute("errorMsg");
%>

<%@ include file="Header.jsp"%>

<form action="HotelCtl" method="post">

    <div align="center">

        <h1 style="color: darkblue;">
            Add Hotel
        </h1>

        <%
        if (succ != null) {
        %>

        <h3 style="color: green">
            <%=succ%>
        </h3>

        <%
        }
        %>

        <%
        if (err != null) {
        %>

        <h3 style="color: red">
            <%=err%>
        </h3>

        <%
        }
        %>

        <table>

            <!-- Hotel ID -->

            <tr>

                <th>Hotel ID:</th>

                <td>
                    <input type="text"
                           name="hotelId"
                           placeholder="Enter Hotel ID">
                </td>

                <td style="color: red">
                    <%=request.getAttribute("hotelId") != null
                            ? request.getAttribute("hotelId")
                            : ""%>
                </td>

            </tr>

            <!-- Hotel Name -->

            <tr>

                <th>
                    Hotel Name
                    <font color="red">*</font>
                </th>

                <td>
                    <input type="text"
                           name="hotelName"
                           placeholder="Enter Hotel Name">
                </td>

                <td style="color: red">
                    <%=request.getAttribute("hotelName") != null
                            ? request.getAttribute("hotelName")
                            : ""%>
                </td>

            </tr>

            <!-- Location -->

            <tr>

                <th>
                    Location
                    <font color="red">*</font>
                </th>

                <td>
                    <input type="text"
                           name="location"
                           placeholder="Enter Location">
                </td>

                <td style="color: red">
                    <%=request.getAttribute("location") != null
                            ? request.getAttribute("location")
                            : ""%>
                </td>

            </tr>

            <!-- Rating -->

            <tr>

                <th>
                    Rating
                    <font color="red">*</font>
                </th>

                <td>
                    <input type="text"
                           name="rating"
                           placeholder="Enter Rating">
                </td>

                <td style="color: red">
                    <%=request.getAttribute("rating") != null
                            ? request.getAttribute("rating")
                            : ""%>
                </td>

            </tr>

            <!-- Contact Number -->

            <tr>

                <th>
                    Contact No
                    <font color="red">*</font>
                </th>

                <td>
                    <input type="text"
                           name="contactNo"
                           placeholder="Enter Contact No">
                </td>

                <td style="color: red">
                    <%=request.getAttribute("contactNo") != null
                            ? request.getAttribute("contactNo")
                            : ""%>
                </td>

            </tr>

            <!-- Submit -->

            <tr>

                <th></th>

                <td>
                    <input type="submit"
                           value="Save">
                </td>

            </tr>

        </table>

    </div>

</form>

<%@ include file="Footer.jsp"%>

</body>

</html>