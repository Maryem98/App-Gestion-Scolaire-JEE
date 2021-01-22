package web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.*;
import metier.*;

/**
 * Servlet implementation class Servprof
 */
@WebServlet(name="Servprof",urlPatterns= {"*.do"})
public class Servprof extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IProf metier;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servprof() {
        super();
    }
    @Override
    public void init() throws ServletException {
    	metier=new ProfDaoImpl(); //couplage fort classe
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();

		
		  if (path.equals("/connexionprof.do")){
			  
			  
			  request.getRequestDispatcher("/login/loginprof.jsp").forward(request,response);
			  
	      }

		
		  else if (path.equals("/loginprof.do")&&(request.getMethod().equals("POST"))){
			 String IDN =request.getParameter("IDN");
			 String dateNaissance =request.getParameter("dateNaissance");
			 Prof e=metier.getProf(IDN,dateNaissance);
			 if(e!=null && e.getNom() !=null) {
				  request.getRequestDispatcher("espaceprof.jsp").forward(request,response);
				 
			 }
			 else{
				  request.getRequestDispatcher("error.jsp").forward(request,response);

			 }
		  }
		  
		  else if(path.equals("/chercherprof.do")){
				
			  String motCle=request.getParameter("motCle"); 
			  ProfModel  model = new ProfModel(); 
			  model.setMotCle(motCle);//je stock le mot cle recupereé dansle model 
			  List<Prof>profs =metier.chercher("%"+motCle+"%");
			  model.setProfs(profs);//stocker les employes dans le model
			  request.setAttribute("model", model);//je stock le model dans l'objet request
					
			request.getRequestDispatcher("chercherprof.jsp").forward(request,response);
		}
		  else if(path.equals("/saisieprof.do")) {
				//request.setAttribute("employe", new Employe());
				request.getRequestDispatcher("/form/saisieprof.jsp").forward(request,response);
			}
			
			
			  else if (path.equals("/saveprof.do")&& (request.getMethod().equals("POST"))){
			  String IDN=request.getParameter("IDN"); 
			  String nom=request.getParameter("nom"); 
			  String prenom=request.getParameter("prenom"); 
			  String dateNaissance=request.getParameter("dateNaissance");		 
			  Prof e= metier.save(new Prof(IDN,nom, prenom,dateNaissance));
			  request.setAttribute("prof", e);//je stock l'employe ajouté dand dans l'objet request
			  
              response.sendRedirect("chercherprof.do?motCle=");			  

			  
			  }

			  else if(path.equals("/supprimerprof.do")) {
					String IDN =request.getParameter("IDN");
					metier.delete(IDN);
					response.sendRedirect("chercherprof.do?motCle=");
				} 
			  else if(path.equals("/modifierprof.do")) {
					String IDN=request.getParameter("IDN");
					Prof e=metier.getProf(IDN);
					request.setAttribute("prof",e);
				    request.getRequestDispatcher("/form/editprof.jsp").forward(request,response);
		
			  }
			  else if(path.contentEquals("/modification.do")&&(request.getMethod().equals("POST"))) {
				 
				  String IDN=request.getParameter("IDN");
				  String nom=request.getParameter("nom"); 
				  String prenom=request.getParameter("prenom"); 
				  String dateNaissance=request.getParameter("dateNaissance");
				
				 
				  Prof e =new Prof(IDN,nom, prenom, dateNaissance);

				  metier.update(e);
				  request.setAttribute("prof", e);
				  response.sendRedirect("chercherprof.do?motCle=");
				  }
			  else if(path.equals("/chercherclasse.do")) {	
				      request.getRequestDispatcher("afficherclasse.jsp").forward(request,response);
				  }
		  
		/*
		 * else if(path.equals("/deposerplan.do")) { //get fields from jsp
		 * 
		 * String comment =request.getParameter("comment"); Part filePart =
		 * request.getPart("file"); InputStream inputStream = null; if (filePart !=
		 * null) { long fileSize=filePart.getSize(); String
		 * filecontent=filePart.getContentType(); inputStream =
		 * filePart.getInputStream();
		 * 
		 * }
		 * 
		 * Connection connection=SingletonConnetion.getConnetion(); try {
		 * PreparedStatement ps =
		 * connection.prepareStatement("insert into plan (comment,file)VALUES(?,?,?,?)"
		 * ); ps.setString(1,comment); ps.setBlob(2,inputStream); int
		 * returncode=ps.executeUpdate(); if(returncode==0) {
		 * request.setAttribute("Message","Error in inserting file");
		 * getServletContext().getRequestDispatcher("failure.jsp"); } else {
		 * request.setAttribute("Message","your record is inserted");
		 * getServletContext().getRequestDispatcher("succes.jsp"); } } catch
		 * (SQLException e) {e.printStackTrace();}
		 * 
		 * 
		 * 
		 * }
		 */
		 
			  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
