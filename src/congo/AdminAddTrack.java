//Janet D'Souza -14059185
// Add new tracks to the newly added album.
package congo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminAddTrack
 */
@WebServlet("/AdminAddTrack")
public class AdminAddTrack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddTrack() {
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
		congoBean.setRecordId(Integer.parseInt(request.getParameter("recordingId")));
		congoBean.setDuration(Integer.parseInt (request.getParameter("duration")));
		congoBean.setTitle(request.getParameter("title"));
		
		congo.addTrack(congoBean);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("AdminAddTrack.jsp");
		request.setAttribute("recordingId", congoBean.getRecordId());
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
