<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Registration</title>

<LINK REL=StyleSheet HREF="styles.css" TYPE="text/css"/>
<LINK REL=StyleSheet HREF="aboutus.css" TYPE="text/css"/>

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
<li><a href="shoppingPrices">Shopping</a></li>	

<li><a href="#">Help</a></li>	
</ul>
<div id = "register">
<form method="GET" action="Registration2" >
<input type="hidden" name="CustomerId" id="CustomerId" readonly="readonly">
</li>
<li>
<label for="firstname">First Name *</label>
<input type="text" name="firstname" placeholder="First Name">
</li>
<li><label for="lastname">Last Name *</label>
<input type="text" name="lastname" placeholder="Last Name">
</li>
<li>
<label for="country">Country</label>
<select name="country" id="country">
<option>Africa</option>
<option>America</option>
<option>Australia</option>
<option>China</option>
<option>India</option>
<option>Indonesia</option>
<option>Japan</option>
<option selected>United Kingdom</option>
</select>
</li>
<li><label for="zipcode">Post Code *</label>
<input type="text" name="zipcode" placeholder="Post Code">
</li>
<li>
<label for="address1">Address1 *</label>
<textarea id="address1" name="address1"  required rows="" cols=""></textarea>
</li>
<li>
<label for="address2">Address 2</label>
<textarea id="address2" name="address2" ></textarea>
</li>
<li>
<label for="town">Town *</label>
<input type="text" id="town" name="town" required>
</li>
<li>
<label for="county">County</label>
<input type="text" id="county" name="county">
</li>
<li><label for="tel">Mobile </label>
<input type="tel" id="tel" name="tel">
</li>

<li><label for="ph">Land Line *</label>
<input type="tel" id="ph" name="ph">

</li>
<li>
<label for="email">Email *</label>
<input type="email" name="mail" >
</li>
<li>
<label for="password">Password *</label>
<input type="password" name="password">

</li>

</ol>
</fieldset>
<input type="submit"  value="Save">
</form>
</div>
</body>
</html>