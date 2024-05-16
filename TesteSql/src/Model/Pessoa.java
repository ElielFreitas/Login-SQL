package Model;

public class Pessoa {
	private String nome;
	private int senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", senha=" + senha + "]";
	}
	
	
	
	
}
