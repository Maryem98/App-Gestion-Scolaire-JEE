package metier;


public class AbsenceEleve {
	    private int IdAbsenceEleve;
	    private String Date;
	    private String CNE;
	    private String absent; 
	    
	       
	    @Override
		public String toString() {
			return "AbsenceEleve [IdAbsenceEleve=" + IdAbsenceEleve + ", Date=" + Date
					+ ", CNE=" + CNE + ", absent=" + absent + "]";
		}
		public AbsenceEleve(int idAbsenceEleve, String date, String cNE, String absent) {
			super();
			IdAbsenceEleve = idAbsenceEleve;
			Date = date;
			CNE = cNE;
			this.absent = absent;
		}
		public AbsenceEleve() {
			// TODO Auto-generated constructor stub  
		}
		//getters and setters
		public int getIdAbsenceEleve() {
			return IdAbsenceEleve;
		}
		public void setIdAbsenceEleve(int idAbsenceEleve) {
			IdAbsenceEleve = idAbsenceEleve;
		}
		
		public String getDate() {
			return Date;
		}
		public void setDate(String date) {
			Date = date;
		}
		public String getCNE() {
			return CNE;
		}
		public void setCNE(String cNE) {
			CNE = cNE;
		}
		public String getAbsent() {
			return absent;
		}
		public void setAbsent(String absent) {
			this.absent = absent;
		}
	    

}
