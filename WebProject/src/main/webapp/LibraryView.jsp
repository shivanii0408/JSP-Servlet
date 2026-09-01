<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Library View</title>

</head>

<body>

	<%
	String succ = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errorMsg");
	%>

	<%@ include file="Header.jsp"%>

	<form action="LibraryCtl" method="post">

		<div align="center">

			<h1 style="color: darkblue;">Add Library</h1>

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

					<th>Library ID:</th>

					<td><input type="text" name="libraryId"
						placeholder="Enter library ID"></td>
					<td style="color: red"><%=request.getAttribute("libraryId") != null ? request.getAttribute("libraryId") : ""%></td>
				</tr>

				<tr>

					<th>Library Name: <font color="red">*</font>
					</th>

					<td><input type="text" name="libraryName"
						placeholder="Enter library name"></td>
					<td style="color: red"><%=request.getAttribute("libraryName") != null ? request.getAttribute("libraryName") : ""%></td>
				</tr>



				<th>Address: <font color="red">*</font>
				</th>

				<td><textarea name="address" placeholder="Enter address"></textarea>
				</td>

				<td style="color: red"><%=request.getAttribute("address") != null ? request.getAttribute("address") : ""%></td>

				</tr>

				<tr>

					<th>totalBooks:</th>

					<td><input type="text" name="totalBooks"
						placeholder="Enter totalBooks"></td>
					<td style="color: red"><%=request.getAttribute("totalBooks") != null ? request.getAttribute("totalBooks") : ""%></td>
				</tr>

				<tr>
				<tr>

					<th>contactNo: <font color="red">*</font>
					</th>

					<td><input type="text" name="contactNo"
						placeholder="Enter contact no"></td>
					<td style="color: red"><%=request.getAttribute("contactNo") != null ? request.getAttribute("contactNo") : ""%></td>
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