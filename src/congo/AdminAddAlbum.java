//Janet D'Souza -14059185
// Adds new album to the database
package congo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminAddAlbum
 */
@WebServlet("/AdminAddAlbum")
public class AdminAddAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddAlbum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Congo_14059185DAO congo = new Congo_14059185DAO();
		CongoBean congoBean = new CongoBean();
		int recordingId=congo.findTop()+1;
		congoBean.setArtistName(request.getParameter("artistName"));
		congoBean.setCategory(request.getParameter("category"));
		congoBean.setNooftracks(Integer.parseInt(request.getParameter("noOfTracks")));
		congoBean.setPrice(Float.parseFloat(request.getParameter("Price")));
		congoBean.setStockcount(Integer.parseInt(request.getParameter("stkCount")));
		congoBean.setRecordId(recordingId);
		congoBean.setTitle(request.getParameter("title"));
		congoBean.setImagename(request.getParameter("albumCover"));
		// call the DAO to add the new album.
		congo.add(congoBean);
		RequestDispatcher dispatcher= request.getRequestDispatcher("AdminAddTrack.jsp");
		request.setAttribute("recordingId", recordingId);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
