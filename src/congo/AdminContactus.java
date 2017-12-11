//Janet D'Souza -14059185
// Displays all the queries from the customers to the admin.
package congo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminContactus
 */
@WebServlet("/AdminContactus")
public class AdminContactus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminContactus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		ArrayList<ContactusBean> enquiries = new ArrayList<ContactusBean>();
		
		ContactusDAO Cconnect = new ContactusDAO(); 
		// Fetch all the queries from the db.
		enquiries=Cconnect.findAll();
		
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
		"<li><a href='help.html'>Help</a></li>	"+
		"</ul>");
		 
		out.println("<form class='form'><p class='submit'><a href='index.html'><input type='button' value='Go Back'></a></p></form>");
if (enquiries.isEmpty())
				{
					out.println("Sorry No Enquiries found...");
				}
				else
				{
					out.println("<table border=\"1\" class='sortable'><tr><th>SrNo</th><th>Name</th><th>Comments</th><th>Email</th>"
							+ "<th>Website</th><th>Date</th></tr>");
					int count=0;    
					for (ContactusBean c : enquiries)
					    {
						count++;
						out.println("<tr><td> "+ count + "</td>");
						out.println("<td> "+ c.getName() + "</td>");
						out.println("<td> "+c.getComments()+"</td>");
						out.println("<td>"+c.getEmail()+"</td>");
						out.println("<td>"+c.getWebAddress()+"</td>");
						out.println("<td>"+c.getDateSent()+"</td>");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
