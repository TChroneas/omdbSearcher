<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style><%@include file="bookmark.css"%></style>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>PROJECT</title>
</head>
<body>
<div class="mid">

    <div class="results">
        <div id="Poster">
            <img id="poster" src="https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg" alt="poster" width=150 height=222>
        </div>
        <br>
        <div id="title">
            Random Title
        </div>
        <br>
        <div id="desc">
            Random description
        </div>
        <br>
        <div id="runtime">
            Random runtime
        </div>
        <br>
        <div id="year">
            Random release year
        </div>
        <br>
        <div id="country">
            Random country

        </div>
    </div>
    <br>
    <div class="results2">
        <div id="actors">
            Random actors
        </div>
        <br>
        <div id="director">
            random director
        </div>
        <br>
        <div id="rating">
            random rating
        </div>
        <br>
        <div id="writer">
            random writer
        </div>
        <br>
        <div id="awards">
            random awards
        </div>
    </div>
    <footer>
        <a href="home.jsp">Logout</a>
    </footer>
</div>

<div class="loginN">
    <h3>Welcome </h3>
    <h3 id="email">${firstname}</h3>

     <div id="bookmarks">

         BOOKMARKS


        <c:forEach items="${titles}" var="title">
            <ul>
                <li ><input type="button"  class="bookmark" value="${title.title}"> </li>
            </ul>
        </c:forEach>-
     </div>


</div>


















<script><%@include file="jquery-3.5.1.min.js"%></script>
<script><%@include file="bookmark.js"%></script>



</body>

</html>