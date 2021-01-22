package web;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlanDisplayDao;
import metier.Plan;

 
@WebServlet( name="PlanDispalyServlet",urlPatterns= {"*.plan"})
public class PlanDisplayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public PlanDisplayServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String path=request.getServletPath();
    	 if (path.equals("/getplan.plan")){
         int bookId = Integer.parseInt(request.getParameter("id"));
         PlanDisplayDao dao = new PlanDisplayDao();
        try {
            Plan book = dao.get(bookId);
            request.setAttribute("book", book); 
            String page = "/plan.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
            requestDispatcher.forward(request,response);              
           } catch (SQLException ex) { throw new ServletException(ex);}
         
    }
    	 else if (path.equals("/getplans.plan")) {
    		 PlanDisplayDao dao = new PlanDisplayDao();
    		 List<Plan>plans =dao.getPlans();
			  request.setAttribute("plans", plans);//je stock le model dans l'objet request
			  request.getRequestDispatcher("validerplan.jsp").forward(request,response);
    		 
    	 }
    	 else if (path.equals("/valider.plan")) {
             int bookId = Integer.parseInt(request.getParameter("id"));
             PlanDisplayDao dao = new PlanDisplayDao();
            
			try {
				 Plan book = dao.get(bookId);
			     dao.modifier(book);
				 request.setAttribute("book",book);
				 response.sendRedirect("getplans.plan");
			 } catch (SQLException e) {e.printStackTrace();}
    		 
    	 }
    	 else if (path.equals("/consulterplanning.plan")) {
    		 PlanDisplayDao dao = new PlanDisplayDao();
    		 List<Plan>plans =dao.getPlans();
			 request.setAttribute("plans", plans);//je stock le model dans l'objet request
			 request.getRequestDispatcher("afficherplans.jsp").forward(request,response);
    	 }
    	 else if (path.equals("/consulterplanParent.plan")) {
    		 PlanDisplayDao dao = new PlanDisplayDao();
    		 List<Plan>plans =dao.getPlans();
			 request.setAttribute("plans", plans);//je stock le model dans l'objet request
			 request.getRequestDispatcher("afficherplansParent.jsp").forward(request,response);
    	 }
}
}