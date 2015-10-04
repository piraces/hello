<!DOCTYPE html>
<html>
<head>
<title>Welcome!</title>
</head>
<body>
<center>
<!--Writes a message with de user's data-->
<h1>Nice to meet you!</h1>
<p>Hello <%= request.getParameter("name")%>, you are <%= request.getParameter("age")%> years old and you are in <%= request.getParameter("curse")%> curse, studying <%= request.getParameter("speciality")%>.<br>
   Maybe these website were interesting for you:<br></p>
  <!--Links of pages related with the subject-->
  <ul>
  <li><p><a href="https://spring.io/"> Spring </a></p></li>
  <li><p><a href="http://getbootstrap.com/"> Bootstrap</a></p></li>
  <li><p><a href="https://travis-ci.org/"> Travis CI </a></p></li>
  <li><p><a href="https://gradle.org/"> Gradle </a></p></li>
  <li><p><a href="https://git-scm.com/"> Git </a></p></li>
  </ul>	
</body>
</html>

