//Janet D'Souza - 14059185
//display the entire order after adding to the cart
package congo;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.ArrayList;
import java.sql.*;

/**
 * Servlet implementation class ShowOrder
 */
@WebServlet("/ShowOrder")
public class ShowOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String docType =
			    "<!DOCTYPE HTML\">\n";
			response.setContentType("text/html"); 
			
			PrintWriter out = response.getWriter();
			
			Congo_14059185DAO congoData = new Congo_14059185DAO(); 
			// going to check the Session for albums, need to 'get' it
			
			HttpSession session = request.getSession();
		
			ArrayList<String> congoArray;  // congoArray is an array of the album names in our order
			
			//Check to see if we got here without choosing a album, if we did session is 'new'
			
			if ( session.isNew() ){
				// create a list to hold order
			    congoArray = new ArrayList<String>();
			    //put empty list in session to hold choices under attribute name 'myorder'
			    session.setAttribute("myorder",congoArray);
			    return;
			}else{
				//get the current list of albums ordered
			    congoArray = (ArrayList<String>)session.getAttribute("myorder");
			}

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
			 
			out.println("<form class='form'><p align=center class='submit'><a href='index.html'><input type='button' value='Go Back'></a></p></form>");
			out.println(docType);
			out.println("<Center><H1>Current Order</Center>");
		    // print out table header
			
			out.println("<table class='sortable' align=center border=\"1\" cellspacing=\"5\" cellpadding=\"5\">" +
			    "<tr><th>Artist Name</th><th>Title</th><th>Category</th><th>quantity</th><th>Price</th><th></th></tr>");
			float total=0.0f;			
			for ( int i = 0; i < congoArray.size(); i++){
		//build up select statement from all albums currently ordered and stored in congoArray
				String artistname = (String)congoArray.get(i);
				
				CongoBean c =  congoData.AddToOrder(artistname);
				
				out.print("<tr>");
			    out.print("<td>" + c.getArtistName() + "</td>");
			    out.print("<td>" + c.getTitle()+ "</td>");
			    out.print("<td>"+c.getCategory()+"</td>");
			    out.print("<td><input type=text size='2' name='qty' value=1>");
			    out.print("<td>" + c.getPrice() + "</td>");
			    total=total+c.getPrice();
			    out.print("<td><form action=\"RemoveFromOrder\" method=\"get\">" +
			    		"<input type=\"hidden\" name=\"name\" value=\"" + c.getArtistName() + "\">" +
					      "<input type=\"submit\" value=\"Remove\" >" + "</form>");
			}
			out.println("</tr>");
			out.print("<tfoot><tr><td align=right colspan=5><strong>Total: " + total + "</strong></td>"
					+ "<td><form action=\"CheckOut\"\"get\"><input type='submit' value='Proceed to Checkout'></td></tr></tfoot>"); 

				//print out table rows one for each row returned in rs1		    
				    
				//Close table
			
			    out.println("</table>");		    
				out.println("<p align=right><a href=\"shoppingPrices\">Back to Shop Items</a><br> or see what you've <a href=\"ShowOrder\">ordered</a>");
				out.println("</body></html>");

	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

}
