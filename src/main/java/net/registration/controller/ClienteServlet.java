package net.registration.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.registration.dao.ClienteDao;
import net.registration.model.Cliente;

@WebServlet("/")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClienteDao clienteDao = new ClienteDao();
   
    public ClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		try {
			switch (action) {
			case "/register":
				insertCliente(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateCliente(request, response);
				break;
			case "/delete":
				deleteCliente(request, response);
				break;
			default:
				listCliente(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listCliente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Cliente> listCliente = clienteDao.selectAllCliente();
		request.setAttribute("listCliente", listCliente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/clienteregister.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Cliente existingCliente = clienteDao.selectCliente(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cliente-form.jsp");
		request.setAttribute("cliente", existingCliente);
		dispatcher.forward(request, response);

	}
	
	private void updateCliente(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");

		Cliente cliente = new Cliente(firstName, lastName, address, contact, id);
		clienteDao.updateCliente(cliente);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/clienteregister.jsp");
		dispatcher.forward(request, response);
	}
	
	private void deleteCliente(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");

		Cliente cliente = new Cliente(firstName, lastName, address, contact, id);
		clienteDao.deleteCliente(cliente);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/clienteregister.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void insertCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		Cliente cliente = new Cliente(firstName, lastName, address, contact, 1);
		
		try {
			clienteDao.registerCliente(cliente);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/clientedetalhes.jsp");
		dispatcher.forward(request, response);
	}

}
