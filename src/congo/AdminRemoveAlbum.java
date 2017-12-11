//Janet D'Souza -14059185
// Intermediate page for deleting the albums. Checks if the stock count is more than 1 and redirects accordingly.
package congo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminRemoveAlbum
 */
@WebServlet("/AdminRemoveAlbum")
public class AdminRemoveAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRemoveAlbum() {
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
		Congo_14059185DAO deleteAlbum =new Congo_14059185DAO();
		int recordingId=deleteAlbum.findRecordingId(request.getParameter("name"));;
		if(deleteAlbum.findTitle(request.getParameter("name")) > 1)
		{
			RequestDispatcher dispatcher= request.getRequestDispatcher("AdminDeleteConfirm.jsp");
			request.setAttribute("stock", deleteAlbum.findTitle(request.getParameter("name")));
			request.setAttribute("title", request.getParameter("name"));
			request.setAttribute("recordingId", recordingId);
    		dispatcher.forward(request, response);
		   
		}
		else
		{		
			RequestDispatcher dispatcher= request.getRequestDispatcher("AdminStockUpdate");
    		dispatcher.forward(request, response);
    		deleteAlbum.delete(request.getParameter("title"));
    		deleteAlbum.deleteTracks(recordingId);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
