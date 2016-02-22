package atv3.vetor;

import java.util.Collections;
import java.util.Comparator;
import java.lang.reflect.Array;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de Generics.
 * @author Adalberto
 *
 */

public class Vetor<T extends Comparable> {
	
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
		this.arrayInterno = (T[]) new Comparable[tamanho];
		
		//this.arrayInterno = (T[]) new Object[tamanho];
		// Outro modo de instanciar a array genérica
		// @SuppressWarnings("unchecked")
        //final T[] array = (T[]) Array.newInstance(c, tamanho);
        //this.arrayInterno = array;
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
		int i = 0;
		while (i < this.tamanho) {
			if (arrayInterno[i] == null) {
				this.arrayInterno[i] = o;
				i = this.tamanho;
			} else {
				i = i + 1;
			}
		}
	}
	
	//Remove um objeto do vetor
	public T remover(int i){
		
		T o = this.arrayInterno[i];
		T[] helper = (T[]) new Object[this.tamanho];
		this.tamanho = this.tamanho - 1;
		
		for (int j = 0; j < i ; j++) {
			helper[j] = this.arrayInterno[j];
		}
		
		for (int j = i; j < this.tamanho; j++) {
			helper[j] = this.arrayInterno[j+1];
		}
		
		this.arrayInterno = helper;
		
		return o;
	}	

	//Procura um elemento no vetor
	public T procurar(T o) {
		
		int i = 0;
		int j = 0;
		
		while(i < this.tamanho) {
			if (this.arrayInterno[i].equals(o)) {
				j = i;
				i = this.tamanho;
			} 
		} // fecha while
		return this.arrayInterno[j];
	}
	
	//Diz se o vetor está vazio
	public boolean isVazio(){
		
		if (this.arrayInterno[0] == null) {
			return true;
		} else {
			return false;
		}	
	}
	
	//Diz se o vetor está cheio
	public boolean isCheio() {
		if (this.arrayInterno[ arrayInterno.length - 1 ] != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		Vetor v = new Vetor(Integer.class, 2);
		if (v.isVazio() == true) { System.out.println("Esta vazio"); }
		v.inserir(1);
		v.inserir(2);
		if (v.isCheio() == true) { System.out.println("Esta cheio"); }
		v.remover(0); // remove 1
		v.remover(0); // remove 2
		if (v.isVazio() == true) { System.out.println("Esta vazio"); }
	}

	public T maximo() {
		T max = this.arrayInterno[0];
		for (T t : arrayInterno) {
			if (t.compareTo(max) == 1) {
				max = t;
			}
		}
		return max;
	}
	
	public T minimo() {
		T min = this.arrayInterno[0];
		for (T t : arrayInterno) {
			if (t.compareTo(min) == 1) {
				min = t;
			}
		}
		return min;
	}
	
}
