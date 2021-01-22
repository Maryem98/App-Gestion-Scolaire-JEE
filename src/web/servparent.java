package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import metier.*;

/**
 * Servlet implementation class servparent
 */
@WebServlet(name ="/servparent",urlPatterns="*.dot")
public class servparent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IParent metier;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servparent() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
    	metier=new ParentDaoImpl(); //couplage fort classe
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();

		 
		  if (path.equals("/connexionparent.dot")){
			  
			  
			  request.getRequestDispatcher("/login/loginparent.jsp").forward(request,response);
			  
	      }

		
		  else if (path.equals("/loginparent.dot")&&(request.getMethod().equals("POST"))){
			 String IDP =request.getParameter("IDP");
			 String dateNaissance =request.getParameter("dateNaissance");
			 Parent e=metier.getParent(IDP,dateNaissance);
			 if(e!=null && e.getNom() !=null) {
				  request.getRequestDispatcher("espaceparent.jsp").forward(request,response);
				 
			 }
			 else {
				  request.getRequestDispatcher("error.jsp").forward(request,response);

			 }
		  }
			 else if(path.equals("/chercherparent.dot")){
					
				  String motCle=request.getParameter("motCle"); 
				  ParentModel  model = new ParentModel(); 
				  model.setMotCle(motCle);//je stock le mot cle recupereé dansle model 
				  List<Parent>parents =metier.chercher("%"+motCle+"%");
				  model.setParents(parents);//stocker les employes dans le model
				  request.setAttribute("model", model);//je stock le model dans l'objet request
						
				request.getRequestDispatcher("chercherparent.jsp").forward(request,response);
			}

		    
		     
			 else  if(path.equals("/saisieparent.dot")) {
				//request.setAttribute("employe", new Employe());
				request.getRequestDispatcher("/form/saisieparent.jsp").forward(request,response);
			}
			
			
			  else if (path.equals("/saveparent.dot")&& (request.getMethod().equals("POST"))){
			  String IDP=request.getParameter("IDP"); 
			  String nom=request.getParameter("nom"); 
			  String prenom=request.getParameter("prenom"); 
			  String dateNaissance=request.getParameter("dateNaissance");
			 
			  Parent e= metier.save(new Parent(IDP,nom, prenom,dateNaissance));
			  request.setAttribute("prof", e);//je stock l'employe ajouté dand dans l'objet request
			  
			  response.sendRedirect("chercherparent.do?motCle=");
			  
			  }
		 
		  else if(path.equals("/supprimerparent.dot")) {
				String IDP =request.getParameter("IDP");
				metier.delete(IDP);
				response.sendRedirect("chercherparent.dot?motCle=");
			} 
		  else if(path.equals("/modifierparent.dot")) {
				String IDP=request.getParameter("IDP");
				Parent e=metier.getParent(IDP);
				request.setAttribute("parent",e);
			    request.getRequestDispatcher("/form/editparent.jsp").forward(request,response);
	
		  }
		  else if(path.contentEquals("/modification.dot")&&(request.getMethod().equals("POST"))) {
			 
			  String IDP=request.getParameter("IDP");
			  String nom=request.getParameter("nom"); 
			  String prenom=request.getParameter("prenom"); 
			  String dateNaissance=request.getParameter("dateNaissance");		
			  Parent e =new Parent(IDP,nom, prenom, dateNaissance);
			  metier.update(e);
			  request.setAttribute("eleve", e);
			  response.sendRedirect("chercherparent.dot?motCle=");
			  }
		  else if (path.equals("/rendezvous.dot")&& (request.getMethod().equals("POST"))){
			  
			  String nom=request.getParameter("name"); 
			  String message=request.getParameter("message"); 
			  
			 
			  RendezVous e= metier.saveRendezvous(new RendezVous(nom,message));
			  request.setAttribute("prof", e);//je stock l'employe ajouté dand dans l'objet request
				request.getRequestDispatcher("rendenv.jsp").forward(request,response);
 
			  }
		  else if(path.equals("/getrendezvous.dot")) {
			  
			  List<RendezVous>rendezvous =metier.getrendezvous();
			  
			  request.setAttribute("list", rendezvous);//je stock le model dans l'objet request
			  request.getRequestDispatcher("getrendezvous.jsp").forward(request,response);
			  }
	 
	 


	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
