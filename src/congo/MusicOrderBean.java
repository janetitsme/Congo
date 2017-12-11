package congo;
import java.io.Serializable;
import java.util.*;

public class MusicOrderBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//music orders variables
	private int id;
	private int orderid;
	private int recordingid;
	private String address1;
	private String address2;
	private String postcode;
	private float total;
	
	//customer order variables
	private Date orderdate;
		
	public MusicOrderBean() {

	}

	public MusicOrderBean(int d,int oid,int rid,  String ad1,  String ad2, String post, float tot) {
	id=d;
	orderid=oid;
	recordingid = rid;
	address1=ad1;
	address2=ad2;
	postcode=post;
	total = tot;
	}
/*
define all getters and setters here for each instance variable
also a toString method
*/
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	public int getOrderId()
	{
		return orderid;
	}
	
	public void setOrderId(int orderid)
	{
	this.orderid=orderid;	
	}
	public int getRecordId()
	{
		return recordingid;
	}
	
	public void setRecordId(int recordingid)
	{
	this.recordingid=recordingid;	
	}
	public String getAddress1()
	{
		return address1;
	}	
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPostCode()
	{
		return postcode;
	}
	public void setPostCode(String postcode) {
		this.postcode = postcode;
	}
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
		
	@Override
	public String toString() {
		return "CustomerOrderBean [Id=" + id + ", order_id=" + orderid + ",recording_id=" + recordingid + ", address1=" + address1 + ", address2=" + address2  + ", postcode=" + postcode + ",total="+ total +"]";
		}
}
