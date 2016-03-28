package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;
	
	public RecursiveSingleLinkedListImpl() {
		this.data = null;
		this.next = null;
	}
	
	@Override
	public boolean isEmpty() {
		if (this.data == null)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		int count = 0;
		if (this.data != null) {
			count = 1 + next.size();
		}
		return count;
		// testar se p uma lista vazia retorno eh zero
	}

	@Override
	public T search(T element) {
		if (element == null)
			return null;
		
		if (this.data == null) {
			return null;
		} else {
			if (data.equals(element))
				return element;
			else
				return next.search(element);
		}
		// testar busca de um elemento nulo
	}

	@Override
	public void insert(T element) {
		if (element != null) {		
			
			if (this.data == null) {
				this.data = element;
				this.next = new RecursiveDoubleLinkedListImpl<T>();
			} else {
				next.insert(element);
			}
			
		}
		// testar para quando a lista estiver vazia e formos add o primeiro elemento
		// testar se dps de add um, dá certo add outro
	}

	@Override
	public void remove(T element) {
		if (element == null || this.data == null)
			return;
		if (this.data.equals(element)) { 
			this.data = next.getData();
			this.next = next.getNext();
		} else {
			this.next.remove(element);
		}
		// testar remover qnd o elemento a ser removido eh o ultimo
		// testar remover prim elemento de uma lista size 2 (verificar se dps de remover o next eh == null)
	}
	
	@Override
	public T[] toArray(){
		T[] array = (T[]) new Object[size()];
		int firstIndex = 0;
		return toArray(array, firstIndex);
		// testar fazer um toArray, dps remover um elemento, fazer outro toArray e verificar se processa corretamente
	}
	
	private T[] toArray(T[] array, int current) {
		if (this.data != null) {
			array[current] = this.data;
			this.next.toArray(array, current + 1);
		}
		return array;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
