//Janet D'Souza - 14059185
package congo;
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
        // get request parameters for userID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        Cookie loginCookie = new Cookie("user",user);
        loginCookie.setMaxAge(15*60);
        Cookie userName = new Cookie("user", user);
        response.addCookie(userName);
        LoginDAO login = new LoginDAO();
        
        if(login.checkUserPwd(user, pwd))
        {
        	HttpSession session = request.getSession();
            session.setAttribute("user", user);
        	if(login.checkAdmin(user, pwd))
        	{
        		RequestDispatcher dispatcher= request.getRequestDispatcher("Admin.jsp");
	    		dispatcher.forward(request, response);
        	}
        	else
        	{
                //String encodedURL = response.encodeRedirectURL("LoginSuccess.jsp");
                //response.sendRedirect(encodedURL);
        		RequestDispatcher dispatcher= request.getRequestDispatcher("LoginSuccess.jsp");
	    		dispatcher.forward(request, response);
        	}
        }
        else
        {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out= response.getWriter();
            out.println("<h3>Either user name or password is wrong.</h3>");
            rd.include(request, response);
        }
        }
        
        /* if(userID.equals(user) && password.equals(pwd)){
        	HttpSession session = request.getSession();
            session.setAttribute("user", "admin");
            
        	Cookie loginCookie = new Cookie("user",user);
            //setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30*60);
            Cookie userName = new Cookie("user", user);
            response.addCookie(userName);
            
          //Get the encoded URL string
            //String encodedURL = response.encodeRedirectURL("LoginSuccess.jsp");
            //response.sendRedirect(encodedURL);
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }*/
 
    
 
}
 

