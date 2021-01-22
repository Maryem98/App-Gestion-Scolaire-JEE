package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Eleve;

import metier.Prof;


public class ProfDaoImpl implements IProf{

	@Override
	public Prof save(Prof prof) {
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		 try {
			 //preparer la requete
			PreparedStatement ps=connection.prepareStatement("INSERT INTO Prof (IDN,nom,prenom,dateNaissance)VALUES(?,?,?,?)");
			ps.setString(1,prof.getIDN());
			ps.setString(2,prof.getNom());
			ps.setString(3,prof.getPrenom());
			ps.setString(4,prof.getDateNaissance());
			ps.executeUpdate();//car on a insert/delete/update on execute la requete avec executeUpdate
			ps.close();//attention il faut pas fermer la cnx s'il s'agit d'un singleton
			
			
		  } catch (SQLException e1) {e1.printStackTrace();}
		return prof;
		
	}

	@Override
	public Prof getProf(String IDN, String dateNaissance) {
		Prof p=new Prof();
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from prof where IDN=? and dateNaissance=?");
		    ps.setString(1,IDN); 
		    ps.setString(2,dateNaissance); 

			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				p=new Prof();
				p.setIDN(rs.getString("IDN"));
				p.setNom(rs.getString("nom"));
				p.setPrenom(rs.getString("prenom"));
				p.setDateNaissance(rs.getString("dateNaissance"));
				
			}
			} catch (SQLException e) {e.printStackTrace();}
		return p;  
	
	}

	@Override
	public List<Prof> chercher(String mc) {
		List<Prof>profs=new ArrayList<Prof>();
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT* FROM Prof WHERE NOM LIKE ? ");
			ps.setString(1,mc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Prof e=new Prof();
				e.setIDN(rs.getString("IDN"));
				e.setNom(rs.getString("NOM"));
				e.setPrenom(rs.getString("PRENOM"));
				e.setDateNaissance(rs.getString("DATENAISSANCE"));
				
				profs.add(e);
			}
			} catch (SQLException e) {e.printStackTrace();}
		return profs;
	}

	@Override
	public Prof update(Prof ep) {
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		 try {
			 //preparer la requete
			PreparedStatement ps=connection.prepareStatement("UPDATE PROF SET nom=?,prenom=?,dateNaissance=? WHERE IDN=?");
			ps.setString(1,ep.getNom());
			ps.setString(2,ep.getPrenom());
			ps.setString(3,ep.getDateNaissance());
			ps.setString(4,ep.getIDN());
			ps.executeUpdate();//car on a insert/delete/update on execute la requete avec executeUpdate
			ps.close();//attention il faut pas fermer la cnx s'il s'agit d'un singleton
			
		  } catch (SQLException e) {e.printStackTrace();
		  }
		return ep;
	}
	

	@Override
	public void delete(String IDN) {
		
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		 try {
			 //preparer la requete
			PreparedStatement ps=connection.prepareStatement("DELETE FROM PROF WHERE IDN=?");
			ps.setString(1,IDN);
			ps.executeUpdate();//car on a insert/delete/update on execute la requete avec executeUpdate
			ps.close();//attention il faut pas fermer la cnx s'il s'agit d'un singleton
			
		  } catch (SQLException e1) {e1.printStackTrace();}
		
		
	}

	@Override
	public Prof getProf(String IDN) {
		Prof ep=new Prof();
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT* FROM Prof WHERE IDN=? ");
			ps.setString(1,IDN);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ep=new Prof();
				ep.setIDN(rs.getString("IDN"));
				ep.setNom(rs.getString("NOM"));
				ep.setPrenom(rs.getString("PRENOM"));
				ep.setDateNaissance(rs.getString("DATENAISSANCE"));
			
				
		
			}
			} catch (SQLException e) {e.printStackTrace();}
		return ep;}

	@Override
	public List<Eleve> geteleves() {
		List<Eleve>eleves=new ArrayList<Eleve>();
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT* FROM ELEVE  ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Eleve e=new Eleve();
				e.setCNE(rs.getString("CNE"));
				e.setNom(rs.getString("NOM"));
				e.setPrenom(rs.getString("PRENOM"));
				eleves.add(e);
			}
			} catch (SQLException e) {e.printStackTrace();}
		return eleves;
	}

	public List<Eleve> chercherparclas(String classe) {
		List<Eleve>eleves=new ArrayList<Eleve>();
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT* FROM ELEVE WHERE CLASSE=?");
			ps.setString(1,classe);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Eleve e=new Eleve();
				e.setCNE(rs.getString("CNE"));
				e.setNom(rs.getString("NOM"));
				e.setPrenom(rs.getString("PRENOM"));
				e.setDateNaissance(rs.getString("DATENAISSANCE"));
				e.setClasse(rs.getString("classe"));
				
				eleves.add(e);
			}
			} catch (SQLException e) {e.printStackTrace();}
		return eleves;
	}
	
}
