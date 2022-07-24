package presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import business.RubricaEJB;
import data.Contatto;
import data.NumeroTelefono;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
@EJB
RubricaEJB rubricaEjb;
    
    public InsertServlet() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Contatto c = new Contatto();

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");

		c.setNome(nome);
		c.setCognome(cognome);
		c.setEmail(email);

		NumeroTelefono numero1 = new NumeroTelefono();
		NumeroTelefono numero2 = new NumeroTelefono();

		ArrayList<NumeroTelefono> numeriTelefono = new ArrayList<NumeroTelefono>();

		if (!request.getParameter("numero1").isBlank()) {
			numero1.setNumeroTelefono(request.getParameter("numero1"));
			numero1.setContatto(c);
			numeriTelefono.add(numero1);

		}

		 if (!request.getParameter("numero2").isBlank()) {
			numero2.setNumeroTelefono(request.getParameter("numero2"));
			numero2.setContatto(c);
			numeriTelefono.add(numero2);
		}

		  if (request.getParameter("numero1").isBlank() && request.getParameter("numero2").isBlank()) {
			HttpSession session = request.getSession();
			session.setAttribute("messaggio", "Attenzione! Inserire almeno un numero di telefono!");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/insert.jsp");
			dispatcher.forward(request, response);

		}
		c.setNumTelefoni(numeriTelefono);
		rubricaEjb.insertContatto(c);
		
		out.println("Il nome inserito  : "+request.getParameter("nome"));
		out.println("Il cognome inserito  : "+request.getParameter("cognome"));
		out.println("L' email inserito  : "+request.getParameter("email"));
		out.println("Il numero1 inserito  : "+request.getParameter("numero1"));
		out.println("Il numero2 inserito  : "+request.getParameter("numero2"));
	}

}