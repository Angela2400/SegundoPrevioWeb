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

import co.edu.java.dao.PaisDao;
import co.edu.java.modelo.Pais;


/**
 * Servlet implementation class PaisServlet
 */
@WebServlet({ "/PaisServlet", "/pais" })
public class PaisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PaisDao paisDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig conf) throws ServletException{
    	this.paisDao = new PaisDao();
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
				insertarUsuario(request, response);
				break;
			case "/eliminar":
				eliminarUsuario(request, response);
				break;
			case "/editar":
				editarNuevo(request, response);
				break;
			case "/actualizar":
				actualizarUsuario(request, response);
				break;
			default:
				listarUsuarios(request, response);
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
		RequestDispatcher rd = request.getRequestDispatcher("pais.jsp");
		rd.forward(request, response);
	}
	
	private void insertarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ServletException {
		String id = request.getParameter("id");
		String nombre= request.getParameter("nombre");
	
		Pais pais = new Pais(id,nombre);
		paisDao.insert(pais);
		response.sendRedirect("list");
	}
	
	private void editarNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Pais actual = paisDao.select(id);
		request.setAttribute("usuario", actual);
		
		RequestDispatcher rd = request.getRequestDispatcher("pais.jsp");
		rd.forward(request, response);
	}
	
	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ServletException {
		String id = request.getParameter("id");
		String nombre= request.getParameter("nombre");

		
		Pais pais = new Pais(id,nombre);
		paisDao.update(pais);
		response.sendRedirect("list");
	}
	
	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ServletException {
		String id = request.getParameter("id");
		
		paisDao.delete(id);
		response.sendRedirect("list");
	}
	
	private void listarUsuarios (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ServletException {
	List <Pais> lista = paisDao.selectAll();
	request.setAttribute("lista", lista);
	
	RequestDispatcher rd = request.getRequestDispatcher("paisList.jsp");
	rd.forward(request, response);
	}

}
