<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="com.rays.bean.LibraryBean" %>

<%@ page language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Library List</title>
</head>

<body>

<%
    List<LibraryBean> list =
        (List<LibraryBean>) request.getAttribute("list");

    Iterator<LibraryBean> it = list.iterator();
%>

<%@ include file="Header.jsp" %>

<div align="center">

    <h1>Library List</h1>

    <table border="1" width="100%">

        <tr style="background-color: skyblue">

            <th>Library Id</th>
            <th>Library Name</th>
            <th>Address</th>
            <th>Total Books</th>
            <th>Contact No</th>

        </tr>

        <%
        while (it.hasNext()) {

            LibraryBean bean = it.next();
        %>

        <tr align="center" style="background-color: lightgrey">

            <td><%= bean.getLibraryId() %></td>

            <td><%= bean.getLibraryName() %></td>

            <td><%= bean.getAddress() %></td>

            <td><%= bean.getTotalBooks() %></td>

            <td><%= bean.getContactNo() %></td>

        </tr>

        <%
        }
        %>

    </table>

</div>

<%@ include file="Footer.jsp" %>

</body>
</html>