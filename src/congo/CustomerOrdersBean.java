package congo;
import java.io.Serializable;
import java.util.Date;


public class CustomerOrdersBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int orderId;
	private String title;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private float total;
	private Date date;
	

	public CustomerOrdersBean() {

	}

	public CustomerOrdersBean(int orderId,String title,String userName,String firstName,String lastName,String email,float total,Date date) {
		this.orderId=orderId;
		this.title = title;
		this.userName=userName;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.total=total;
		this.date=date;
	}
/*
define all getters and setters here for each instance variable
also a toString method
*/
	public int getOrderId(){
		return orderId;
	}
	
	public void setOrderId(int id){
		this.orderId=id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String uname) {
		this.userName = uname;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName=firstName;
	}
	
	public String getLastName()
	{
		return firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName=lastName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email=email;
	}
	
	public float getTotal()
	{
		return total;
	}
	
	public void setTotal(float total)
	{
		this.total=total;
	}
		
	public Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date2) {
		this.date = (Date) date2;
	}		
	
	@Override
	public String toString() {
		return "CustomerOrdersBean [order_id=" + orderId + ", title=" + title+", user_id =" + userName + ", first_name ="+firstName+",last_name="+lastName+",email="+email+",total="+total+",order_date ="+date+"]";
	}
}
