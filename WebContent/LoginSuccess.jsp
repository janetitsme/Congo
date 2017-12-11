<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<LINK REL=StyleSheet HREF="styles.css" TYPE="text/css"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<div id="header">
<img class="headr" src="images/logoCongo.gif"><br>
<!--<img class="headr" src="images/notes.jpg" >-->
</div>
</head>
<ul class="menu">
<li><a href="index.html">Home</a></li>
<li><a href="aboutus.html">About Us</a></li>
<li><a href="#">Music Search</a>
	<ul>
		<li><a href="index.html" class="album">All Albums</a></li>
		<li><a href ="artist.html" class="artist">By Artist</a></li>
		<li><a href="category.html" class="category">By Category</a></li>
		<li><a href="price.html" class="price">By Price</a></li>
	</ul>
</li>
<li><a href="shoppingPrices">Shopping</a></li>	

<li><a href="#">Help</a></li>	
</ul>
<title>Login Success Page</title>
</head>
<body>
<%
//allow access only if session exists
String user = null;
if(session.getAttribute("user") == null){
    //response.sendRedirect("login.html");
}else user = (String) session.getAttribute("user");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("user")) userName = cookie.getValue();
    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}else{
    sessionID = session.getId();
}
%>
<h4>Hi <%=userName %>, Login successful.

<br>
<!-- need to encode all the URLs where we want session information to be passed -->

<form action="<%=response.encodeURL("LogoutServlet") %>" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>