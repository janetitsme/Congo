//Janet D'Souza - 14059185

package congo;
import java.io.Serializable;
import java.util.*;
import congo.MusicOrderDAO;
import congo.MusicOrderBean;

public class CustomerOrderBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//music orders variables
	private int orderid;
	private int customerid;
	private Date orderdate;
			
	public CustomerOrderBean() {

	}

	public CustomerOrderBean(int oid,int custid,  Date orddt) {
	orderid=oid;
	customerid = custid;
	orderdate=orddt;
	}
/*
define all getters and setters here for each instance variable
also a toString method
*/
	public int getOrderId()
	{
		return orderid;
	}
	
	public void setOrderId(int orderid)
	{
	this.orderid=orderid;	
	}
	public int getCustomerId()
	{
		return customerid;
	}
	
	public void setRecordId(int recordingid)
	{
	this.customerid=customerid;	
	}
	public Date order_date(Date orderdate)
	{
		return orderdate;
	}
	
	public void setOrderDate(Date orderDate)
	{
	this.orderdate=orderdate;	
	}
		
	@Override
	public String toString() {
		return "CustomerOrderBean [order_id=" + orderid + ",customer_id=" + customerid + ",order_date="+orderdate+"]";
		}
}
