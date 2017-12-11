//Janet D'Souza - 14059185
//stores the orders placed by the customer
package congo;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import congo.Congo_14059185DAO;
import congo.LoginDAO;

public class MusicOrderDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;

	public MusicOrderDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	// Inserts record into music orders when user orders items.
	public void createOrder(MusicOrderBean customer) {
		try {
			String queryString = "INSERT INTO music_orders(order_id, recording_id, address1,address2,postcode, total)"
					+ "VALUES(?,?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, customer.getOrderId());
			ptmt.setInt(2, customer.getRecordId());
			ptmt.setString(3, customer.getAddress1());
			ptmt.setString(4, customer.getAddress2());
			ptmt.setString(5, customer.getPostCode());
			ptmt.setFloat(6, customer.getTotal());
			ptmt.executeUpdate();
			System.out.println("Music Order created");
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

	public void delete(String customer) {

		try {
			String queryString = "DELETE FROM music_orders WHERE id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, customer);
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

	// Fetch all the music orders.
	public ArrayList<MusicOrderBean> findAll() {
		ArrayList<MusicOrderBean> customers = null;
		try {
			String queryString = "SELECT * FROM music_orders";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			customers = new ArrayList<MusicOrderBean>();
			while (rs1.next()) {
				MusicOrderBean temp= new MusicOrderBean();
				temp.setOrderId(rs1.getInt("orderid"));
				temp.setRecordId(rs1.getInt("recordingid"));
				temp.setAddress1(rs1.getString("address1"));
				temp.setAddress2(rs1.getString("address2"));
				temp.setPostCode(rs1.getString("postcode"));
				temp.setTotal(rs1.getFloat("total"));
				customers.add(temp);
								
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
		return customers;
	}
	
	// To fetch the previous order id.
	public int findTop() {
		int orderId=0;
		try {
			String queryString = "select MAX(order_id) as max_order_id from music_orders;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();	
			while (rs1.next())
			{
				orderId = rs1.getInt("max_order_id");
			}			
			rs1.close ();
			return orderId;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
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
		return orderId;
	}

		
	}