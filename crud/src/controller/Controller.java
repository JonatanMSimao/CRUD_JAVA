package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans usuario = new JavaBeans();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			cadastro(request, response);
		} else if (action.equals("/insert")) {
			adicionarUsuario(request, response);
		} else if (action.equals("/select")) {
			listarUsuarios(request, response);
		} else if (action.equals("/update")) {
			editarUsuarios(request, response);
		} else if (action.equals("/delete")) {
			excluirUsuarios(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Listar Cadastro
	protected void cadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto para receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarUsuarios();
		// Encaminhar lista a cadastro.jsp
		request.setAttribute("usuarios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
		rd.forward(request, response);
	}

	// Adicionar Usu�rios
	protected void adicionarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as vari�veis JavaBeans
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setFone(request.getParameter("fone"));
		// m�todo inserirUsuario passando o Objeto usuario
		dao.inserirUsuario(usuario);
		// Redirecionar para cadastro.jsp
		response.sendRedirect("main");
	}

	// Editar Usu�rios
	protected void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar vari�vel JavaBeans
		usuario.setId(request.getParameter("id"));
		// executar m�todo selecionarUsuario (DAO)
		dao.selecionarUsuario(usuario);
		// Setar atributos do form com conte�do JavaBeans
		request.setAttribute("id", usuario.getId());
		request.setAttribute("nome", usuario.getNome());
		request.setAttribute("email", usuario.getEmail());
		request.setAttribute("fone", usuario.getFone());
		// Encaminhar ao editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	protected void editarUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar vari�veis JavaBeans
		usuario.setId(request.getParameter("id"));
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setFone(request.getParameter("fone"));
		// executar m�todo alterarUsu�rio
		dao.alterarUsuario(usuario);
		// retornar a cadastro.jsp
		response.sendRedirect("main");
	}

	// Excluir usu�rio
	protected void excluirUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usuario.setId(request.getParameter("id"));
		// executar m�todo excluirContato (Dao)
		dao.excluirUsuario(usuario);
		// retornar a cadastro.jsp
		response.sendRedirect("main");
	}
}
