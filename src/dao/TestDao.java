package dao;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import metier.AbsenceEleve;
import metier.Plan;

public class TestDao {
	public static void main(String []args) throws SQLException, IOException {
		
		
//		  ProfDaoImpl dao= new ProfDaoImpl();
//		  Prof e = new  Prof("999","tajriba0","a","aaa"); 
//		  dao.save(e);
//		  e=dao.update(new Prof("999","njhaaat","njhat","tajriba"));
		 
		
		/*
		 * ProfDaoImpl d =new ProfDaoImpl();
		 *  List <Eleve>eleves =d.chercherparclas("1");
		 *   System.out.println(eleves.toString());
		 * 
		 */
		/*
		 * ProfDaoImpl dao=new ProfDaoImpl(); Prof p=dao.save(new
		 * Prof("ffffffff","abc","abc","abc"));
		 */

//         metier.AbsenceEleve a= new metier.AbsenceEleve(1,"15/12/1998","555","absent");
//         
//         AbsenceDaoImpl ab=new  AbsenceDaoImpl();
//         ab.save(a);
		  
		  PlanDisplayDao dao =new PlanDisplayDao();
		  Plan pl =new Plan();
		  pl=dao.get(15);
		  System.out.println(pl.toString());
	   	   Plan pl2=dao.modifier(pl);
		  System.out.println( pl2.toString());

		
		    
		   
		
		/*
		 * AbsenceDaoImpl d =new AbsenceDaoImpl(); List <AbsenceEleve>eleves
		 * =d.chercherAbs("555"); for(AbsenceEleve a :eleves) {
		 * System.out.println(a.toString()); }
		 */
		
		
	}

}
