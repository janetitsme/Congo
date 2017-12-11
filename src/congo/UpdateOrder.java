//Janet D'Souza - 14059185
package congo;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.http.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;



/**
 * Servlet implementation class AddToOrder
 */
@WebServlet("/UpdateOrder")
public class UpdateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrder() {
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
			 
			out.println("<form class='form'><p class='submit'><a href='index.html'><input type='button' value='Home'></a></p></form>");	// find out the artist name passed in from Music Listing
			
			String artist=request.getParameter("artist_name");
			//String quantity=request.getParameter("qty");
			//String tstock=request.getParameter("stockcount");
			
			//int qty=Integer.parseInt(quantity);
			//int stock=Integer.parseInt(tstock);
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
			
			System.out.println(congoArray);	
			// Might as well display the Music details
			// Getting the  details from the database
			
			//MusicOrderBean music= new MusicOrderBean();
			out.println(request.getParameter("artist_name"));
			//CongoBean c =  congoData.AddToOrder(artistname);
			
			//MusicOrderDAO musicOrder= new MusicOrderDAO();
			out.println(request.getParameter("name"));
			out.println(request.getParameter("address1"));
			out.println(request.getParameter("address2"));
			out.println(request.getParameter("postcode"));
			//out.println(musicOrder.findTop());
			
			Cookie[] cookieList=request.getCookies();
			String userName=null;
			if (cookieList != null) 
			{
			    for(int i=0; i<cookieList.length; i++) 
			    {
			    	if(cookieList[i].getName().equals("user")){
			    		userName = cookieList[i].getValue();
			    	}
			    }
			}
			
			Congo_14059185DAO congoData = new Congo_14059185DAO(); 
			MusicOrderDAO musicOrder= new MusicOrderDAO();
			CustomerOrderDAO customerOrder = new CustomerOrderDAO();
			CustomerMusicOrderDAO customerMusicOrder=new CustomerMusicOrderDAO();
			int orderId=musicOrder.findTop() + 1;//to increment the order id

			CustomerMusicOrderBean customerMusicOrderBean = new CustomerMusicOrderBean();
			customerMusicOrderBean.setCustomerId(customerOrder.findTop(userName));
			customerMusicOrderBean.setOrderId(orderId);
			customerMusicOrder.createOrder(customerMusicOrderBean);
			
			for (String c : congoArray){
			congoData.update(c);//called the update method from DAO to update the stock count
			CongoBean congo= congoData.AddToOrder(c);
			MusicOrderBean music= new MusicOrderBean();
			music.setAddress1(request.getParameter("address1"));
			music.setAddress2(request.getParameter("address2"));
			music.setRecordId(congo.getRecordId());
			music.setPostCode(request.getParameter("postcode"));
			music.setTotal(Float.parseFloat(request.getParameter("total")));
			music.setOrderId(orderId); 
			musicOrder.createOrder(music);
			
			
			
			
			
			}
			out.println("<p>The following album s stock has been updated</p><br>");
			session.invalidate();	
				//out.println("<p><a href=\"shoppingPrices\">Back to Shop Items</a><br> or see what you've <a href=\"ShowOrder\">ordered</a>");
			    out.println("<form action='LogoutServlet' method='post'><input type=\"submit\" value=\"Logout\" ></form>");
			
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
