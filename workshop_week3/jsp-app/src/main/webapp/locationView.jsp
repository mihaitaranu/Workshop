<%@ page import="ro.teamnet.zth.appl.domain.Location" %>
<%@ page import="java.util.List" %>
<%@ page import="ro.teamnet.zth.appl.dao.LocationDao" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: Viorelt
  Date: 06.11.2014
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Locations List</title>
</head>
<body>

<table border="1">
    <thead>
    <tr>
        <td>Id</td>
        <td>Street address</td>
        <td>Postal code</td>
        <td>City</td>
        <td>State province</td>
    </tr>
    </thead>
    <tbody>
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    %>
    <tr>
        <%
            String idString = request.getParameter("id");
            Integer id = Integer.valueOf(idString);
            LocationDao locationDao = new LocationDao();
            Location location = locationDao.getLocationById(id);
        %>
        <td><%=location.getId()%></td>
        <td><%=location.getStreetAddress()%></td>
        <td><%=location.getPostalCode()%></td>
        <td><%=location.getCity()%></td>
        <td><%=location.getStateProvince()%></td>


    </tr>

    </tbody>
</table>
<a href="locationList.jsp">Locations List</a>
</body>
</html>
