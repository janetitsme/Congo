//Janet D'Souza - 14059185
//method to store comments / queries in the database and method for the admin to see the comments
package congo;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import congo.Congo_14059185DAO;
import congo.LoginDAO;

public class ContactusDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;

	public ContactusDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	
	// Insert queries from customers to contact us table.
	public void Addqueries(ContactusBean enquiry) {
		try {
			String queryString = "INSERT INTO contactus(name,email, website, comments,sentDate)"
					+ "VALUES(?,?,?,?,CURRENT_TIMESTAMP)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, enquiry.getName());
			ptmt.setString(2, enquiry.getEmail());
			ptmt.setString(3, enquiry.getWebAddress());
			ptmt.setString(4, enquiry.getComments());;			
			ptmt.executeUpdate();
			System.out.println("Enquiry posted");
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

	
	// Fetch all the queries from users.
	public ArrayList<ContactusBean> findAll() {
		ArrayList<ContactusBean> enquiries = null;
		try {
			String queryString = "SELECT * FROM contactus";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			enquiries = new ArrayList<ContactusBean>();
			while (rs1.next()) {
				ContactusBean temp= new ContactusBean();
				//temp.getId(rs1.getInt("id"));
				temp.setName(rs1.getString("name"));
				temp.setWebAddress(rs1.getString("website"));				
				temp.setEmail(rs1.getString("email"));
				temp.setComments(rs1.getString("comments"));
				temp.setDateSent(rs1.getDate("sentDate"));
				enquiries.add(temp);
								
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
		return enquiries;
	}

		
	}