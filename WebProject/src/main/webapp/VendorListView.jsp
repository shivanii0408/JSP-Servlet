
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.bean.VendorBean"%>

<%@ page language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Vendor List</title>
</head>

<body>

<%
    List<VendorBean> list =
        (List<VendorBean>) request.getAttribute("list");

    Iterator<VendorBean> it = list.iterator();
%>

<%@ include file="Header.jsp"%>

<div align="center">

    <h1>Vendor List</h1>

    <table border="1px" width="100%">

        <tr style="background-color: skyblue">

            <th>Vendor Id</th>
            <th>Vendor Name</th>
            <th>Mobile No</th>
            <th>Address</th>
            <th>Service Type</th>

        </tr>

        <%
        while (it.hasNext()) {

            VendorBean bean = it.next();
        %>

        <tr align="center" style="background-color: lightgrey">

            <td><%=bean.getVendorId()%></td>

            <td><%=bean.getVendorName()%></td>

            <td><%=bean.getMobileNo()%></td>

            <td><%=bean.getAddress()%></td>

            <td><%=bean.getServiceType()%></td>

        </tr>

        <%
        }
        %>

    </table>

</div>

<%@ include file="Footer.jsp"%>

</body>

</html>
```
