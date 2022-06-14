<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : Apr 20, 2022, 5:25:12 PM
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <!-- 2. Add and edit the index.jsp file.

When the application is started at a browser, the index.jsp page is 
        displayed as Fig. 1. Print your name and student ID on top of the page.
        There are three buttons in three forms, for adding new trip, displaying
        all trips, and searching for trips by trip ID range.

 

For adding a new trip, show a form to allow the user to enter the Trip ID
        and the Description, and select one Country from the drop-down list.
        The page provides a button "Add To Log". When ready the user can click 
        the button which should invoke a servlet. -->

        <form action="add" method="POST">

            <p>Kevin Harianto</p>
            <p>991602128</p>
            <p>Trip ID: <input type="text" name="tripid" value="" /></p>
            <p>Description: <input type="text" name="desc" value="" /></p>

            ${errorMsg}


            ${addmsg}
            ${listmsg}<br>
            <c:if test="${not empty list}">

                <c:forEach var="list" items="${list}">
                    ${list.tripid}
                    ${list.country}
                    ${list.description}<br>
                </c:forEach>

            </c:if>

            <c:if test="${not empty country}">
                <select name="country">
                    <c:forEach var="country" items="${country}">

                        <option>${country}</option>
                    </c:forEach>
                </select>

            </c:if>
            <input type="submit" value="add to log" />
        </form>

        <form action="display">

            <input type="submit" value="Display All Trips" />
        </form>

        <form action="search">
            <p>Min Trip ID <input type="text" name="minID" value="" /></p>
            <p>Max Trip ID <input type="text" name="maxID" value="" /></p>
            <input type="submit" value="search all trips" />
        </form>
    </body>

</html>
