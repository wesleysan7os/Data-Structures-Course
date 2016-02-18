package atv2;

import atv1.Produto;

public interface RepositorioProdutos {

	boolean exist(int codigo);

	void inserir(Produto produto);

	void atualizar(Produto produto);

	void remover(int codigo) throws Exception;

	Produto procurar(int codigo) throws Exception;

}