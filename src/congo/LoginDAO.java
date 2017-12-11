/*Janet D'Souza - 14059185
 * DAO with the functions to access login data  */
package congo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LoginDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;

	public LoginDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	//checking if the chosen username already exists	
public boolean checkUserId(String uname){			
		try {
			String queryString = "SELECT user_id FROM login where user_id like '"+uname+"'";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			if(!rs1.first())
			{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		return true;
				}
//checking for logging in user is a admin
public boolean checkAdmin(String uname, String pwd){			
	try {
		String queryString = "SELECT user_id FROM login where user_id like '"+uname+"' and admin = true and password like '"+pwd+"'";
		connection = getConnection();
		ptmt = connection.prepareStatement(queryString);
		rs1 = ptmt.executeQuery();
		if(!rs1.first())
		{
			return false;
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs1 != null)
				rs1.close();
			if (ptmt != null)
				ptmt.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	return true;
			}

// Validates user id password combination.
public boolean checkUserPwd(String uname, String pwd){			
	try {
		String queryString = "SELECT user_id FROM login where user_id like '"+uname+"' and password like '"+pwd+"'";
		connection = getConnection();
		ptmt = connection.prepareStatement(queryString);
		rs1 = ptmt.executeQuery();
		if(!rs1.first())
		{
			return false;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs1 != null)
				rs1.close();
			if (ptmt != null)
				ptmt.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	return true;
			}
	// Adds new user to the login table
	public void add(LoginBean Loginuser) {
		try {
			String queryString = "INSERT INTO login(user_id,password,admin) VALUES(?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, Loginuser.getUserId());
			ptmt.setString(2, Loginuser.getPassword());
			ptmt.setBoolean(3, Loginuser.getAdmin());
			ptmt.executeUpdate();
			System.out.println("Login");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	// Delete user from login table.
	public void delete(String user) {

		try {
			String queryString = "DELETE FROM login WHERE userid=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1,user );
			ptmt.executeUpdate();
			System.out.println("Data deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	
		
	}