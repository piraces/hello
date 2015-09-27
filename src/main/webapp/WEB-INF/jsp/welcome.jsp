<!DOCTYPE html>

<html lang="en">
<title>Hello world</title>
<!--Bootstrap is a HTML-CCS-JS framework for developing responsive (Remember to keep it updated) -->
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" />
<body>
<!--JQuery is a JavaScript library which makes easier to manipulate events, Ajax.. (Remember to keep it updated).
Provides to the main JSP page of the project, a simple way to make the client-side scripting of HTML, showing the time and the message generated by the server-side app.-->

	<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js" ></script>

    <!-- Shows an image as head of our page-->

	<img src="/images/Head.png" />

	<!-- Shows the time and a message (From HelloController)
	divided on two lines and one message per line, with glyphicons added
	clearing the source format.
	Check Glyphicon section on description.md for more information-->

	<span class="glyphicon glyphicon-time" ><kbd> ${time}</kbd></span><br>
	<span class="glyphicon glyphicon-user" ><kbd> ${message}</kbd></span><br>
	<!--Shows the IP addres of the client-->
	<span class="glyphicon glyphicon-info-sign" ><kbd> <%out.println("IP:" + request.getRemoteAddr()); %></kbd></span><br>
	<!--Shows the Info System of the client-->
	<span class="glyphicon glyphicon-arrow-right" ><kbd> <%out.println("System:" + request.getHeader("User-Agent"));%></kbd></span><br<br><br>
	
	<h3>Complete with your dates:</h3>
	<!-- Formulary which a user can write and send to the server. All the params are required-->
	<form action="/" method="POST">
	Name: <input type="text" name="name" required><br />
	Age: <input type="text" name="age" required><br />
	Curse: <input type="text" name="curse" required><br />
	Speciality: <input type="text" name="speciality" required><br />
	<input type="submit" value="Send" />
</form>

</html>
