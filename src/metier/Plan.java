package metier;

public class Plan {
	private int id;
	private String comment;
    private int valide;
    private String photo;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getValide() {
		return valide;
	}
	public void setValide(int valide) {
		this.valide = valide;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Plan(String comment, int valide, String photo) {
		super();
		this.comment = comment;
		this.valide = valide;
		this.photo = photo;
	}
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Plan [id=" + id + ", comment=" + comment + ", valide=" + valide + ", photo=" + photo + "]";
	}
	
    

}
