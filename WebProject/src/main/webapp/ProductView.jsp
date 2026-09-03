<%@ page language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Product View</title>
</head>

<body>

<%
String succ = (String) request.getAttribute("successMsg");
String err = (String) request.getAttribute("errorMsg");
%>

<%@ include file="Header.jsp"%>

<form action="ProductCtl" method="post">

<div align="center">

<h1 style="color: darkblue;">
    Add Product
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

<!-- Product Id -->
<tr>
    <th>
        Product Id
        <font color="red">*</font>
    </th>

    <td>
        <input type="text"
               name="productId"
               placeholder="Enter Product Id">
    </td>

    <td style="color: red">
        <%=request.getAttribute("productId") != null
                ? request.getAttribute("productId")
                : ""%>
    </td>
</tr>

<!-- Product Name -->
<tr>
    <th>
        Product Name
        <font color="red">*</font>
    </th>

    <td>
        <input type="text"
               name="productName"
               placeholder="Enter Product Name">
    </td>

    <td style="color: red">
        <%=request.getAttribute("productName") != null
                ? request.getAttribute("productName")
                : ""%>
    </td>
</tr>


<!-- Price -->
<tr>
    <th>
        Price
        <font color="red">*</font>
    </th>

    <td>
        <input type="text"
               name="price"
               placeholder="Enter Price">
    </td>

    <td style="color: red">
        <%=request.getAttribute("price") != null
                ? request.getAttribute("price")
                : ""%>
    </td>
</tr>


<!-- Quantity -->
<tr>
    <th>
        Quantity
        <font color="red">*</font>
    </th>

    <td>
        <input type="text"
               name="quantity"
               placeholder="Enter Quantity">
    </td>

    <td style="color: red">
        <%=request.getAttribute("quantity") != null
                ? request.getAttribute("quantity")
                : ""%>
    </td>
</tr>


<!-- Category -->
<tr>
    <th>
        Category
        <font color="red">*</font>
    </th>

    <td>
        <input type="text"
               name="category"
               placeholder="Enter Category">
    </td>

    <td style="color: red">
        <%=request.getAttribute("category") != null
                ? request.getAttribute("category")
                : ""%>
    </td>
</tr>


<!-- Submit -->
<tr>
    <th></th>

    <td>
        <input type="submit" value="Save">
    </td>
</tr>

</table>

</div>

</form>

<%@ include file="Footer.jsp"%>

</body>
</html>