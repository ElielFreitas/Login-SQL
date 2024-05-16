package Model;

public class Produto {
	
	private int idProduto;
	private String nome;
	private double preco;

	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Pessoa [idProduto=" + idProduto + ", nome=" + nome + ", preco=" + preco + "]";
	}
	
	
}
