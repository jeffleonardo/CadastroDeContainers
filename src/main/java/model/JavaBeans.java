package model;

public class JavaBeans {
	private String id;
	private String nomeCliente;
	private String numContainer;
	private String tipo;
	private String statusAtual;
	private String categoria;
	private String tipoMovimentacao;
	private String dataInicio;
	private String dataFim;

	public JavaBeans() {
		super();
	}
	
	@Override
	public String toString() {
		return "JavaBeans [id=" + id + ", nomeCliente=" + nomeCliente + ", numContainer=" + numContainer + ", tipo="
				+ tipo + ", statusAtual=" + statusAtual + ", categoria=" + categoria + ", tipoMovimentacao="
				+ tipoMovimentacao + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + "]";
	}
	public JavaBeans(String id, String nomeCliente, String numContainer, String tipo, String statusAtual, String categoria,
			String tipoMovimentacao, String dataInicio, String dataFim) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.numContainer = numContainer;
		this.tipo = tipo;
		this.statusAtual = statusAtual;
		this.categoria = categoria;
		this.tipoMovimentacao = tipoMovimentacao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNumContainer() {
		return numContainer;
	}

	public void setNumContainer(String numContainer) {
		this.numContainer = numContainer;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatusAtual() {
		return statusAtual;
	}

	public void setStatusAtual(String statusAtual) {
		this.statusAtual = statusAtual;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(String tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

}
