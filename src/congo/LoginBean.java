//Janet D'Souza - 14059185
package congo;
import java.io.Serializable;

public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userid;
	private String pass;
	private Boolean admin;
	
	public LoginBean() {

	}

	public LoginBean(String uid, String pss, Boolean admn ) {
	userid=uid;
	pass=pss;
	admin=admn;
	
	}
/*
define all getters and setters here for each instance variable
also a toString method
*/
	public String getUserId()
	{
		return userid;
	}
	
	public void setUserId(String userid)
	{
	this.userid=userid;	
	}
	
	public String getPassword() {
		return pass;
	}

	public void setPassword(String pass) {
		this.pass = pass;
	}
	
	public Boolean getAdmin()
	{
		return admin;
	}
	
	public void setAdmin(Boolean admin)
	{
		this.admin=admin;
	}
	
	
	
	@Override
	public String toString() {
		return "LoginBean [User_Id=" + userid + ", password=" + pass +", admin=" + admin +"]";
	}
}
