package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.Admin;

public class AdminDaoImpl implements IAdmin{

	@Override
	public Admin getAdmin(String username, String password) {
		Admin a=new Admin();
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from admin where username=? and password=?");
		    ps.setString(1,username); 
		    ps.setString(2,password); 

			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				a=new Admin();
				a.setUsername(rs.getString("username"));
				a.setPassword(rs.getString("password"));
			
			}
			} catch (SQLException e) {e.printStackTrace();}
		return a;  
	
	}

}
