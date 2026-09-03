<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.bean.ProductBean"%>

<%@ page language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Product List</title>

</head>

<body>

<%@ include file="Header.jsp"%>

<div align="center">

    <h1>Product List</h1>

    <form action="ProductListCtl" method="post">

        <%

        List<ProductBean> list =
                (List<ProductBean>) request.getAttribute("list");

        if (list != null) {

        %>

        <table border="1" width="100%">

            <tr style="background-color: skyblue">

                <th>

                    <input type="checkbox"
                        onclick="document.querySelectorAll('input[name=ids]').forEach(c => c.checked = this.checked)">

                </th>

                <th>Product Id</th>

                <th>Product Name</th>

                <th>Price</th>

                <th>Quantity</th>

                <th>Category</th>

            </tr>

            <%

            Iterator<ProductBean> it =
                    list.iterator();

            while (it.hasNext()) {

            	ProductBean bean =
                        it.next();

            %>

            <tr align="center"
                style="background-color: lightgrey">

                <td>

                    <input type="checkbox"
                           name="ids"
                           value="<%=bean.getProductId()%>">

                </td>

                <td>
                    <%=bean.getProductId()%>
                </td>

                <td>
                    <%=bean.getProductName()%>
                </td>

                <td>
                    <%=bean.getPrice()%>
                </td>

                <td>
                    <%=bean.getQuantity()%>
                </td>

                <td>
                    <%=bean.getCategory()%>
                </td>

            </tr>

            <%

            }

            %>

        </table>

        <%

        }

        %>

        <br>

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