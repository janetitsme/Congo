<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome to Congo Corp Music Shop</title>
<meta charset="utf-8">
<LINK REL=StyleSheet HREF="styles.css" TYPE="text/css"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<div id="header">
<img class="headr" src="images/logoCongo.gif"><br>
</div>
</head>
<body>
<ul class="menu">
<li><a href="index.html">Home</a></li>
<li><a href="#">Music Search</a>
	<ul>
		<li><a href="index.html" class="album">All Albums</a></li>
		<li><a href ="artist.html" class="artist">By Artist</a></li>
		<li><a href="category.html" class="category">By Category</a></li>
		<li><a href="price.html" class="price">By Price</a></li>
	</ul>
</li>
<li><a href="shoppingPrices">Shopping</a></li>
<li><a href="#">Admin</a>
	<ul>
		<li><a href="CustomerOrders">Customer Orders</a></li>
		<li><a href="AdminStockUpdate">Update Stock</a></li>	
	</ul>
</li>	
<li><a href="#">Contact us</a></li>	
</ul>


<br> <a href="AdminStockUpdate">Back</a>

<p> There are ${stock } units. Do you want to delete all?
<form method=post action="AdminDelete">
<input type="submit" value=Delete>
<input type="hidden" name="title" value=${title }>
<input type ="hidden" name="recordingId" value=${recordingId }>
</form>
<footer><!-- Defining the footer section of the page -->
<a class="link" href="#">Congo Corp</a><br />
</footer>
</body>
</html>