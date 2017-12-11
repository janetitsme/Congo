//Janet D'Souza - 14059185
package congo;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.*;
import congo.CongoBean;

public class TracksDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;

	public TracksDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public void setDuration(int song_duration) {
		String songs_duration;
		try{
		if(song_duration != 0)
		{
			int time = song_duration;
			int seconds = time/1000;
			int minutes = seconds/60;
			seconds = seconds % 60;
			if(seconds<10){
			songs_duration = String.valueOf(minutes) + ":0" + String.valueOf(seconds);
			}else{
			songs_duration = String.valueOf(minutes) + ":" + String.valueOf(seconds);
			}
		}}
		catch(NumberFormatException e){}
	}
		
// Fetch all tracks from music tracks table based on recording id.
public ArrayList<TrackBean> findTracks(int id){
		
		ArrayList<TrackBean> congos = null;
		
		try {
			String queryString = "select * from music_tracks where recording_id="+id;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			congos = new ArrayList<TrackBean>();
			while (rs1.next()) {
				TrackBean temp= new TrackBean();
				temp.setTrackId(rs1.getInt("recording_id"));
				temp.setTitle(rs1.getString("title"));
				temp.setDuration(rs1.getInt("duration"));
				//temp.setDuration((rs1.getInt("duration"))/60+" mins "+(rs1.getInt("duration"))%60 + " seconds</td>");
				congos.add(temp);
								
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
		return congos;
				}



	}