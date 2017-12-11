//Janet D'Souza - 14059185
//display all the tracks within a album and store them in the database
package congo;

public class TrackBean {
	private int id;
	private int trackId;
	private String title;
	private int duration;


public TrackBean()
{}
public TrackBean(int mid, int recid,String ttl,int dur) {
	id=mid;
	trackId=recid;
	title = ttl;
	duration=dur;
	}
/*
define all getters and setters here for each instance variable
also a toString method
*/
	public int getMusicId(){
		return id;
	}
	
	public void setMusicId(int id){
		this.id=id;
	}
	
	public int getTrackId(){
		return trackId;
	}
	
	public void setTrackId(int trackId){
		this.trackId=trackId;
	}
  
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title=title;
	}
	
	public int getDuration(){
		return duration;
	}
	
	public void setDuration(int duration){
		this.duration=duration;
	}
  
	
	@Override
	public String toString() {
		return "TrackBean [id=" + id + ", recording_id=" + trackId + ", title='" + title+"', duration=" + duration+ "]";
	}
}

