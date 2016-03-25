package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OtherDoubleLinkedTests {
	
	private DoubleLinkedList<Integer> lista1;
	private DoubleLinkedList<Integer> lista2;
	private DoubleLinkedList<Integer> lista3;
	
	@Before
	public void setUp() throws Exception {

		getImplementations();
		
		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		
		// Lista com 1 elemento.
		lista3.insert(1);
	}
	
	private void getImplementations(){
		//TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new DoubleLinkedListImpl<Integer>();
		lista2 = new DoubleLinkedListImpl<Integer>();
		lista3 = new DoubleLinkedListImpl<Integer>();;
	}

//	@Test
	public void testIsEmpty() {
		// Verifica se funciona com uma lista vazia
		Assert.assertTrue(lista2.isEmpty());
		// Verifica se funciona com uma lista não vazia
		Assert.assertFalse(lista1.isEmpty());
		Assert.assertFalse(lista3.isEmpty());
	}

	//@Test
	public void testSize() {
		// Verifica se o tamanho da lista vazia é 0
		Assert.assertTrue(lista2.size() == 0);	
		// Verifica se o tamanho da lista 1 é 3
		Assert.assertTrue(lista1.size() == 3);
		// Verifica se o tamanho da lista 3 é 1
		Assert.assertTrue(lista3.size() == 1);
	}

	//@Test
	public void testSearch() {
		// Procura um elemento na lista vazia
		Assert.assertTrue(lista2.search(1) == null);
		// Procura um elemento que esta na lista nao vazia
		Assert.assertTrue(lista1.search(2) == 2);
		// Procura um elemento que não esta na lista nao vazia
		Assert.assertTrue(lista1.search(5) == null);
		// Procura um elemento nulo na lista 1
		Assert.assertTrue(lista1.search(null) == null);
		// Procura o último elemento da lista 1
		Assert.assertTrue(lista1.search(1) == 1);
		// Procura o elemento da lista 3
		Assert.assertTrue(lista3.search(1) == 1);
	}

	//@Test
	public void testInsert() {
		// Insere um elemento na lista vazia
		lista2.insert(10);
		// Verfica se o tamanho da lista aumentou para 1
		Assert.assertTrue(lista2.size() == 1);
		// Insere um elemento na lista não vazia
		lista1.insert(10);
		// Verfica se o tamanho da lista aumentou para 4
		Assert.assertTrue(lista1.size() == 4);
		// Insere um elemento nulo na lista 1
		lista1.insert(null);
		// Verifica se o tamanho da lista continua o mesmo
		Assert.assertTrue(lista1.size() == 4);
		// Insere três elementos iguais na lista 3
		lista3.insert(5);
		lista3.insert(5);
		lista3.insert(5);
		// Verfica se o tamanho da lista aumentou para 4
		Assert.assertTrue(lista3.size() == 4);
	}

	//@Test
	public void testRemove() {
		// Remove o ultimo elemento da lista 1
		lista1.remove(1);
		// Verifica se o tamanho da lista diminuiu para 2
		Assert.assertTrue(lista1.size() == 2);
		// Verifica se retorna null quando procurar pelo elemento removido
		Assert.assertTrue(lista1.search(1) == null);
		// Tenta remover um item que não existe na lista 1
		lista1.remove(10);
		// Verifica se o tamanho da lista continua o mesmo
		Assert.assertTrue(lista1.size() == 2);
		// Tenta remover um elemento nulo
		lista1.remove(null);
		// Verifica se o tamanho da lista continua o mesmo
		Assert.assertTrue(lista1.size() == 2);
		// Tenta remover um elemento da lista vazia
		lista2.remove(2);
		// Tenta remover o head da lista 1
		lista1.remove(3);
		// Verifica se o tamanho da lista diminuiu para 1
		Assert.assertTrue(lista1.size() == 1);
		// Verifica se retorna null quando procurar pelo elemento removido
		Assert.assertTrue(lista1.search(3) == null);
		// Remove o elemento da lista 3
		lista3.remove(1);
		// Verifica se a lista está vazia
		Assert.assertTrue(lista3.isEmpty());	
	}

	//@Test
	public void testToArray() {
		// Verifica se retorna um array vazio para a lista vazia
		Assert.assertArrayEquals(new Integer[0], lista2.toArray());
		// Verifica se retorna o array certo para a lista 1
		Assert.assertArrayEquals(new Integer[]{3,2,1}, lista1.toArray());
		// Verifica se retorna o array certo para a lista 3
		Assert.assertArrayEquals(new Integer[]{1}, lista3.toArray());
	}
	
	// Métodos de DoubleLinkedList
	
	@Test
	public void testInsertFirst(){
		// Insere um elemento na lista vazia
		lista2.insertFirst(10);
		// Verfica se o tamanho da lista aumentou para 1
		Assert.assertTrue(lista2.size() == 1);
		// Insere um elemento na lista 1
		lista1.insertFirst(10);
		// Verfica se o tamanho da lista aumentou para 4
		Assert.assertTrue(lista1.size() == 4);
		// Tenta inserir um elemento nulo
		lista1.insertFirst(null);
		// Verfica se o tamanho da lista não aumentou
		Assert.assertTrue(lista1.size() == 4);
	}

	@Test
	public void testRemoveFirst(){
		// Tenta remover um elemento da lista vazia
		lista2.removeFirst();
		// Remove o único elemento da lista 3
		lista3.removeFirst();
		// Verifica se a lista está vazia
		Assert.assertTrue(lista3.isEmpty());
		// Remove um elemento da lista 1
		lista1.removeFirst();
		// Verifica se o tamanho da lista diminui para 2
		Assert.assertTrue(lista1.size() == 2);
		// Verifica se retorna null quando procurar pelo elemento removido
		Assert.assertTrue(lista1.search(3) == null);
	}
	
	@Test
	public void testRemoveLast(){
		// Tenta remover um elemento da lista vazia
		lista2.removeLast();
		// Remove o único elemento da lista 3
		lista3.removeLast();
		// Verifica se a lista está vazia
		Assert.assertTrue(lista3.isEmpty());
		// Remove um elemento da lista 1
		lista1.removeLast();
		// Verifica se o tamanho da lista diminui para 2
		Assert.assertTrue(lista1.size() == 2);
		// Verifica se retorna null quando procurar pelo elemento removido
		Assert.assertTrue(lista1.search(1) == null);
	}
}