
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Book View</title>

</head>

<body>

	<%
	String succ = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errorMsg");
	%>

	<%@ include file="Header.jsp"%>

	<form action="BookCtl" method="post">

		<div align="center">

			<h1 style="color: darkblue;">Add Book</h1>

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

					<th>Book ID:</th>

					<td><input type="text" name="bookId"
						placeholder="Enter Book ID"></td>

					<td style="color: red"><%=request.getAttribute("bookId") != null ? request.getAttribute("bookId") : ""%></td>

				</tr>

				<tr>

					<th>Title: <font color="red">*</font>
					</th>

					<td><input type="text" name="title"
						placeholder="Enter book title"></td>

					<td style="color: red"><%=request.getAttribute("title") != null ? request.getAttribute("title") : ""%></td>

				</tr>

				<tr>

					<th>Author: <font color="red">*</font>
					</th>

					<td><input type="text" name="author"
						placeholder="Enter author name"></td>

					<td style="color: red"><%=request.getAttribute("author") != null ? request.getAttribute("author") : ""%></td>

				</tr>

				<tr>

					<th>Price: <font color="red">*</font>
					</th>

					<td><input type="text" name="price"
						placeholder="Enter book price"></td>

					<td style="color: red"><%=request.getAttribute("price") != null ? request.getAttribute("price") : ""%></td>

				</tr>

				<tr>

					<th>Publication Year: <font color="red">*</font>
					</th>

					<td><input type="text" name="publicationYear"
						placeholder="Enter publication year"></td>

					<td style="color: red"><%=request.getAttribute("publicationYear") != null ? request.getAttribute("publicationYear") : ""%></td>

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

