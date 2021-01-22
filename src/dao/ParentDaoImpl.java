package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import metier.Parent;
import metier.RendezVous;


public class ParentDaoImpl implements IParent{

	@Override
	public Parent save(Parent parent) {
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		 try {
			 //preparer la requete
			PreparedStatement ps=connection.prepareStatement("INSERT INTO Parent (IDP,nom,prenom,dateNaissance)VALUES(?,?,?,?)");
			ps.setString(1,parent.getIDP());
			ps.setString(2,parent.getNom());
			ps.setString(3,parent.getPrenom());
			ps.setString(4,parent.getDateNaissance());
			ps.executeUpdate();//car on a insert/delete/update on execute la requete avec executeUpdate
			ps.close();//attention il faut pas fermer la cnx s'il s'agit d'un singleton
			
			
		  } catch (SQLException e1) {e1.printStackTrace();}
		return parent;
	}

	@Override
	public Parent getParent(String IDP, String dateNaissance) {
		Parent p=new Parent();
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from parent where IDP=? and dateNaissance=?");
		    ps.setString(1,IDP); 
		    ps.setString(2,dateNaissance); 

			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				p=new Parent();
				p.setIDP(rs.getString("IDP"));
				p.setNom(rs.getString("nom"));
				p.setPrenom(rs.getString("prenom"));
				p.setDateNaissance(rs.getString("dateNaissance"));
				
			}
			} catch (SQLException e) {e.printStackTrace();}
		return p;  
	}

	@Override
	public List<Parent> chercher(String mc) {
		List<Parent>parents=new ArrayList<Parent>();
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT* FROM PARENT WHERE NOM LIKE ? ");
			ps.setString(1,mc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Parent e=new Parent();
				e.setIDP(rs.getString("IDP"));
				e.setNom(rs.getString("NOM"));
				e.setPrenom(rs.getString("PRENOM"));
				e.setDateNaissance(rs.getString("DATENAISSANCE"));
				
				parents.add(e);
			}
			} catch (SQLException e) {e.printStackTrace();}
		return parents;
	}

	@Override
	public Parent update(Parent ep) {
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		 try {
			 //preparer la requete
			PreparedStatement ps=connection.prepareStatement("UPDATE PARENT SET nom=?,prenom=?,dateNaissance=? WHERE IDP=?");
			ps.setString(1,ep.getNom());
			ps.setString(2,ep.getPrenom());
			ps.setString(3,ep.getDateNaissance());
			ps.setString(4,ep.getIDP());
			ps.executeUpdate();//car on a insert/delete/update on execute la requete avec executeUpdate
			ps.close();//attention il faut pas fermer la cnx s'il s'agit d'un singleton
			
		  } catch (SQLException e) {e.printStackTrace();
		  }
		return ep;
	}

	@Override
	public void delete(String IDP) {
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		 try {
			 //preparer la requete
			PreparedStatement ps=connection.prepareStatement("DELETE FROM PARENT WHERE IDP=?");
			ps.setString(1,IDP);
			ps.executeUpdate();//car on a insert/delete/update on execute la requete avec executeUpdate
			ps.close();//attention il faut pas fermer la cnx s'il s'agit d'un singleton
			
		  } catch (SQLException e1) {e1.printStackTrace();}
		
		
	}

	@Override
	public Parent getParent(String IDP) {
		 Parent ep=new Parent();
			Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
			
			try {
				PreparedStatement ps = connection.prepareStatement("SELECT* FROM Parent WHERE IDP=? ");
				ps.setString(1,IDP);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					ep=new Parent();
					ep.setIDP(rs.getString("IDP"));
					ep.setNom(rs.getString("NOM"));
					ep.setPrenom(rs.getString("PRENOM"));
					ep.setDateNaissance(rs.getString("DATENAISSANCE"));
				
					
			
				}
				} catch (SQLException e) {e.printStackTrace();}
			return ep;}
	public RendezVous saveRendezvous(RendezVous rendezvous) {
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		 try {
			 //preparer la requete
			PreparedStatement ps=connection.prepareStatement("INSERT INTO rendezvous (nom,message)VALUES(?,?)");
			ps.setString(1,rendezvous.getNom());
			ps.setString(2,rendezvous.getMessage());
			ps.executeUpdate();//car on a insert/delete/update on execute la requete avec executeUpdate
			ps.close();//attention il faut pas fermer la cnx s'il s'agit d'un singleton
			PreparedStatement ps2=connection.prepareStatement("SELECT MAX(ID) AS MAXID FROM EMPLOYES ");
			ResultSet rs =ps2.executeQuery();
			if(rs.next()) {
				rendezvous.setId(rs.getInt("MAXID"));//je prend la valeur de maxid (get) je la mis dans la var id (set))
			
			}
			
			
		  } catch (SQLException e1) {e1.printStackTrace();}
		return rendezvous;
	}
	public List<RendezVous> getrendezvous() {
		List<RendezVous>employes=new ArrayList<RendezVous>();
		Connection connection=SingletonConnetion.getConnetion();//ona va returner la conx apres sa creation
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT* FROM rendezvous  ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				RendezVous e=new RendezVous();
				e.setId(rs.getInt("ID"));
				e.setNom(rs.getString("NOM"));
				e.setMessage(rs.getString("MESSAGE"));
				
				employes.add(e);
			}
			} catch (SQLException e) {e.printStackTrace();}
		return employes;
	}
		   
		 
}
	

