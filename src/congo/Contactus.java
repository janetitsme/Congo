//Janet D'Souza - 14059185
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
 * Servlet implementation class Register
 */
@WebServlet("/Contactus")
public class Contactus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contactus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html"); 
		ContactusBean cuBean = new ContactusBean();

		PrintWriter out = response.getWriter();
		//register.setId(request.getParameter("username"));
		cuBean.setName(request.getParameter("name"));
		cuBean.setEmail(request.getParameter("email"));
		cuBean.setWebAddress(request.getParameter("web"));
		cuBean.setComments(request.getParameter("text"));
		
		ContactusDAO Cconnect = new ContactusDAO(); 
		Cconnect.Addqueries(cuBean);
		
		try{
		//Cconnect.Addqueries(cuBean);
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
/*if (cuBean.isEmpty())
				{
					out.println("Sorry No Enquiries found...");
				}
				else
				{
					out.println("<table border=\"1\"><tr><th>SrNo</th><th>Name</th><th>Comments</th><th>Email</th></tr>");
					int count=0;    
					for (cuBean c : enquiries)
					    {
						count++;
						out.println("<tr><td> "+ count + "</td>");
						out.println("<td> "+ c.getName() + "</td>");
						out.println("<td> "+c.getComments()+"</td>");
						out.println("<td>"+c.getEmail()+"</td>");
						out.println("<td>"+c.getDateSent()+"</td>");
						out.println("</tr>");
						
					    }
					    out.println("</table>");
				}
		    out.println("<br>Press <a href=\"index.html\">here</a> to Go back");*/
		}
		catch(NumberFormatException e){}	 
	    
	}

	private String setDuration(int duration) throws IOException {
		// TODO Auto-generated method stub
		String songs_duration=null;
		try{
			if(duration != 0)
			{
				int time = duration;
				int seconds = time/1000;
				int minutes = seconds/60;
				seconds = seconds % 60;
				if(seconds<10)
				{
				songs_duration = String.valueOf(minutes) + ":0" + String.valueOf(seconds);
				}else
				{
				songs_duration = String.valueOf(minutes) + ":" + String.valueOf(seconds);
				}
			}	
		return songs_duration;
		
	} finally {
	    // ... cleanup that will execute whether or not an error occurred ...
	}
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
