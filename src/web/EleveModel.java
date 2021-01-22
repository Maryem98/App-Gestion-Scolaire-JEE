package web;

import java.util.*;


import metier.*;

public class EleveModel {
	private String motCle;
	private List<Eleve>eleves=new ArrayList<Eleve>();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Eleve> getEleves() {
		return eleves;
	}
	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}
	
}
