//Janet D'Souza - 14059185
package congo;
import java.io.Serializable;

public class CongoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String title;
	private String category;
	private String imagename;
	private int nooftracks;
	private int duration;
	private float price;
	private int stockcount;
	private double dblUnitCost;
	private int iQuantity;
	private double dblTotalCost;

	public CongoBean() {

	}

	public CongoBean(int recid,String nme, String ttle, String cat, String img, int track, int mtime,float p, int stock) {
	id=recid;
	name = nme;
	title=ttle;
	category = cat;
	imagename=img;
	nooftracks=track;
	duration=mtime;
	price = p;	
	stockcount=stock;
	}
/*
define all getters and setters here for each instance variable
also a toString method
*/
	public int getRecordId(){
		return id;
	}
	
	public void setRecordId(int id){
		this.id=id;
	}
	
	public String getArtistName() {
		return name;
	}

	public void setArtistName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	
	public int getNooftracks() {
		return nooftracks;
	}

	public void setNooftracks(int nooftracks) {
		this.nooftracks = nooftracks;
	}
		
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	public int getStockcount() {
		return stockcount;
	}

	public void setStockcount(int stockcount) {
		this.stockcount = stockcount;
	}

	public double getUnitCost() {
        return dblUnitCost;
    }
	
    public void setUnitCost(double dblUnitCost) {
        this.dblUnitCost = dblUnitCost;
    }
    
    public int getQuantity() {
        return iQuantity;
    }
    
    public void setQuantity(int quantity) {
        iQuantity = quantity;
    }
    
    public double getTotalCost() {
        return dblTotalCost;
    }
    
    public void setTotalCost(double dblTotalCost) {
        this.dblTotalCost = dblTotalCost;
    }
	
	
	@Override
	public String toString() {
		return "CongoBean [artist_name=" + name + ", title=" + title+", category=" + category + ", image_name=" + 
			imagename + ", num_tracks=" + nooftracks + ", price=" + price  + ",Quantity=" + iQuantity+", Unit Cost="+dblUnitCost+", Total Cost ="+dblTotalCost  + ",stock_count="+ stockcount + "]";
	}
}
