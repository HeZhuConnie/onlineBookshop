package authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XMLServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		String userName, passWord;
		// get user name and password from URL arguments
		userName = request.getParameter("userName");
		passWord = request.getParameter("passWord");
		
		System.out.println("Hello from Get " + userName + passWord);
		
		PrintWriter writer = response.getWriter();
		writer.print(" Hello in html " + userName + " " + passWord );
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		String auth = getServletConfig().getInitParameter("userNameI");
		String authPassword = getServletConfig().getInitParameter("passWordI");
		
		if(request.getParameter("userName").equalsIgnoreCase(auth) &&
				request.getParameter("passWord").equalsIgnoreCase(authPassword)) {
			response.sendRedirect("http://localhost:8080/OnlineBookShopProject/success.jsp");
			
		}	
		else System.out.println("ERROR");
		
		
	}

}
