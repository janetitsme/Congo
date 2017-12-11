//Janet D'Souza -14059185
//File to display price range based on chosen value from combo box
package congo;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;
/**
 * Servlet implementation class PizzaList
 */
@WebServlet("/PriceSelector")
public class PriceSelector extends HttpServlet {

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PriceSelector() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		
		//get parameter
		String mprice=request.getParameter("priceRange");
		Congo_14059185DAO cconnect = new Congo_14059185DAO(); 
		ArrayList<CongoBean> congos = cconnect.findlowMusicPrice(Float.parseFloat(mprice));
		out.println("<head><title>Welcome to Congo Corp Music Shop</title>"+
				"<meta charset='utf-8'>"+
		"<LINK REL=StyleSheet HREF='styles.css' TYPE='text/css'/>"+
		"<meta name='viewport' content='width=device-width, initial-scale=1.0'>"+
		"<div id='header'>"+
		"<img class='headr' src='images/logoCongo.gif'><br>"+

		"</div>"+
		"<script src='sorttable.js'></script>"+
		"</head>"+"<body>"+
		"<ul class='menu'>"+
		"<li><a href='index.html'>Home</a></li>"+
		"<li><a href='aboutus.html'>About Us</a></li>"+
		"<li><a href='#'>Music search</a>"+
		"	<ul>"+
		"		<li><a href='price.html' class='price'>By Price</a></li>"+
		"		<li><a href='artist.html' class='artist'>By Artist</a></li>"+
		"		<li><a href='category.html' class='category'>By Category</a></li>"+
		"	</ul>"+
		"</li>	"+
		"<li><a href='contactus.html'>Contact Us</a></li>"+
		"<li><a href='help.html'>Help</a></li>	"+
		"</ul>");
		 
		out.println("<form class='form'><p class='submit'><a href='index.html'><input type='button' value='Go Back'></a></p></form>");	if (congos.isEmpty())
				{
					out.println("Sorry choose price within the range");
				}
				else
				{
					out.println("<table border=\"1\" class='sortable'><tr><th>Name</th><th>Toppings</th><th>Price</></tr>");
					    for (CongoBean c : congos)
					    {
						//out.println("<tr><td><a href=\"PriceSelector?artistname=" + c.getArtistName() +"\">"+c.getArtistName()+"</a></td>");
						out.println("<tr><td> "+ c.getArtistName() + "<p/td>");
						out.println("<td> "+ c.getTitle() + "</td>");
						out.println("<td> "+ c.getCategory() + "</td>");
						String path="images/"+c.getImagename();
						out.println("<td><img src='"+path+"'/></td>");	
						out.println("<td> "+ c.getNooftracks() + "</td>");
						out.println("<td> " + c.getPrice() + "</td>");
						out.println("<td> "+ c.getStockcount() + "</td>");
						out.println("</tr>");
						
					    }
					    out.println("</table>");
				}
		    out.println("<br>Press <a href=\"index.html\">here</a> to Go back");
		 
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
