
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.bean.BookBean"%>

<%@ page language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
</head>

<body>

<%@ include file="Header.jsp"%>

<div align="center">

    <h1>Book List</h1>

    <form action="BookListCtl" method="post">

        <%
        List<BookBean> list = (List<BookBean>) request.getAttribute("list");

        if (list != null) {
        %>

        <table border="1px" width="100%">

            <tr style="background-color: skyblue">

                <th>
                    <input type="checkbox"
                        onclick="document.querySelectorAll('input[name=ids]').forEach(c=>c.checked=this.checked)">
                </th>

                <th>Book Id</th>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Publication Year</th>

            </tr>

            <%
            Iterator<BookBean> it = list.iterator();

            while (it.hasNext()) {

                BookBean bean = it.next();
            %>

            <tr align="center" style="background-color: lightgrey">

                <td>
                    <input type="checkbox"
                        name="ids"
                        value="<%=bean.getBookId()%>">
                </td>

                <td><%=bean.getBookId()%></td>
                <td><%=bean.getTitle()%></td>
                <td><%=bean.getAuthor()%></td>
                <td><%=bean.getPrice()%></td>
                <td><%=bean.getPublicationYear()%></td>

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

