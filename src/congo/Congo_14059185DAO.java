//Janet D'Souza - 14059185
//Has all the methods connected to the music listing, Artist, category, price and the admin related methods 
package congo;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

//import javax.servlet.http.*;
import congo.CongoBean;

public class Congo_14059185DAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;

	public Congo_14059185DAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}


	// Inserts the music into the music recordings database.
	public void add(CongoBean music) {
		try {
			
			String queryString = "INSERT INTO music_recordings(recording_id,artist_name, title, category, image_name,num_tracks,price,stock_count) VALUES(?,?,?,?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, music.getRecordId());
			ptmt.setString(2, music.getArtistName());
			ptmt.setString(3, music.getTitle());
			ptmt.setString(4, music.getCategory());
			ptmt.setString(5, music.getImagename());
			ptmt.setInt(6,  music.getNooftracks());
			ptmt.setFloat(7, music.getPrice());
			ptmt.setInt(8, music.getStockcount());
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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

	}
	
	// Inserts tracks to music tracks db.
	public void addTrack(CongoBean music) {
		try {
			
			String queryString = "INSERT INTO music_tracks(recording_id,title, duration) VALUES(?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, music.getRecordId());
			ptmt.setString(2, music.getTitle());
			ptmt.setInt(3, music.getDuration());			
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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

	}
	
		// Deletes records from music recordings table based on title.
		public void delete(String title) {

		try {
			String queryString = "DELETE FROM music_recordings WHERE title =?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, title);
			ptmt.executeUpdate();
			System.out.println(title);
			System.out.println("Album deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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

	}
		
		// Deletes records from music tracks table based on recording id.
		public void deleteTracks(int recordingId) {

			try {
				String queryString = "DELETE FROM music_tracks WHERE recording_id =?";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setInt(1, recordingId);
				ptmt.executeUpdate();
				System.out.println(recordingId);
				System.out.println("Tracks deleted Successfully");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
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

		}
	
	// Updates the stock count when user buys music based on artist name.
	public void update(String artist) {

		try {
			String queryString = "UPDATE music_recordings set stock_count=stock_count-1 WHERE artist_name like ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			ptmt.setString(1 , artist);
			ptmt.executeUpdate();
			System.out.println("Data updated Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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

	}

	
	//Add the album to the order  
	public CongoBean AddToOrder(String name ){
		/** this method will take the price p and return a list of all music recordings less than or equal to p
		 * 	
		 */
			CongoBean congo=new CongoBean();
			
			try {
				String queryString = "SELECT * FROM music_recordings where artist_name='"+name+"'";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				rs1 = ptmt.executeQuery();
				if(rs1.next())
				{
					congo.setArtistName(rs1.getString("artist_name"));
					congo.setTitle(rs1.getString("title"));
					congo.setCategory(rs1.getString("category"));
					congo.setPrice(rs1.getFloat("price"));
					congo.setRecordId(rs1.getInt("recording_id"));
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
			return congo;
			}
	
	
	
	//Display albums based on the chosen price range
	public ArrayList<CongoBean> findlowMusicPrice(float p){
	/** this method will take the price p and return a list of all music recordings less than or equal to p
	 * 	
	 */
		ArrayList<CongoBean> congos = null;
		
		try {
			String queryString = "SELECT * FROM music_recordings where price<="+p;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			congos = new ArrayList<CongoBean>();
			while (rs1.next()) {
				CongoBean temp= new CongoBean();
				temp.setArtistName(rs1.getString("artist_name"));
				temp.setTitle(rs1.getString("title"));
				temp.setCategory(rs1.getString("category"));
				temp.setImagename(rs1.getString("image_name"));
				temp.setNooftracks(rs1.getInt("num_tracks"));
				temp.setPrice(rs1.getFloat("price"));
				temp.setStockcount(rs1.getInt("stock_count"));
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
	
	
	//Display all Music listings
	public ArrayList<CongoBean> findAll() {
		ArrayList<CongoBean> congos = null;
		try {
			String queryString = "SELECT * FROM music_recordings where stock_count > 0";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			congos = new ArrayList<CongoBean>();
			while (rs1.next()) {
				CongoBean temp= new CongoBean();
				temp.setRecordId(rs1.getInt("recording_id"));
				temp.setArtistName(rs1.getString("artist_name"));
				temp.setTitle(rs1.getString("title"));
				temp.setCategory(rs1.getString("category"));
				temp.setImagename(rs1.getString("image_name"));
				temp.setNooftracks(rs1.getInt("num_tracks"));
				temp.setPrice(rs1.getFloat("price"));
				temp.setStockcount(rs1.getInt("stock_count"));
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

	//this method returns music details depends on chosen category
	public ArrayList<CongoBean> findCategory(String category){
		
		ArrayList<CongoBean> congos = null;
		
		try {
			String queryString = "SELECT * FROM music_recordings where category like '"+category+"'";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			congos = new ArrayList<CongoBean>();
			while (rs1.next()) {
				CongoBean temp= new CongoBean();
				temp.setRecordId(rs1.getInt("recording_id"));
				temp.setArtistName(rs1.getString("artist_name"));
				temp.setTitle(rs1.getString("title"));
				temp.setCategory(rs1.getString("category"));
				temp.setImagename(rs1.getString("image_name"));
				temp.setNooftracks(rs1.getInt("num_tracks"));
				temp.setPrice(rs1.getFloat("price"));
				temp.setStockcount(rs1.getInt("stock_count"));
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
	
	//Actual artist code
	
	//this method returns music details depends on chosen category
	public ArrayList<CongoBean> findArtist(String artistname){
		ArrayList<CongoBean> congos = null;
		try {
			String queryString = "select * from music_recordings where concat(ucase(substr(artist_name,1,1)),substr(artist_name,2)) like '"+artistname+"'";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			congos = new ArrayList<CongoBean>();
			while (rs1.next()) {
				CongoBean temp= new CongoBean();
				temp.setRecordId(rs1.getInt("recording_id"));
				temp.setArtistName(rs1.getString("artist_name"));
				temp.setTitle(rs1.getString("title"));
				temp.setCategory(rs1.getString("category"));
				temp.setImagename(rs1.getString("image_name"));
				temp.setNooftracks(rs1.getInt("num_tracks"));
				temp.setPrice(rs1.getFloat("price"));
				temp.setStockcount(rs1.getInt("stock_count"));
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
	
	
// Finds tracks based on recording id.
public ArrayList<TrackBean> findTracks(int id){
		
		ArrayList<TrackBean> congos = null;
		
		try {
			String queryString = "select * from music_tracks where recording_id=t."+id;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			congos = new ArrayList<TrackBean>();
			while (rs1.next()) {
				TrackBean temp= new TrackBean();
				temp.setTrackId(rs1.getInt("recording_id"));
				temp.setTitle(rs1.getString("title"));
				temp.setDuration(rs1.getInt("duration"));
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


// Return the stock count of albums based on title.
public int findTitle(String title){
	int count=0;
	try {
		String queryString = "select stock_count from music_recordings where title like '"+title+"'";
		connection = getConnection();
		ptmt = connection.prepareStatement(queryString);
		rs1 = ptmt.executeQuery();
		while (rs1.next())
		{
			count = rs1.getInt("stock_count");
		}			
		rs1.close ();
		return count;
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
	return count;
			}

public int findRecordingId(String title){
	int recroding_id=0;
	try {
		String queryString = "select recording_id from music_recordings where title like '"+title+"'";
		connection = getConnection();
		ptmt = connection.prepareStatement(queryString);
		rs1 = ptmt.executeQuery();
		while (rs1.next())
		{
			recroding_id = rs1.getInt("recording_id");
		}			
		rs1.close ();
		return recroding_id;
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
	return recroding_id;
			}

// Return the recording id for new record.
public int findTop() {
	int recordingId=0;
	try {
		String queryString = "select recording_id from music_recordings order by recording_id  DESC LIMIT 1";
		connection = getConnection();
		ptmt = connection.prepareStatement(queryString);
		rs1 = ptmt.executeQuery();	
		while (rs1.next())
		{
			recordingId = rs1.getInt("recording_id");
		}			
		rs1.close ();
		return recordingId;
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
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
	return recordingId;
}

	}