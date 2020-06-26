package cl.jorge;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ingresoValores")
public class GeneradorFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

//		form data
		String nombre;
		String empresa;
		String rut;
		String direccion;
		String pais;
		String ciudad;

		nombre = request.getParameter("nombre");
		empresa = request.getParameter("empresa");
		rut = request.getParameter("rut");
		direccion = request.getParameter("direccion");
		pais = request.getParameter("pais");
		ciudad = request.getParameter("ciudad");

		request.setAttribute("nombre", nombre);
		request.setAttribute("empresa", empresa);
		request.setAttribute("rut", rut);
		request.setAttribute("direccion", direccion);
		request.setAttribute("pais", pais);
		request.setAttribute("ciudad", ciudad);

//		table data
		String valvulas;
		String turbo;
		String frenos;
		String refri;
		String plumas;

		valvulas = request.getParameter("valvulas");
		turbo = request.getParameter("turbo");
		frenos = request.getParameter("frenos");
		refri = request.getParameter("refri");
		plumas = request.getParameter("plumas");

		request.setAttribute("valvulas", valvulas);
		request.setAttribute("turbo", turbo);
		request.setAttribute("frenos", frenos);
		request.setAttribute("refri", refri);
		request.setAttribute("plumas", plumas);

//		prices
		int p_valvulas = 120000 * Integer.parseInt(valvulas);
		int p_turbo = 1700000 * Integer.parseInt(turbo);
		int p_frenos = 760000 * Integer.parseInt(frenos);
		int p_refri = 2300000 * Integer.parseInt(refri);
		int p_plumas = 10000 * Integer.parseInt(plumas);

		request.setAttribute("t_valvulas", p_valvulas);
		request.setAttribute("t_turbo", p_turbo);
		request.setAttribute("t_frenos", p_frenos);
		request.setAttribute("t_refri", p_refri);
		request.setAttribute("t_plumas", p_plumas);

		request.setAttribute("t_tn", p_valvulas + p_turbo + p_frenos + p_refri + p_plumas);
		request.setAttribute("t_t", (p_valvulas + p_turbo + p_frenos + p_refri + p_plumas) * 0.9);

//		forward request
		try {
			request.getRequestDispatcher("/factura.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}