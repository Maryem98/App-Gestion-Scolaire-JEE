package dao;

import java.util.List;

import metier.Eleve;

public interface IEleve {
	public Eleve save(Eleve e);
	public Eleve getEleve(String CNE,String dateNaissance);
	public List<Eleve> chercher(String mc);
	Eleve update(Eleve ep);
	public void delete(String CNE);
	public Eleve getEleve(String CNE) ;
	
	}
