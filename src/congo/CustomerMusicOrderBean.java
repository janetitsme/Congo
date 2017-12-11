//Janet D'Souza - 14059185
package congo;
import java.io.Serializable;
import java.util.Date;


public class CustomerMusicOrderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int orderId;
	private int customerId;
	private Date date;

	public CustomerMusicOrderBean() {

	}

	public CustomerMusicOrderBean(int orderId,int customerId, Date date) {
		this.orderId=orderId;
		this.customerId = customerId;
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
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int id) {
		this.customerId = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date2) {
		this.date = (Date) date2;
	}		
	
	@Override
	public String toString() {
		return "CustomerMusicOrderBean [order_id=" + orderId + ", customer_id=" + customerId+", order_date=" + date + "]";
	}
}
