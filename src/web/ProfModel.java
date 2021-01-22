package web;

import java.util.ArrayList;
import java.util.List;

import metier.Eleve;
import metier.Prof;

public class ProfModel {
	private String motCle;
	private List<Prof>profs=new ArrayList<Prof>();
	private String classe;
	private List<Eleve>eleves=new ArrayList<Eleve>();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Prof> getProfs() {
		return profs;
	}
	public void setProfs(List<Prof> profs) {
		this.profs = profs;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public List<Eleve> getEleves() {
		return eleves;
	}
	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}
	
	

}
