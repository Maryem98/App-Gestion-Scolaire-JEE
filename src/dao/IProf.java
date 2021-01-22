package dao;

import java.util.List;

import metier.Eleve;
import metier.Prof;

public interface IProf {
	public Prof save (Prof prof);
	public Prof getProf(String IDN, String dateNaissance);
	public List<Prof> chercher(String mc);
	public Prof update(Prof ep);
	public void delete(String IDN);
	
	public Prof getProf(String IDN);
	public List<Eleve> geteleves();
	public List<Eleve>chercherparclas(String classe);
}
