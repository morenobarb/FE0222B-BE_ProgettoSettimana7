package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import business.RubricaEJB;
import data.Contatto;
import data.NumeroTelefono;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CognomeServlet")
public class CognomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	RubricaEJB rubrica;

	public CognomeServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String cognome = request.getParameter("cognome");
		//out.println("<p style='text-align:center; front-weight: bold'>Cognome selezionato:" + cognome + " "
			//	+ "NON PRESENTE!" + "</p>");

		List<Contatto> lista = rubrica.getContattoByCognome(cognome);

		for (Contatto c : lista) {
			List<NumeroTelefono> numTelefoni = c.getNumTelefoni();

			out.println("<h2>Nome : " + c.getNome() + "   " + "Cognome :" + c.getCognome() + "    " + "</h2>");

			for (NumeroTelefono n : numTelefoni) {
				out.println("<h4>" + n.getNumeroTelefono() + "</h4>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
