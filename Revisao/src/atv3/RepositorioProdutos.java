package atv3;

import atv1.Produto;

public interface RepositorioProdutos<E> {

	boolean exist(int codigo);

	void inserir(E objeto);

	void atualizar(E objeto);

	void remover(int codigo) throws Exception;

	Produto procurar(int codigo) throws Exception;

}