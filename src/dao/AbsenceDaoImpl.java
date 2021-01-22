package dao;
import metier.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AbsenceDaoImpl implements IAbsence{
	
	static Random  rand = new Random();
	     
	     public int save(AbsenceEleve a){
	    	 
	    	 Connection connection=SingletonConnetion.getConnetion();
	    	 int status=0;
	          try{
	         PreparedStatement ps=connection.prepareStatement("insert into absence values(?,?,?,?)");
	         ps.setInt(1,rand.nextInt());
	         ps.setString(2,a.getDate() );
	         ps.setString(3,a.getCNE());
	         ps.setString(4, a.getAbsent());
	       
	         status= ps.executeUpdate();
	         }catch(Exception e){System.out.println(e);}    
	         return status;
	     }

	     public List<AbsenceEleve> chercherAbs(String CNE) {
				List<AbsenceEleve>absences=new ArrayList<AbsenceEleve>();
				Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
				
				try {
					PreparedStatement ps = connection.prepareStatement("SELECT ELEVE.CNE,ABSENCE.IDABSENCEELEVE,ABSENCE.DATEABSENCEELEVE,ABSENCE.ABSENT FROM ABSENCE INNER JOIN ELEVE ON ABSENCE.CNE =ELEVE.CNE WHERE ELEVE.CNE=?  ");
					ps.setString(1,CNE);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						AbsenceEleve a=new AbsenceEleve();
						a.setCNE(rs.getString("CNE"));
						a.setIdAbsenceEleve(rs.getInt("IDABSENCEELEVE"));
						a.setDate(rs.getString("DATEABSENCEELEVE"));
						a.setAbsent(rs.getString("ABSENT"));
						absences.add(a);
					}
					} catch (SQLException e) {e.printStackTrace();}
				return absences;
			}


}
