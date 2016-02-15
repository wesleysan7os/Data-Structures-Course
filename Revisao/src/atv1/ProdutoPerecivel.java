package atv1;

public class ProdutoPerecivel extends Produto {

	private String dataValidade;
	
	public ProdutoPerecivel(int codigo, String nome, double preco,
							String descricao, String dataValidade) {
		super(codigo, nome, preco, descricao);
		this.dataValidade = dataValidade;
	}


	
}
