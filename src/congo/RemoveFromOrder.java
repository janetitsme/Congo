//Janet D'Souza - 14059185
//remove the albums from the cart if you do not require
package congo;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.http.*;

import java.util.*;
import java.sql.*;


/**
 * Servlet implementation class AddToOrder
 */
@WebServlet("/RemoveFromOrder")
public class RemoveFromOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html"); 
			PrintWriter out = response.getWriter();
			out.println("<head><title>Welcome to Congo Corp Music Shop</title>"+
					"<meta charset='utf-8'>"+
			"<LINK REL=StyleSheet HREF='styles.css' TYPE='text/css'/>"+
			"<meta name='viewport' content='width=device-width, initial-scale=1.0'>"+
			"<div id='header'>"+
			"<img class='headr' src='images/logoCongo.gif'><br>"+

			"</div>"+
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
			 
			out.println("<form class='form'><p class='submit'><a href='index.html'><input type='button' value='Go Back'></a></p></form>");
			// find out the artist name passed in from Music Listing
			String artistname=request.getParameter("name");
			//get a session associated with the request
			HttpSession session = request.getSession() ;
			
			
			ArrayList<String> congoArray;  // congoArray is list of the music tracks on our order
			
			//Check to see if this is a new order
			if ( session.isNew() ){
			    // new order(session) so create a new ArrayList
			    congoArray = new ArrayList<String>(); 
			    session.setAttribute("myorder",congoArray); //add array to session 	
			}
			else
			{
				//already ordered something, get current order
			   congoArray = (ArrayList<String>)session.getAttribute("myorder");
			}
			
			// add our music track to the order
			congoArray.remove(artistname); 
			
			// Might as well display the Music details
			// Getting the  details from the database
			
			Congo_14059185DAO congoData = new Congo_14059185DAO(); 
			CongoBean c = congoData.AddToOrder(artistname);	//called the AddToOrder method from DAO
			
			  	out.println("<p>The following album is removed from your order</p><br>");
				out.println(c.getArtistName()+"<br>");	
				out.println(c.getTitle()+"<br>");	
				out.println(c.getCategory()+"<br>");	
				out.println(c.getPrice()+"<br>");	
				out.println("<p><a href=\"shoppingPrices\">Back to Shop Items</a><br> or see what you've <a href=\"ShowOrder\">ordered</a>");
			    out.println("<br>Press <a href=\"index.html\">here</a> to Go back");
			
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
