package presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import business.RubricaEJB;
import data.Contatto;

@WebServlet("/deleteservlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	RubricaEJB rubricaEjb;

	public DeleteServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Contatto c = new Contatto();
		c.setId(id);
		rubricaEjb.deleteContatto(c);

	}
}