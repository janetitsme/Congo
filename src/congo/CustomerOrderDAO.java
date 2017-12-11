//Janet D'Souza - 14059185
//storing and display methods
package congo;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import congo.Congo_14059185DAO;
import congo.LoginDAO;

public class CustomerOrderDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;

	public CustomerOrderDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public void createOrder(MusicOrderBean customer) {
		try {
			String queryString = "INSERT INTO music_orders(order_id, recording_id, address1,address2,postcode, total)"
					+ "VALUES(?,?,?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(2, customer.getOrderId());
			ptmt.setInt(3, customer.getRecordId());
			ptmt.setString(4, customer.getAddress1());
			ptmt.setString(5, customer.getAddress2());
			ptmt.setString(6, customer.getPostCode());
			ptmt.setFloat(7, customer.getTotal());
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
	
	// To fetch the previous customer id.
		public int findTop(String uname ) {
			int orderId=0;
			try {
				String queryString = "select customer_id from music_customer where user_id like '"+uname+"' LIMIT 1";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				rs1 = ptmt.executeQuery();	
				while (rs1.next())
				{
					orderId = rs1.getInt("customer_id");
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