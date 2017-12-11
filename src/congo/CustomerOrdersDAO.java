//Janet D'Souza - 14059185
package congo;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import congo.Congo_14059185DAO;
import congo.LoginDAO;

public class CustomerOrdersDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;

	public CustomerOrdersDAO() {

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

	// fetch all the customer orders.
	public ArrayList<CustomerOrdersBean> findAll() {
		ArrayList<CustomerOrdersBean> customers = new ArrayList<CustomerOrdersBean>();
		try {
			String queryString = "select title,user_id, first_name, last_name,co.order_id,order_date,email,total from customer_order co,music_orders mo, music_recordings mr, music_customer mc where mc.customer_id=co.customer_id and mo.order_id=co.order_id and mo.recording_id=mr.recording_id";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			

			while (rs1.next()) {
				CustomerOrdersBean temp= new CustomerOrdersBean();
				temp.setOrderId(rs1.getInt("order_id"));
				temp.setTitle(rs1.getString("title"));
				temp.setEmail(rs1.getString("email"));
				temp.setFirstName(rs1.getString("first_name"));
				temp.setLastName(rs1.getString("last_name"));
				temp.setTotal(rs1.getFloat("total"));
				temp.setUserName(rs1.getString("user_id"));
				temp.setDate(rs1.getDate("order_date"));
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