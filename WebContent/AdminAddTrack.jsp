<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Add Album</title>

<LINK REL=StyleSheet HREF="styles.css" TYPE="text/css"/>
<LINK REL=StyleSheet HREF="aboutus.css" TYPE="text/css"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<body>
<div id="header">
<img class="headr" src="images/logoCongo.gif"><br>
</div>
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
		<li><a href="#">Admin</a>
			<ul>
				<li><a href="CustomerOrders">Customer Orders</a></li>
				<li><a href="AdminStockUpdate">Update Stock</a></li>	
		</ul>
		</li>	

<li><a href="#">Help</a></li>	
</ul>
<body>
<form method="post" action=AdminAddTrack>
<input type="hidden" name=recordingId value=${recordingId }>
<fieldset>
<legend>Add New Track Details</legend>
<ol>
<li>
<label for="artistname"> Track Name</label>
<input type="text" name=title size=3>
</li>
<li>
<label for="title">Track duration</label>
<input type="text" name=duration size=3>
</li>
</ol>
</fieldset>
<input type ="submit" value= Insert>
<a href=Admin.jsp>Done</a>
</form>
</body>
</html>