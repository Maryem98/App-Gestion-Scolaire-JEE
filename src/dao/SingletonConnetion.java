package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class SingletonConnetion {
	private static Connection connection;
	//bloc static le premier boc qui s'execute en memeoire
	static {
		
			//charger le pilote jdbc
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				//creer la cnx
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionEcole?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC"
						+ "","root","");
				} catch (Exception e) {e.printStackTrace();}	
		  }
		public static Connection getConnetion() {
		return connection;
		} 

}
