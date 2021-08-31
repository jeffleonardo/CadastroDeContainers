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

@WebServlet(urlPatterns = { "/Controller", "/main", "/insertC", "/insertM", "/select", "/update", "/delete" })
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
		if (action.equals("/main")) {
			listarContainers(request, response);
		} else if (action.equals("/insertC")) {
			inserirContainer(request, response);
		} else if (action.equals("/insertM")) {
			inserirMovimentacao(request, response);
		} else if (action.equals("/select")) {
			editarContainer(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}

	// listar containers
	protected void listarContainers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// criando um objeto que ira receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContainers();
		// encaminhar a lista ao documento cadastro.jsp
		request.setAttribute("container", lista);
		RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
		rd.forward(request, response);
	}

	// inserir container
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
	
	//editar contato
	protected void editarContainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//recebimento do contato que será editado
		String idCliente = request.getParameter("id");
		System.out.println(idCliente);
		//setar a variavel JavaBeans
		/*container.setId(idCliente);
		//executa o metodo selecionarContainer(DAO)
		dao.selecionarContainer(container);
		
		request.setAttribute("nomeCliente", container.getNomeCliente());
		request.setAttribute("numContainer", container.getNumContainer());
		request.setAttribute("tipo", container.getTipo());
		request.setAttribute("status", container.getStatusAtual());
		request.setAttribute("categoria", container.getCategoria());
		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
		rd.forward(request, response);*/
	}	
}
