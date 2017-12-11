//Janet D'Souza - 14059185
//New user has to register the website to make any purchases
package congo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDAO rconnectLogin = new LoginDAO();
		response.setContentType("text/html"); 

		PrintWriter out = response.getWriter();
		try
		{
			if(!rconnectLogin.checkUserId(request.getParameter("username"))) {
				System.out.println(request.getParameter("username"));
				 
				HttpSession session=request.getSession();  
			    session.setAttribute("username",request.getParameter("username"));
				
				request.setAttribute("username",request.getParameter("username"));
				response.sendRedirect(request.getContextPath()+"/Registration2.jsp");
			}
			else {
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
			out.println("User name already exists");
			out.println("<form class='form'><p class='submit'><a href='index.html'>");
			out.println( "<input type='button' value='Go Back'></a></p></form>");
			System.out.println("Outside if");
		}
		}
		catch(Exception ex) {
			
		}
	}    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request);
		doGet(request,response);
	}

}
