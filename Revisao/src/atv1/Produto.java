package atv1;

public class Produto {

	private int codigo;
	private String nome;
	private double preco;
	private String descricao;
	
	public Produto(int codigo, String nome, double preco, String descricao) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}
	
	public int getCodigo(){
		return this.codigo;
	}
}
