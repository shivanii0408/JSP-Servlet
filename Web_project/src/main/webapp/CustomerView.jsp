<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Customer View</title>

</head>

<body>

	<%
	String succ = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errorMsg");
	%>

	<%@ include file="Header.jsp"%>

	<form action="CustomerCtl" method="post">

		<div align="center">

			<h1 style="color: darkblue;">Add Customer</h1>

			<%
			if (succ != null) {
			%>

			<h3 style="color: green"><%=succ%></h3>

			<%
			}
			%>

			<%
			if (err != null) {
			%>

			<h3 style="color: red"><%=err%></h3>

			<%
			}
			%>

			<table>

				<tr>

					<th>Customer ID:</th>

					<td><input type="text" name="customerId"
						placeholder="Enter Customer ID"></td>
					<td style="color: red"><%=request.getAttribute("customerId") != null ? request.getAttribute("customerrId") : ""%></td>
				</tr>

				<tr>

					<th>Vendor Name: <font color="red">*</font>
					</th>

					<td><input type="text" name="customerName"
						placeholder="Enter customer name"></td>
					<td style="color: red"><%=request.getAttribute("customerName") != null ? request.getAttribute("customerName") : ""%></td>
				</tr>


				<tr>

					<th>Email: <font color="red">*</font>
					</th>

					<td><input type="email" name="email"
						placeholder="Enter your email"></td>
					<td style="color: red"><%=request.getAttribute("email") != null ? request.getAttribute("email") : ""%></td>
				</tr>


				<tr>

					<th>Pgone No: <font color="red">*</font>
					</th>

					<td><input type="text" name="phoneNo"
						placeholder="Enter Phone number"></td>
					<td style="color: red"><%=request.getAttribute("phoneNo") != null ? request.getAttribute("phoneNo") : ""%></td>

				</tr>

				<tr>

					<th>Address: <font color="red">*</font>
					</th>

					<td><textarea name="address" placeholder="Enter address"></textarea>
					</td>

					<td style="color: red"><%=request.getAttribute("address") != null ? request.getAttribute("address") : ""%></td>

				</tr>



				<tr>

					<th></th>

					<td><input type="submit" value="Save"></td>

				</tr>

			</table>

		</div>

	</form>

	<%@ include file="Footer.jsp"%>

</body>

</html>