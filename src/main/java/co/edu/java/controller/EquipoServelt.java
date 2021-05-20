package co.edu.java.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.java.dao.EquipoDao;
import co.edu.java.dao.PaisDao;
import co.edu.java.modelo.Equipo;

/**
 * Servlet implementation class EquipoServelt
 */
@WebServlet("/EquipoServelt")
public class EquipoServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EquipoDao equipoDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipoServelt() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig conf) throws ServletException{
    	this.equipoDao = new EquipoDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
			switch(action) {
			case "/nuevo":
				verNuevo(request, response);
				break;
			case "/insertar":
				insertarEquipo(request, response);
				break;
			case "/eliminar":
				eliminarEquipo(request, response);
				break;
			case "/editar":
				editarNuevo(request, response);
				break;
			case "/actualizar":
				actualizarEquipo(request, response);
				break;
			default:
				listarEquipo(request, response);
				break;
			}
			} catch (SQLException e) {
				throw new ServletException (e);
			}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void verNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("equipo.jsp");
		rd.forward(request, response);
	}
	
	private void insertarEquipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ServletException {
		String id = request.getParameter("id");
		String nombre= request.getParameter("name");
		String pais= request.getParameter("country");
		Equipo equipo = new Equipo(id,nombre,pais);
		equipoDao.insert(equipo);
		response.sendRedirect("list");
	}
	
	private void editarNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Equipo actual = equipoDao.select(id);
		request.setAttribute("usuario", actual);
		
		RequestDispatcher rd = request.getRequestDispatcher("equipo.jsp");
		rd.forward(request, response);
	}
	
	private void actualizarEquipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ServletException {
		String id = request.getParameter("id");
		String nombre= request.getParameter("name");
		String pais= request.getParameter("country");
		
		Equipo equipo = new Equipo(id,nombre,pais);
		equipoDao.update(equipo);
		response.sendRedirect("list");
	}
	
	private void eliminarEquipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ServletException {
		String id = request.getParameter("id");
		
		equipoDao.delete(id);
		response.sendRedirect("list");
	}
	
	private void listarEquipo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ServletException {
	List <Equipo> lista = equipoDao.selectAll();
	request.setAttribute("lista", lista);
	
	RequestDispatcher rd = request.getRequestDispatcher("equipoList.jsp");
	rd.forward(request, response);
	}

}
