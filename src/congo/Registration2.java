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
 * Servlet implementation class Registeration2
 */
@WebServlet("/Registration2")
public class Registration2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		request.setAttribute("username","test");
		HttpSession session=request.getSession(false);  
        String username=(String)session.getAttribute("username");  
        session.invalidate();
		System.out.println("Registeration2");
				response.setContentType("text/html"); 
				RegistrationBean register = new RegistrationBean();

				PrintWriter out = response.getWriter();
				register.setUserId(username);
				register.setFirstName(request.getParameter("firstname"));
				register.setLastName(request.getParameter("lastname"));
				register.setCountry(request.getParameter("country"));
				register.setPostCode(request.getParameter("zipcode"));
				register.setAddress1(request.getParameter("address1"));
				register.setAddress2(request.getParameter("address2"));
				register.setTown(request.getParameter("town"));
				register.setCounty(request.getParameter("county"));
				register.setMobile(request.getParameter("tel"));
				register.setLandlineNo(request.getParameter("ph"));  
				register.setEmail(request.getParameter("mail"));  
				register.setPassword(request.getParameter("password"));  
				
				LoginBean loginBean= new LoginBean();
				loginBean.setUserId(username);
				loginBean.setPassword(request.getParameter("password"));
				loginBean.setAdmin(false);
				
				RegistrationDAO rconnect = new RegistrationDAO(); 
				LoginDAO rconnectLogin = new LoginDAO();
				try
				{
					
					rconnectLogin.add(loginBean);
					rconnect.add(register);
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
					"<li><a href='#'>Login</a>"+
					"	<ul><li><a href='registration.html' class='app'>Register</a></li>"+
					"	<li><a href='login.html' class='website'>Sign-In</a></li>"+
					"	</ul>"+
					"</li>"+
					"<li><a href='contactus.html'>Contact Us</a></li>"+
					"<li><a href='help.html'>Help</a></li>	"+
					"</ul>");
					out.println("Registered Successfully");
				
				out.println("<form class='form'><p class='submit'><a href='index.html'>");
				out.println( "<input type='button' value='Go Back'></a></p></form>");
					
		        			
			}
				catch(NumberFormatException e)
				{}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
