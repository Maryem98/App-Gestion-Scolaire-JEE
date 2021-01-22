package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EleveDaoImpl;
import dao.IEleve;
import metier.*;




/**
 * Servlet implementation class servlet
 */
@WebServlet(name="Serveleve",urlPatterns= {"*.php"})
public class Serveleve extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IEleve metier;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serveleve() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	metier=new EleveDaoImpl(); //couplage fort classe
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String path=request.getServletPath();
		  if (path.equals("/connexioneleve.php")){
			  request.getRequestDispatcher("/login/logineleve.jsp").forward(request,response);  
	      }

		
		  else if (path.equals("/logineleve.php")&&(request.getMethod().equals("POST"))){
			 String CNE =request.getParameter("CNE");
			 String dateNaissance =request.getParameter("dateNaissance");
			 Eleve e=metier.getEleve(CNE, dateNaissance);
			 if(e!=null && e.getNom() !=null) {
				  HttpSession session =request.getSession();
				  session.setAttribute("CNE",CNE);
				  session.setAttribute("nom",e.getNom());
				  request.getRequestDispatcher("espaceeleve.jsp").forward(request,response);
			 }
			 else{
				  request.getRequestDispatcher("error.jsp").forward(request,response);

			 }
		  }
			 else if(path.equals("/cherchereleve.php")){
					
				  String motCle=request.getParameter("motCle"); 
				  EleveModel  model = new EleveModel(); 
				  model.setMotCle(motCle);//je stock le mot cle recupereé dansle model 
				  List<Eleve>eleves =metier.chercher("%"+motCle+"%");
				  model.setEleves(eleves);//stocker les employes dans le model
				  request.setAttribute("model", model);//je stock le model dans l'objet request
						
				request.getRequestDispatcher("cherchereleve.jsp").forward(request,response);
			}

		  
			else if(path.equals("/saisieeleve.php")) {
				//request.setAttribute("employe", new Employe());
				request.getRequestDispatcher("/form/saisieeleve.jsp").forward(request,response);
			}
			
			
			  else if (path.equals("/saveeleve.php")&& (request.getMethod().equals("POST"))){
			  String CNE=request.getParameter("CNE"); 
			  String nom=request.getParameter("nom"); 
			  String prenom=request.getParameter("prenom"); 
			  String dateNaissance=request.getParameter("dateNaissance");
			  String classe=request.getParameter("classe"); 
			 
			  Eleve e= metier.save(new Eleve(CNE,nom, prenom,dateNaissance,classe));
			  request.setAttribute("eleve", e);//je stock l'employe ajouté dand dans l'objet request
			  
              response.sendRedirect("cherchereleve.php?motCle=");			  
			  }
			  else if(path.equals("/supprimereleve.php")) {
					String CNE =request.getParameter("CNE");
					metier.delete(CNE);
					response.sendRedirect("cherchereleve.php?motCle=");
				} 
			  else if(path.equals("/modifiereleve.php")) {
					String CNE=request.getParameter("CNE");
					Eleve e=metier.getEleve(CNE);
					request.setAttribute("eleve",e);
				    request.getRequestDispatcher("/form/editeleve.jsp").forward(request,response);
		
			  }
			  else if(path.contentEquals("/modification.php")&&(request.getMethod().equals("POST"))) {
				 
				  String CNE =request.getParameter("CNE");
				  String nom=request.getParameter("nom"); 
				  String prenom=request.getParameter("prenom"); 
				  String dateNaissance=request.getParameter("dateNaissance");
				  String classe=request.getParameter("classe"); 
				 
				  Eleve e =new Eleve(CNE,nom, prenom, dateNaissance,classe);
				  metier.update(e);
				  request.setAttribute("eleve", e);
				  response.sendRedirect("cherchereleve.php?motCle=");
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
