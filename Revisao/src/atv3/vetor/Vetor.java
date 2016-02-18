package atv3.vetor;

import java.util.Comparator;
import java.lang.reflect.Array;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de Generics.
 * @author Adalberto
 *
 */
public class Vetor<T> {
	
	//O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;
	
	//O tamanho que o array interno terá
	private int tamanho;
	
	//Indice que guarda a proxima posição vazia do array interno
	private int indice;
	
	//O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;
	
	
	public Vetor(Class<T> c, int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = 0;
		
		@SuppressWarnings("unchecked")
        final T[] array = (T[]) Array.newInstance(c, tamanho);
        this.arrayInterno = array;
        // exemplo de instanciação: Vetor<String> vetor = new Vetor<String>(String.class, 10);
	}
	
	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	//Insere um objeto no vetor
	public void inserir(T o){
		
	}
	
	//Remove um objeto do vetor
	public T remover(){
		return null;
	}
	
	//Procura um elemento no vetor
	public T procurar(T o){
		return null;
	}
	
	//Diz se o vetor está vazio
	public boolean isVazio(){
		return false;
	}
	
	//Diz se o vetor está cheio
	public boolean isCheio(){
		return false;
	}
	
}