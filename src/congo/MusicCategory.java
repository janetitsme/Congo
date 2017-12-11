/*Janet D'Souza - 14059185
  to display the album details based on the category chosen
 */
package congo;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import congo.CongoBean;
//import congo.TracksDAO;
import congo.Congo_14059185DAO;

/**
 * Servlet implementation class MusicListing
 */
@WebServlet("/MusicCategory")
public class MusicCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		String category=request.getParameter("Listcategory");
		
			Congo_14059185DAO cconnect = new Congo_14059185DAO(); 
			//TracksDAO tconnect=new TracksDAO();
		ArrayList<CongoBean> congos = cconnect.findCategory(category);
		try
		{
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
			 
			out.println("<form class='form'><p class='submit'><a href='index.html'><input type='button' value='Go Back'></a></p></form>");	
			if(congos.isEmpty())
	{
		out.println("Sorry currently we do not have any availabily. Please try again in couple of days.");	
	}
	else{
	int count=0;
	    out.println("<table border=\"1\" class='sortable'><tr><th><SrNo</th><th>Artist Name</th><th>Title</th><th>Image Name</th><th>Number of Tracks</th><th>Price</th></tr>");
		    for (CongoBean c : congos){
		    	count++;
		    out.println("<tr><td> "+ count + "</td>");
			out.println("<td> "+ c.getArtistName() + "</td>");
			out.println("<td><a href=\"AlbumTracks?recordid="+c.getRecordId() +"\">"+c.getTitle()+"</a></td>");
			String path="images/"+c.getImagename();
			out.println("<td><img src='"+path+"'/></td>");
			out.println("<td> "+ c.getNooftracks() + "</td>");
			out.println("<td> " + c.getPrice() + "</td>");
			out.println("</tr>");
			
		    }
		    out.println("</table>");
		    
	}
		    out.println("<br>Press <a href=\"index.html\">here</a> to Go back");
		}
		catch(NumberFormatException e)
		{}
	    
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
