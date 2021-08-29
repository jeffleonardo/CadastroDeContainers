package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {

	// Parametros de conexao com o banco de dados
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbcontainer?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "admin";

	// Método de conexao

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// teste de conexao

	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD CREATE
	public void inserirContainer(JavaBeans container) {
		String create = "insert into container (nomeCliente, numContainer, tipo, statusAtual, categoria) values(?,?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, container.getNomeCliente());
			pst.setString(2, container.getNumContainer());
			pst.setString(3, container.getTipo());
			pst.setString(4, container.getStatusAtual());
			pst.setString(5, container.getCategoria());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void inserirMovimentacao(JavaBeans container) {
		String create = "insert into movimentacoes (tipoMovimentacao, dataInicio, dataFim, id_container) values(?,?,?,(select id from movimentacoes where id = (id_container)";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, container.getTipoMovimentacao());
			pst.setString(2, container.getDataInicio());
			pst.setString(3, container.getDataFim());
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
