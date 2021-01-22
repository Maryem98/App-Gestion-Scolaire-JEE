package dao;
 
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import metier.Plan;
 
public class PlanDisplayDao {
  
     
    public Plan get(int id) throws SQLException, IOException {
        Plan book = null;
         
        String sql = "SELECT * FROM FILES WHERE id=?";
         
        
        	Connection connection = null;
          
             
            try {
                // connects to the database
            	try {
    				Class.forName("com.mysql.cj.jdbc.Driver");
    			} catch (ClassNotFoundException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			//creer la cnx
    			connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionEcole?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC"
    					+ "","root","");
                
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet result = statement.executeQuery();
             
            if (result.next()) {
                book = new Plan();
                int ident=result.getInt("id");
                String comment = result.getString("comment");
                int valide = result.getInt("valide");
                Blob blob = result.getBlob("photo");
                 
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                 
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                 
                 
                inputStream.close();
                outputStream.close();
                book.setId(ident);
                book.setComment(comment);
                book.setValide(valide);
                book.setPhoto(base64Image);
            }          
             
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            throw ex;  }      
         
        return book;
    }
    
    
    public List<Plan> getPlans() throws IOException {
		List<Plan>plans=new ArrayList<Plan>();
		Connection connection = null;
        
        
        try {
            // connects to the database
        	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {e.printStackTrace();}
			//creer la cnx
			connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionEcole?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC"
					+ "","root","");               		
	
			PreparedStatement ps = connection.prepareStatement("SELECT* FROM FILES ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				    Plan  book = new Plan();
				    int id=rs.getInt("id");
	                String comment = rs.getString("comment");
	                int valide = rs.getInt("valide");
	                Blob blob = rs.getBlob("photo");
	                 
	                InputStream inputStream = blob.getBinaryStream();
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes); 
	                inputStream.close();
	                outputStream.close();
	                book.setId(id);
	                book.setComment(comment);
	                book.setValide(valide);
	                book.setPhoto(base64Image);
	                plans.add(book);
	  
			}
			} catch (SQLException e) {e.printStackTrace();}
		return plans;
	}


	public Plan modifier(Plan book) {
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		 try {
			 //preparer la requete
			PreparedStatement ps=connection.prepareStatement("UPDATE FILES SET valide=1 WHERE id=?");
			
			ps.setInt(1,book.getId());
			ps.executeUpdate();//car on a insert/delete/update on execute la requete avec executeUpdate
			ps.close();//attention il faut pas fermer la cnx s'il s'agit d'un singleton
			
		  } catch (SQLException e) {e.printStackTrace();}
		return book;
	}
}
