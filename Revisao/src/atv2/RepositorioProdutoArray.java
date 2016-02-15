package atv2;

import java.util.ArrayList;

import atv1.*;

public class RepositorioProdutoArray {

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
	
	public boolean exist(int codigo) {
		if (procurarIndice(codigo) == -1) {
			return false;
		} else {
			return true;
		}
	}

	public void inserir(Produto produto) {
		produtos.add(produto);
	}
	
	public void atualizar(Produto produto) {
		// nao entendi o que fazer
	}
	
	public void remover(int codigo) throws Exception {
		int i = procurarIndice(codigo);
		if( i != -1 ){
			produtos.remove(i);
		} else {
			throw new Exception();
		}
	}
	
	public Produto procurar(int codigo) throws Exception {
		int i = procurarIndice(codigo);
		if( i != -1 ){
			return produtos.get(i);
		} else {
			throw new Exception();
		}
	}
	
}
