package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import metier.*;



public class EleveDaoImpl implements IEleve{

	@Override
	public Eleve save(Eleve e) {
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		 try {
			 //preparer la requete
			PreparedStatement ps=connection.prepareStatement("INSERT INTO Eleve (CNE,nom,prenom,dateNaissance,classe)VALUES(?,?,?,?,?)");
			ps.setString(1,e.getCNE());
			ps.setString(2,e.getNom());
			ps.setString(3,e.getPrenom());
			ps.setString(4,e.getDateNaissance());
			ps.setString(5,e.getClasse());
			ps.executeUpdate();//car on a insert/delete/update on execute la requete avec executeUpdate
			ps.close();//attention il faut pas fermer la cnx s'il s'agit d'un singleton
			
			
		  } catch (SQLException e1) {e1.printStackTrace();}
		return e;
	}

	@Override
	public Eleve getEleve(String CNE, String dateNaissance) {
		 Eleve a=new Eleve();
			Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
			
			try {
				PreparedStatement ps = connection.prepareStatement("select * from Eleve where CNE=? and dateNaissance=?");
			    ps.setString(1,CNE); 
			    ps.setString(2,dateNaissance); 

				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					a=new Eleve();
					a.setCNE(rs.getString("CNE"));
					a.setNom(rs.getString("nom"));
					a.setPrenom(rs.getString("prenom"));
					a.setDateNaissance(rs.getString("dateNaissance"));
					
				}
				} catch (SQLException e) {e.printStackTrace();}
			return a;  
		
	}
	public List<Eleve> chercher(String mc) {
		List<Eleve>eleves=new ArrayList<Eleve>();
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT* FROM ELEVE WHERE NOM LIKE ? ");
			ps.setString(1,mc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Eleve e=new Eleve();
				e.setCNE(rs.getString("CNE"));
				e.setNom(rs.getString("NOM"));
				e.setPrenom(rs.getString("PRENOM"));
				e.setDateNaissance(rs.getString("DATENAISSANCE"));
				e.setClasse(rs.getString("CLASSE"));
				eleves.add(e);
			}
			} catch (SQLException e) {e.printStackTrace();}
		return eleves;
	}
	public void delete(String CNE) {
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		 try {
			 //preparer la requete
			PreparedStatement ps=connection.prepareStatement("DELETE FROM Eleve WHERE CNE=?");
			ps.setString(1,CNE);
			ps.executeUpdate();//car on a insert/delete/update on execute la requete avec executeUpdate
			ps.close();//attention il faut pas fermer la cnx s'il s'agit d'un singleton
			
		  } catch (SQLException e1) {e1.printStackTrace();}
		
	}
	@Override
	public Eleve update(Eleve ep) {
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		 try {
			 //preparer la requete
			PreparedStatement ps=connection.prepareStatement("UPDATE eleve SET nom=?,prenom=?,dateNaissance=?,classe=? WHERE CNE=?");
			ps.setString(1,ep.getNom());
			ps.setString(2,ep.getPrenom());
			ps.setString(3,ep.getDateNaissance());
			ps.setString(4,ep.getClasse());
			ps.setString(5,ep.getCNE());
			ps.executeUpdate();//car on a insert/delete/update on execute la requete avec executeUpdate
			ps.close();//attention il faut pas fermer la cnx s'il s'agit d'un singleton
			
		  } catch (SQLException e) {e.printStackTrace();}
		return ep;
	}
	public Eleve getEleve(String CNE) {
	    Eleve ep=new Eleve();
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT* FROM eleve WHERE CNE=? ");
			ps.setString(1,CNE);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ep=new Eleve();
				ep.setCNE(rs.getString("CNE"));
				ep.setNom(rs.getString("NOM"));
				ep.setPrenom(rs.getString("PRENOM"));
				ep.setDateNaissance(rs.getString("DATENAISSANCE"));
				ep.setClasse(rs.getString("CLASSE"));
				
		
			}
			} catch (SQLException e) {e.printStackTrace();}
		return ep;
	   
	 
	   
   }

}
