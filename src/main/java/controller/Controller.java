package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insertC", "/insertM", "/select", "/updateC", "/delete",
		"/report" })
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
			listarContainer(request, response);
		} else if (action.equals("/updateC")) {
			editarContainer(request, response);
		} else if (action.equals("/delete")) {
			removerContainer(request, response);
		} else if (action.equals("/report")) {
			gerarRelatorio(request, response);
		} else {
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

	// editar contato
	protected void listarContainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do contato que será editado
		String idCliente = request.getParameter("id");
		System.out.println(idCliente);
		// setar a variavel JavaBeans
		container.setId(idCliente);
		// executa o metodo selecionarContainer(DAO)
		JavaBeans container = dao.selecionarContainer(idCliente);

		System.out.println(container);

		request.setAttribute("id", container.getId());
		request.setAttribute("nomeCliente", container.getNomeCliente());
		request.setAttribute("numContainer", container.getNumContainer());
		request.setAttribute("tipo", container.getTipo());
		request.setAttribute("status", container.getStatusAtual());
		request.setAttribute("categoria", container.getCategoria());
		request.setAttribute("movimentacao", container.getTipoMovimentacao());
		request.setAttribute("dataInicio", container.getDataInicio());
		request.setAttribute("dataFim", container.getDataFim());
		// Encaminhar ao documento editarContainer.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editarContainer.jsp");
		rd.forward(request, response);
	}

	protected void editarContainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis JavaBeans
		// System.out.println("ola");
		container.setId(request.getParameter("id"));
		container.setNomeCliente(request.getParameter("nomeCliente"));
		container.setNumContainer(request.getParameter("numContainer"));
		container.setTipo(request.getParameter("tipo"));
		container.setStatusAtual(request.getParameter("status"));
		container.setCategoria(request.getParameter("categoria"));
		container.setTipoMovimentacao(request.getParameter("movimentacao"));
		container.setDataInicio(request.getParameter("dataInicio"));
		container.setDataFim(request.getParameter("dataFim"));

		// executar o metodo alterarContainer
		dao.alterarContainer(container);
		// redirecionar para o documento cadastro.jsp(atualizando os dados)
		response.sendRedirect("main");

	}

	// Remover container
	protected void removerContainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do id do container a ser excluido
		// setar a variavel idcon JavaBeans
		container.setId(request.getParameter("id"));
		// executar o metodo deletarContainer
		dao.deletarContainer(container);
		dao.deletarMovimentacao(container);
		// redirecionar para o documento cadastro.jsp(atualizando os dados)
		response.sendRedirect("main");
	}

	// gerar relatorio
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document(PageSize.A4, 10f, 10f, 10f, 10f);
		try {
			// tipo e conteudo
			response.setContentType("apllication/pdf");
			// nome do documento
			response.addHeader("Content-Disposition", "inline; filename= " + "containers.pdf");
			// criar documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// abrir o documento
			documento.open();
			documento.add(new Paragraph("Relatório de containers"));
			documento.add(new Paragraph(" "));
			// criar uma tabela
			PdfPTable tabela = new PdfPTable(8);
			// cabecalho
			PdfPCell col1 = new PdfPCell(new Paragraph("Cliente"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Nº Container"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Tipo"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Status"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Categoria"));
			PdfPCell col6 = new PdfPCell(new Paragraph("Movimentação"));
			PdfPCell col7 = new PdfPCell(new Paragraph("Entrada"));
			PdfPCell col8 = new PdfPCell(new Paragraph("Saída"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);
			tabela.addCell(col7);
			tabela.addCell(col8);
			// popular a tabela com os containers
			ArrayList<JavaBeans> lista = dao.listarContainers();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNomeCliente());
				tabela.addCell(lista.get(i).getNumContainer());
				tabela.addCell(lista.get(i).getTipo());
				tabela.addCell(lista.get(i).getStatusAtual());
				tabela.addCell(lista.get(i).getCategoria());
				tabela.addCell(lista.get(i).getTipoMovimentacao());
				tabela.addCell(lista.get(i).getDataInicio());
				tabela.addCell(lista.get(i).getDataFim());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			documento.close();
		}

	}
}
