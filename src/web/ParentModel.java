package web;

import java.util.ArrayList;
import java.util.List;

import metier.Parent;



public class ParentModel {
	private String motCle;
	private List<Parent>parents=new ArrayList<Parent>();
	public String getMotCle() {
		return motCle;
	}
	public List<Parent> getParents() {
		return parents;
	}
	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	
		
	
}
