package cl.jorge;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/procesaLogin")
public class ProcesadorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user;
		String pass;

//		tomar el usuario y pass insertado por el usuario en el login
		user = request.getParameter("login");
		pass = request.getParameter("pass");

//		comparar si datos de usuario coinciden
		boolean loginAttempt = (user.contentEquals("admin") && pass.contentEquals("admin"));
		String goTo;

//		si los datos del usuario no coinciden devuelve al index con error
		if (!loginAttempt) {
			goTo = "/index.jsp";
			request.setAttribute("loginStatus", "1");
//		si los datos del usuario coinciden pasa a la siguiente pagina sin error
		} else {
			goTo = "/ingresoValores.jsp";
			request.setAttribute("loginStatus", "0");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("nickname", "admin");

		}
//		ejecuta redireccion en relacion a la resolucion anterior
		try {
			request.getRequestDispatcher(goTo).forward(request, response);

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}
}
