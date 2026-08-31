<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Vendor View</title>

</head>

<body>

	<%
	String succ = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errorMsg");
	%>

	<%@ include file="Header.jsp"%>

	<form action="VendorCtl" method="post">

		<div align="center">

			<h1 style="color: darkblue;">Add Vendor</h1>

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

					<th>Vendor ID:</th>

					<td><input type="text" name="vendorId"
						placeholder="Enter vendor ID"></td>
					<td style="color: red"><%=request.getAttribute("vendorId") != null ? request.getAttribute("vendorId") : ""%></td>
				</tr>

				<tr>

					<th>Vendor Name: <font color="red">*</font>
					</th>

					<td><input type="text" name="vendorName"
						placeholder="Enter vendor name"></td>
					<td style="color: red"><%=request.getAttribute("vendorName") != null ? request.getAttribute("vendorName") : ""%></td>
				</tr>


				<tr>

					<th>Mobile No: <font color="red">*</font>
					</th>

					<td><input type="text" name="mobileNo"
						placeholder="Enter mobile number"></td>
					<td style="color: red"><%=request.getAttribute("mobileNo") != null ? request.getAttribute("mobileNo") : ""%></td>

				</tr>

				<tr>

					<th>Address: <font color="red">*</font>
					</th>

					<td><textarea name="address" placeholder="Enter address"></textarea>
					</td>

					<td style="color: red"><%=request.getAttribute("address") != null ? request.getAttribute("address") : ""%></td>

				</tr>

				<tr>

					<th>serviceType: <font color="red">*</font>
					</th>

					<td><input type="text" name="serviceType"
						placeholder="Enter your serviceType"></td>
<td style="color: red"><%=request.getAttribute("serviceType") != null ? request.getAttribute("serviceType") : ""%></td>
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