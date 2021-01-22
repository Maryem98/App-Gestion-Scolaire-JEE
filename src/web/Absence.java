package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import dao.AbsenceDaoImpl;
import dao.ProfDaoImpl;
import metier.AbsenceEleve;
import metier.Eleve;

/**
 * Servlet implementation class Absence
 */

@WebServlet(name="/Absence",urlPatterns="*.ab")
public class Absence extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Absence() {
        super();    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/afficherclasse.ab")) {
			String classe=request.getParameter("classe");
	        ProfDaoImpl met=new ProfDaoImpl();
	        List <Eleve>list =met.chercherparclas(classe);
	        request.setAttribute("list",list);
	        request.getRequestDispatcher("afficherclasse.jsp").forward(request,response);
		  }
		
		  else if (path.equals("/absence.ab") && (request.getMethod().equals("POST"))){
			  response.setContentType("text/html;charset=UTF-8");
	            try (PrintWriter out = response.getWriter()) {
			   String absents []=request.getParameterValues("cne"); 
			   List<String> listAbsents=Arrays.asList(absents);
			   SimpleDateFormat formater = null;
			    Date aujourdhui = new Date();
			    formater = new SimpleDateFormat("dd-MM-yy");
			   String dauj=formater.format(aujourdhui);
	           
	            for(int i=0;i<listAbsents.size();i++) {
	            	 metier.AbsenceEleve a= new metier.AbsenceEleve(1,dauj,listAbsents.get(i),"Sans justification");
	                 AbsenceDaoImpl ab=new  AbsenceDaoImpl();
	                 ab.save(a);
	            	}
		        request.getRequestDispatcher("absencesaved.jsp").forward(request,response);

	            }
	        }
		  else if (path.equals("/chercherabs.ab")) {
			String CNE=request.getParameter("CNE");
	        AbsenceDaoImpl met=new AbsenceDaoImpl();
	        List <AbsenceEleve>list =met.chercherAbs(CNE);
	        request.setAttribute("list",list);
	        request.getRequestDispatcher("chercherabs.jsp").forward(request,response);
		  }
		
		  else if (path.equals("/chercherabsAdmin.ab")) {
			String CNE=request.getParameter("CNE");
	        AbsenceDaoImpl met=new AbsenceDaoImpl();
	        List <AbsenceEleve>list =met.chercherAbs(CNE);
	        request.setAttribute("list",list);
	        request.getRequestDispatcher("chercherabsAdmin.jsp").forward(request,response);
		  }
		 else if (path.equals("/chercherabsEleve.ab")) {
				String CNE=request.getParameter("CNE");
		        AbsenceDaoImpl met=new AbsenceDaoImpl();
		        List <AbsenceEleve>list =met.chercherAbs(CNE);
		        request.setAttribute("list",list);
		        request.getRequestDispatcher("chercherabsEleve.jsp").forward(request,response);
			  }
		 else if (path.equals("/chercherabsParent.ab")) {
				String CNE=request.getParameter("CNE");
		        AbsenceDaoImpl met=new AbsenceDaoImpl();
		        List <AbsenceEleve>list =met.chercherAbs(CNE);
		        request.setAttribute("list",list);
		        request.getRequestDispatcher("chercherabsParent.jsp").forward(request,response);
			  }
		  
		  }
		  
		  
		 
			
		

	

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
