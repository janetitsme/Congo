//Janet D'Souza - 14059185
//inserting the registration details in the database and find the details
package congo;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.management.Query;


public class RegistrationDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;

	public RegistrationDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
		
public ArrayList<RegistrationBean> checkUserId(String uname){		
System.out.println("checkUserId");
		ArrayList<RegistrationBean> Registeruser = null;		
		try {
			String queryString = "SELECT userid FROM music_customer where userid like '"+uname+"'";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			Registeruser = new ArrayList<RegistrationBean>();
			while (rs1.next()) {
				RegistrationBean temp= new RegistrationBean();
				temp.setUserId(rs1.getString(uname));
				Registeruser.add(temp);								
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
		return Registeruser;
				}

	// Insert new user into music customer table.
	public void add(RegistrationBean customer) {
		try {
			String queryString = "INSERT INTO music_customer(user_id, first_name, last_name, "
					+ "country, postcode, address1,address2, town, county, mobileno, landlineno, email, password)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			//ptmt.setInt(0, customer.getCustId());
			ptmt.setString(1, customer.getUserId());
			ptmt.setString(2, customer.getFirstName());
			ptmt.setString(3, customer.getLastName());
			ptmt.setString(4, customer.getCountry());
			ptmt.setString(5, customer.getPostCode());
			ptmt.setString(6, customer.getAddress1());
			ptmt.setString(7, customer.getAddress2());
			ptmt.setString(8, customer.getTown());
			ptmt.setString(9, customer.getCounty());
			ptmt.setString(10, customer.getMobile());
			ptmt.setString(11, customer.getLandlineNo());
			ptmt.setString(12, customer.getMail());
			ptmt.setString(13, customer.getPassword());
			ptmt.executeUpdate();
			System.out.println("Registration completed1");
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
			String queryString = "DELETE FROM music_customer WHERE userid=?";
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

	// Fetch all the users from music customer table.
	public ArrayList<RegistrationBean> findAll() {
		ArrayList<RegistrationBean> customers = null;
		try {
			String queryString = "SELECT * FROM music_customer";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			customers = new ArrayList<RegistrationBean>();
			while (rs1.next()) {
				RegistrationBean temp= new RegistrationBean();
				temp.setCustId(rs1.getInt("custid"));
				temp.setUserId(rs1.getString("userid"));
				temp.setFirstName(rs1.getString("fname"));
				temp.setLastName(rs1.getString("lname"));
				temp.setCountry(rs1.getString("country"));
				temp.setPostCode(rs1.getString("postcode"));
				temp.setAddress1(rs1.getString("adrs1"));
				temp.setAddress2(rs1.getString("adrs2"));
				temp.setTown(rs1.getString("town"));
				temp.setCountry(rs1.getString("country"));
				temp.setMobile(rs1.getString("mobile"));
				temp.setLandlineNo(rs1.getString("landline"));
				temp.setEmail(rs1.getString("email"));
				temp.setPassword(rs1.getString("pass"));
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