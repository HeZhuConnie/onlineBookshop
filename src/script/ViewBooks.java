package script;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.Book;

/**
 * Servlet implementation class ViewBooks
 */
@WebServlet("/ViewBooks")
public class ViewBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
		List<Book> books = Book.getAllAvaliableBooks();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Books</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");

		out.print("<h1>View Books</h1>");

		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><th>Id</th><th>Title</th><th>Author</th><th>price</th><th>Add to Cart</th>");
		for (Book book : books) {
			out.println("<form action=\"cart\" method=\"post\">");
			out.print("<tr><td>" + book.getId() + "</td><td>" + book.getTitle() + "</td><td>" + book.getAuthor()
					+ "</td><td>" + book.getPrice() + "</td>"
					+ "<td colspan=\"2\" align=\"center\"><button type=\"submit\" name=\"isbn\" value=\""
					+ book.getId() + "\" class=\"btn btn-default\">Add to Cart</button></td></tr>");
			out.println("</form>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

		out.close();

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
