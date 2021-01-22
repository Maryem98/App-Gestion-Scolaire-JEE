package dao;

import java.util.List;


import metier.Parent;
import metier.RendezVous;

public interface IParent {
	public Parent save(Parent parent);
	public Parent getParent(String IDP,String dateNaissance);
	public List<Parent> chercher(String mc);
	Parent update(Parent ep);
	public void delete(String IDP);
	public Parent getParent(String IDN) ;
	public RendezVous saveRendezvous(RendezVous rendezVous);
	public List<RendezVous> getrendezvous();
}
