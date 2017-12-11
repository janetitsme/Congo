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
 * Servlet implementation class CustomerOrders
 */
@WebServlet("/CustomerOrders")
public class CustomerOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		
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
		 
		out.println("<form class='form'><p class='submit'><a href='Admin.jsp'><input type='button' value='Go Back'></a></p></form>");
		
		ArrayList<CustomerOrdersBean> customerOrders=null;
		CustomerOrdersDAO customers=new CustomerOrdersDAO();
		customerOrders=customers.findAll();
		out.println("<table border=\"1\" class='sortable'><tr><th>SrNo</th><th>Album Title</th><th>User name</th>"
				+ "<th>First name</th><th>Last name</th>"
				+ "<th>Order id</th><th>Order Date</th>"
				+ "<th>Email</th><th>Total</th></tr>");
		int count=0;    
		for (CustomerOrdersBean t : customerOrders)
		    {
			count++;
			out.println("<tr><td> "+ count + "</td>");
			out.println("<td> "+ t.getTitle() + "</td>");
		    out.println("<td> "+ t.getUserName()+ "</td>");
			out.println("<td> "+ t.getFirstName()+ "</td>");			
			out.println("<td> "+ t.getLastName()+"</td>");
			out.println("<td> "+ t.getOrderId()+"</td>");
			out.println("<td> "+ t.getDate()+"</td>");
			out.println("<td> "+ t.getEmail()+"</td>");
			out.println("<td> "+ t.getTotal()+"</td>");
			
			out.println("</tr>");
			
		    }
		    out.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
