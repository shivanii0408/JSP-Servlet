
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.bean.HotelBean"%>

<%@ page language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel List</title>
</head>

<body>

<%@ include file="Header.jsp"%>

<div align="center">

    <h1>Hotel List</h1>

    <form action="HotelListCtl" method="post">

        <%
        List<HotelBean> list = (List<HotelBean>) request.getAttribute("list");

        if (list != null) {
        %>

        <table border="1px" width="100%">

            <tr style="background-color: skyblue">

                <th>
                    <input type="checkbox"
                        onclick="document.querySelectorAll('input[name=ids]').forEach(c=>c.checked=this.checked)">
                </th>

                <th>Hotel Id</th>
                <th>Hotel Name</th>
                <th>Location</th>
                <th>Rating</th>
                <th>Contact no</th>

            </tr>

            <%
            Iterator<HotelBean> it = list.iterator();

            while (it.hasNext()) {

            	HotelBean bean = it.next();
            %>

            <tr align="center" style="background-color: lightgrey">

                <td>
                    <input type="checkbox"
                        name="ids"
                        value="<%=bean.getHotelId()%>">
                </td>

                <td><%=bean.getHotelId()()%></td>
                <td><%=bean.getHotelName()()%></td>
                <td><%=bean.getLocation()()%></td>
                <td><%=bean.getRating()()%></td>
                <td><%=bean.getContactNo()()%></td>

            </tr>

            <%
            }
            %>

        </table>

        <%
        }
        %>

        <table width="100%">

            <tr>

                <td>
                    <input type="submit"
                        name="operation"
                        value="previous">
                </td>

                <td align="center">
                    <input type="submit"
                        name="operation"
                        value="delete">
                </td>

                <td align="right">
                    <input type="submit"
                        name="operation"
                        value="next">
                </td>

            </tr>

        </table>

    </form>

</div>

<%@ include file="Footer.jsp"%>

</body>
</html>

