package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

	// CRUD CREATE  (select max(id) from container c where c.numContainer = ? limit 1)
	public void inserirContainer(JavaBeans container) {
		String create = "insert into container (nomeCliente, numContainer, tipo, statusAtual, categoria) values(?,?,?,?,?)";
		System.out.println(container);
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, container.getNomeCliente());
			pst.setString(2, container.getNumContainer());
			pst.setString(3, container.getTipo());
			pst.setString(4, container.getStatusAtual());
			pst.setString(5, container.getCategoria());
			
			pst.execute();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void inserirMovimentacao(JavaBeans container) {
		String create = "insert into movimentacoes (tipoMovimentacao, horaInicio, horaFim, id_container) values(?,?,?,(select max(id) from container c where c.numContainer = ? limit 1))";
		System.out.println(container);
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, container.getTipoMovimentacao());
			pst.setString(2, container.getDataInicio());
			pst.setString(3, container.getDataFim());
			pst.setString(4, container.getNumContainer());
			
			pst.execute();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	//CRUD READ
	
	public ArrayList<JavaBeans> listarContainers() {
		// criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> containers = new ArrayList<>();
		String read = "select c.numContainer, c.nomeCliente, c.tipo, c.statusAtual, c.categoria, m.tipoMovimentacao, m.horaInicio, m.horaFim from container c inner join movimentacoes m on c.id = m.id_container order by nomeCliente desc";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// variaveis de apoio que recebem os dados do banco
				String numContainer = rs.getString(1);
				String nomeCliente = rs.getString(2);				
				String tipo = rs.getString(3);
				String statusAtual = rs.getString(4);
				String categoria = rs.getString(5);
				String tipoMovimentacao = rs.getString(6);
				String dataInicio = rs.getString(7);
				String dataFim = rs.getString(8);
				// populando o arrayList
				containers.add(new JavaBeans(nomeCliente, numContainer, tipo, statusAtual,categoria, tipoMovimentacao, dataInicio, dataFim));
			}
			con.close();
			return containers;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
