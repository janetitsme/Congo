//Janet D'Souza - 14059185
package congo;
import java.io.Serializable;
import java.util.Date;

public class ContactusBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String website;
	private String email;
	private String comments;
	private Date dtsent;
		
	public ContactusBean() {

	}

	public ContactusBean(int id,String nm, String website, String eml,   String comnts, Date dt) {
	id=id;
	name=nm;
	website=website;
	email=eml;
	comments = comnts;
	dtsent=dt;
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
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getWebAddress()
	{
		return website;
	}	
	public void setWebAddress(String adrs1) {
		this.website = adrs1;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getDateSent() {
		return dtsent;
	}

	public void setDateSent(Date dtsent) {
		this.dtsent = dtsent;
	}
	
	
	@Override
	public String toString() {
		return "ContactusBean [Id=" + id + ", ,name=" + name + ", website=" + website + ", email="+email+", comments=" + comments +", datesent=" + dtsent+"]";
	}
}
