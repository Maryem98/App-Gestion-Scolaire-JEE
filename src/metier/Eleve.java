package metier;

import java.io.Serializable;


public class Eleve implements Serializable {
	private String CNE;
	private String nom;
	private String prenom;
	private String dateNaissance;
	private String classe;
	public Eleve() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Eleve(String cNE, String nom, String prenom, String dateNaissance, String classe) {
		super();
		this.CNE = cNE;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.classe = classe;
	}
	public Eleve(String nom2, String prenom2, String dateNaissance2, String classe2) {
		// TODO Auto-generated constructor stub
	}
	public String getCNE() {
		return CNE;
	}
	public void setCNE(String cNE) {
		CNE = cNE;
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
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	@Override
	public String toString() {
		return "Eleve [CNE=" + CNE + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", classe=" + classe + "]";
	}
	
	
	
	
	

}
