package metier;

import java.io.Serializable;

public class Prof implements Serializable {
	private String IDN;
	private String nom;
	private String prenom;
	private String dateNaissance;
	public Prof() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Prof(String iDN, String nom, String prenom, String dateNaissance) {
		super();
		IDN = iDN;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}
	public String getIDN() {
		return IDN;
	}
	public void setIDN(String iDN) {
		IDN = iDN;
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
