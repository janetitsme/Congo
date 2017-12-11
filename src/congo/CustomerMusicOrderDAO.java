//Janet D'Souza - 14059185
//store the oder in all the depended tables and the showing the orders to the Admin
package congo;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import congo.Congo_14059185DAO;
import congo.LoginDAO;

public class CustomerMusicOrderDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;

	public CustomerMusicOrderDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	// Insert new record in customer order table during user orders.
	public void createOrder(CustomerMusicOrderBean customer) {
		try {
			String queryString = "INSERT INTO customer_order(order_id, customer_id, order_date)"
					+ "VALUES(?,?,CURRENT_TIMESTAMP)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, customer.getOrderId());
			ptmt.setInt(2, customer.getCustomerId());
			//ptmt.setDate(3, (Date) customer.getDate());
			ptmt.executeUpdate();
			System.out.println("Customer Music Order created");
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
		
	}