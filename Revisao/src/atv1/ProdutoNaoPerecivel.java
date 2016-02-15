package atv1;

public class ProdutoNaoPerecivel extends Produto {

	private String formaAcondicionamento;
	
	public ProdutoNaoPerecivel(int codigo, String nome, double preco,
						String descricao, String formaAcondicionamento) {
		super(codigo, nome, preco, descricao);
		this.formaAcondicionamento = formaAcondicionamento;
	}


}
