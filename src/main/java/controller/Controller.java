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

@WebServlet(urlPatterns = { "/Controller", "/main", "/insertC", "/insertM", "/read", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	JavaBeans container = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		System.out.println(container);
		if (action.equals("/main")) {
			listarContainers(request, response);
		} else if (action.equals("/insertC")) {
			inserirContainer(request, response);
		} else if (action.equals("/insertM")) {
			inserirMovimentacao(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// listar containers
	protected void listarContainers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// criando um objeto que ira receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContainers();
		// encaminhar a lista ao documento agenda.jsp
		request.setAttribute("containers", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	// iserir container

	protected void inserirContainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis JavaBeans
		container.setNomeCliente(request.getParameter("cliente"));
		container.setNumContainer(request.getParameter("numContainer"));
		container.setTipo(request.getParameter("tipo"));
		container.setStatusAtual(request.getParameter("status"));
		container.setCategoria(request.getParameter("categoria"));

		// invocar o metodo inserirContainer passando o objeto container
		dao.inserirContainer(container);

		// redirecionar para o documento agenda.jsp
		response.sendRedirect("novaMovimentacao.html");

	}

	protected void inserirMovimentacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		container.setTipoMovimentacao(request.getParameter("movimentacao"));
		container.setDataInicio(request.getParameter("dataInicio"));
		container.setDataFim(request.getParameter("dataFim"));

		dao.inserirMovimentacao(container);

		response.sendRedirect("main");
	}

}
