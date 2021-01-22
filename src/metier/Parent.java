package metier;

import java.io.Serializable;

public class Parent implements Serializable {
	private String IDP;
	private String nom;
	private String prenom;
	private String dateNaissance;
	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Parent(String iDP, String nom, String prenom, String dateNaissance) {
		super();
		IDP = iDP;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}
	public String getIDP() {
		return IDP;
	}
	public void setIDP(String iDP) {
		IDP = iDP;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	
	
}
