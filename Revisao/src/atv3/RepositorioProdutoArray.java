package atv3;

import java.util.ArrayList;

import atv1.*;

public class RepositorioProdutoArray implements RepositorioProdutos<Produto> {

	private ArrayList<Produto> produtos;
	
	public RepositorioProdutoArray() {
		produtos = new ArrayList<Produto>();
	}
	
	private int procurarIndice(int codigo) {

		for (int i = 0; i < produtos.size(); i++) {
			Produto produto = produtos.get(i);
			if ( produto.getCodigo() == codigo ) {
				return i;
			}
		}
		return -1;
	}
	
	/* (non-Javadoc)
	 * @see atv2.RepositorioProdutos#exist(int)
	 */
	@Override
	public boolean exist(int codigo) {
		if (procurarIndice(codigo) == -1) {
			return false;
		} else {
			return true;
		}
	}

	/* (non-Javadoc)
	 * @see atv2.RepositorioProdutos#inserir(atv1.Produto)
	 */
	@Override
	public void inserir(Produto produto) {
		produtos.add(produto);
	}
	
	/* (non-Javadoc)
	 * @see atv2.RepositorioProdutos#atualizar(atv1.Produto)
	 */
	@Override
	public void atualizar(Produto produto) {
		// nao entendi o que fazer
	}
	
	/* (non-Javadoc)
	 * @see atv2.RepositorioProdutos#remover(int)
	 */
	@Override
	public void remover(int codigo) throws Exception {
		int i = procurarIndice(codigo);
		if( i != -1 ){
			produtos.remove(i);
		} else {
			throw new Exception();
		}
	}
	
	/* (non-Javadoc)
	 * @see atv2.RepositorioProdutos#procurar(int)
	 */
	@Override
	public Produto procurar(int codigo) throws Exception {
		int i = procurarIndice(codigo);
		if( i != -1 ){
			return produtos.get(i);
		} else {
			throw new Exception();
		}
	}
	
}
