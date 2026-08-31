
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.bean.CustomerBean"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>

<body>

	<%
	List<CustomerBean> list = (List<CustomerBean>) request.getAttribute("list");

	Iterator<CustomerBean> it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>

	<div align="center">

		<h1>Customer List</h1>

		<table border="1px" width="100%">

			<tr style="background-color: skyblue">

				<th>Customer Id</th>
				<th>Customer Name</th>
				<th>email</th>
				<th>Phone No</th>
				<th>Address</th>


			</tr>

			<%
			while (it.hasNext()) {

				CustomerBean bean = it.next();
			%>

			<tr align="center" style="background-color: lightgrey">

				<td><%=bean.getCustomerId()%></td>

				<td><%=bean.getCustomerName()%></td>

				<td><%=bean.getEmail()%></td>

				<td><%=bean.getPhoneNo()%></td>

				<td><%=bean.getAddress()%></td>



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
