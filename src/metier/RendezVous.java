package metier;

public class RendezVous {
	private int id;
	private String nom;
	private String message;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public RendezVous() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RendezVous(String nom, String message) {
		super();
		this.nom = nom;
		this.message = message;
	}
	
	

}
