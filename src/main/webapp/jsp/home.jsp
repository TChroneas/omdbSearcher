<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <style><%@include file="web.css"%></style>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>PROJECT</title>
</head>
<body>
    <div class="mid">
  <div class="intro">
  <h3>Type a movie name</h3>
  </div>
  <div class=bar>
    <input type="text" id="Searchbox"/>
    </div>
    <div class="button">
        <button type="button" disabled id="btn">See more!</button>
    </div>

    <div class="results">
       <div id="Poster">
         <img id="poster" src="https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg" alt="poster" width=150 height=222>
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
</div>

<div class="loginN">
<form id="loginForm" modelAttribute="login" action="loginProcess" method="post">
 <ul>
            <li><label for="email">Email</label>
            <input type="email" name="email" placeholder="yourname@email.com" required></li>
            <li><label for="password">Password</label>
            <input type="password" name="password" placeholder="password" required></li>
            <li>
            <input type="submit" value="Login"></li>
        </ul>
    <p>${message}</p>





</form>


</div>

<div class="registerR">
<form id="regForm" modelAttribute="user" action="registerProcess" method="post">
 <ul>
            <li><label for="email">Email</label>
            <input type="email" name="email" placeholder="yourname@email.com" required></li>
            <li><label for="password">Password</label>
            <input type="password" name="password" placeholder="password" required></li>
            <li>
            <input type="submit" value=Register></li>
        </ul>
        </form>
    <p>${userExists}</p>
</div>
















<script><%@include file="jquery-3.5.1.min.js"%></script>
  <script><%@include file="web.js"%></script>



</body>
</html>