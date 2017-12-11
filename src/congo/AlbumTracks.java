//Janet D'Souza - 14059185
//shows the tracks of individual album based on the parent files hyperlink
package congo;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

import congo.TrackBean;
import congo.TracksDAO;
/**
 * Servlet implementation class PizzaList
 */
@WebServlet("/AlbumTracks")
public class AlbumTracks extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumTracks() {
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
		String rrid=request.getParameter("recordid");
		int rid=Integer.parseInt(rrid);
		TracksDAO tconnect = new TracksDAO(); 
		
		try{
		ArrayList<TrackBean> tracks = tconnect.findTracks(rid);
		
		
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
if (tracks.isEmpty())
				{
					out.println("Sorry No tracks found...");
				}
				else
				{
					out.println("<table border=\"1\"><tr><th>SrNo</th><th>Track Title</th><th>Track Time</th></tr>");
					int count=0;    
					for (TrackBean t : tracks)
					    {
						count++;
						out.println("<tr><td> "+ count + "</td>");
						out.println("<td> "+ t.getTitle() + "</td>");
						//setDuration(t.getDuration());
					    	//out.println("<td> "+ t.getDuration() + "</td>");
						   //	out.println("<td> "+ setDuration(t.getDuration()) + "</td>");			
						out.println("<td> "+(t.getDuration())/60 + "mins " + (t.getDuration())%60 +" sec</td>");
						out.println("</tr>");
						
					    }
					    out.println("</table>");
				}
		    out.println("<br>Press <a href=\"index.html\">here</a> to Go back");
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
