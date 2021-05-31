package controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidatoDao;
import dao.EleccionDao;
import model.Candidato;
import model.Eleccion;

/**
 * Servlet implementation class ContryServlet
 */
@WebServlet("/")
public class CandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CandidatoDao candidatoDao;
	private EleccionDao eleccionDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CandidatoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.candidatoDao = new CandidatoDao();
		this.eleccionDao = new EleccionDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/registrar-candidato":
				showFormCandidato(request, response);
				break;
			case "/insertar-candidato":
				insertCandidato(request, response);
				break;
			case "/eliminar-candidato":
				eliminarCandidato(request, response);
				break;
			case "/editar-candidato":
				showEditCandidato(request, response);
				break;
			case "/actualizar-candidato":
				actualizarCandidato(request, response);
				break;
			case "/registrar-eleccion":
				showFormEleccion(request, response);
				break;
			case "/insertar-eleccion":
				insertEleccion(request, response);
				break;
			default:
				listarCandidatos(request, response);
				break;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void showFormCandidato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		List<Eleccion> elecciones = eleccionDao.listar();
		request.setAttribute("elecciones", elecciones);
		dispatcher.forward(request, response);
	}

	private void insertCandidato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int eleccion = Integer.parseInt(request.getParameter("eleccion"));
		int numero = Integer.parseInt(request.getParameter("numero"));
		Candidato candidato = new Candidato(null, documento, nombre, apellido, eleccion, numero);
		candidatoDao.registrar(candidato);
		response.sendRedirect("list");
	}

	private void eliminarCandidato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		candidatoDao.eliminar(id);
		response.sendRedirect("list");
	}

	private void showEditCandidato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Candidato candidato = candidatoDao.porId(id);
		List<Eleccion> elecciones = eleccionDao.listar();
		request.setAttribute("candidato", candidato);
		request.setAttribute("elecciones", elecciones);
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarCandidato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		int id = Integer.parseInt(request.getParameter("id"));
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int eleccion = Integer.parseInt(request.getParameter("eleccion"));
		int numero = Integer.parseInt(request.getParameter("numero"));
		Candidato candidato = new Candidato(id, documento, nombre, apellido, eleccion, numero);
		candidatoDao.actualizar(candidato);
		response.sendRedirect("list");
	}

	private void showFormEleccion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("eleccion.jsp");
		dispatcher.forward(request, response);
	}

	private void insertEleccion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("eleccion.jsp");
		String nombre = request.getParameter("nombre");
		Date fechainicio = Date.valueOf(request.getParameter("fechainicio"));
		Date fechafin = Date.valueOf(request.getParameter("fechafin"));
		String cargo = request.getParameter("cargo");
		Eleccion eleccion = new Eleccion(null, nombre, fechainicio, fechafin, cargo);
		eleccionDao.registrar(eleccion);
		response.sendRedirect("list");
	}

	private void listarCandidatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		List<Candidato> candidatos = candidatoDao.listar();
		request.setAttribute("listaCandidatos", candidatos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listaCandidatos.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
