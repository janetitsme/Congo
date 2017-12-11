//Janet D'Souza - 14059185
package congo;
import java.io.Serializable;

public class RegistrationBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String userid;
	private String fname;
	private String lname;
	private String country;
	private String postcode;
	private String adrs1;
	private String adrs2;
	private String town;
	private String county;
	private String mobile;
	private String landline;
	private String mail;
	private String pass;
	
	
	
	public RegistrationBean() {

	}

	public RegistrationBean(int custid,String uid,String fnm, String lnm, String cntry, String post,  String ad1,  String ad2, String twn,   String cnty,  String mob, String lph, String eml,  String pss) {
	id=custid;
	userid=uid;
	fname = fnm;
	lname=lnm;
	country = cntry;
	postcode=post;
	adrs1=ad1;
	adrs2=ad2;
	town = twn;	
	county=cnty;
	mobile = mob;
	landline=lph;
	mail = eml;
	pass=pss;
	
	}
/*
define all getters and setters here for each instance variable
also a toString method
*/
	public int getCustId(){
		return id;
	}
	
	public void setCustId(int id){
		this.id=id;
	}
	public String getUserId()
	{
		return userid;
	}
	
	public void setUserId(String userid)
	{
	this.userid=userid;	
	}
	
	public String getFirstName() {
		return fname;
	}

	public void setFirstName(String fname) {
		this.fname = fname;
	}

	public String getLastName() {
		return lname;
	}

	public void setLastName(String lname) {
		this.lname = lname;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getPostCode()
	{
		return postcode;
	}
	public void setPostCode(String postcode) {
		this.postcode =postcode;
	}
	
	public String getAddress1()
	{
		return adrs1;
	}	
	public void setAddress1(String adrs1) {
		this.adrs1 = adrs1;
	}
	public String getAddress2() {
		return adrs2;
	}
	public void setAddress2(String adrs2) {
		this.adrs2 = adrs2;
	}
	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}


	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLandlineNo() {
		return landline;
	}
	public void setLandlineNo(String landline) {
		this.landline = landline;
	}
	public String getMail() {
		return mail;
	}
	public void setEmail(String email) {
		this.mail = email;
	}
	public String getPassword() {
		return pass;
	}

	public void setPassword(String pass) {
		this.pass = pass;
	}
	
	
	
	@Override
	public String toString() {
		return "RegistrationBean [customer_Id=" + id + ", user_Id=" + userid + ",first_name=" + fname + ", last_Name=" + lname + ", country=" + country + ", postcode=" + postcode + ", address1=" + adrs1 + ", address2=" + adrs2  + ",town=" + town+", county="+county+", mobileNo ="+mobile  + ",landlineNo="+ landline +", email="+mail+", password=" + pass +"]";
	}
}
