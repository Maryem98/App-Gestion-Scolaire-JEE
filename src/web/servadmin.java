package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDaoImpl;
import dao.IAdmin;
import metier.Admin;

/**
 * Servlet implementation class servadmin
 */
@WebServlet(name="/servadmin",urlPatterns="*.net")
public class servadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IAdmin metier;   
    
    public servadmin() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
    	metier=new AdminDaoImpl(); //couplage fort classe
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();

	
		 if (path.equals("/connexionadmin.net")){
			  
			  
			  request.getRequestDispatcher("/login/loginadmin.jsp").forward(request,response);
			  
	      }

		
		  else if (path.equals("/loginadmin.net")&&(request.getMethod().equals("POST"))){
			 String username =request.getParameter("username");
			 String password =request.getParameter("password");
			 Admin e=metier.getAdmin(username,password);
			 if(e!=null && e.getUsername()!=null) {
				  request.getRequestDispatcher("espaceAdmin.jsp").forward(request,response);
				 
			 }
			 else{
				  request.getRequestDispatcher("error.jsp").forward(request,response);

			 }}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
