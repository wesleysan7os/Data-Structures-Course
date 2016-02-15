package atv2;
import java.util.ArrayList;
import atv1.*;

public interface RepositorioProdutos {

	//private ArrayList<Produto> produtos;
	
	public int procurarIndice(int codigo);
	public boolean exist(int codigo);
	public void inserir(Produto produto);		
	public void atualizar(Produto produto);		
	public void remover(int codigo) throws Exception;
	public Produto procurar(int codigo) throws Exception;
		
}
