package adt.bst;

import java.util.ArrayList;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected  BSTNode<T> root;
	
	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot(){
		return this.root;
	}
	
	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	// what is the height for an unitary tree? 0?
	@Override
	public int height() {
		if (isEmpty())
			return -1;
		else
			return heightRecursive(root);
		
		// testar para arvore unitaria
	}

	private int heightRecursive(BTNode<T> btNode) {
		if (btNode.isEmpty()) {
			return -1;
		} else {
			int heightLeft = heightRecursive(btNode.getLeft());
			int heightRight = heightRecursive(btNode.getRight());
			
			if (heightLeft > heightRight)
				return 1 + heightLeft;
			else 
				return 1 + heightRight;
		}
	}
	
	@Override
	public BSTNode<T> search(T element) {
		if (element != null) 
			return searchRecursive(root, element);
		else
			return new BSTNode<T>();
		
		// testar procurar null;
	}
	
	private BSTNode<T> searchRecursive(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			return new BSTNode<T>();
		} else if ((element.compareTo(node.getData()) == 0)) {
			return node;
		} else if (element.compareTo(node.getData()) < 0) {
			return searchRecursive( (BSTNode<T>) node.getLeft(), element);
		} else {
			return searchRecursive( (BSTNode<T>) node.getRight(), element);
		}
	}

	// what about null element?
	@Override
	public void insert(T element) {
		if (isEmpty() && element != null) {
			root.setData(element);
			root.setLeft(new BSTNode<T>());
			root.setRight(new BSTNode<T>());
			
			root.getLeft().setParent(root);
			root.getRight().setParent(root);
		} else if (element != null) {
			insertRecursive(root, root, element);
		}
		// testar: inserir em vazio; inserir null; testar pais de left e right quando vazio; testar pais em outras insercoes;
	}
	
	// im importing adt.bt.BTNode; will it get any error?
	private void insertRecursive(BTNode<T> node, BTNode<T> parent, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.setParent(parent);
		} else {
			if (element.compareTo(node.getData()) < 0)
				insertRecursive(node.getLeft(), node, element);
			else
				insertRecursive(node.getRight(), node, element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		if (isEmpty())
			return null; // does it make sense return null when tree is empty?
		else
			return maximumRecursive(root);
	}
	
	private BSTNode<T> maximumRecursive(BTNode<T> node) {
		if (node.getRight().isEmpty())
			return (BSTNode<T>) node;
		else
			return maximumRecursive(node.getRight());
	}

	@Override
	public BSTNode<T> minimum() {
		if (isEmpty())
			return null; // does it make sense return null when tree is empty?
		else
			return (BSTNode<T>) minimumRecursive(root);
	}
	
	private BTNode<T> minimumRecursive(BTNode<T> node) {
		if (node.getLeft().isEmpty())
			return node;
		else
			return minimumRecursive(node.getLeft());
	}

	// if there is not sucessor, return null or nil?
	@Override
	public BSTNode<T> sucessor(T element) {
		if (isEmpty())
			return null;
		
		BSTNode<T> node = search(element);
		if (node == null || node.isEmpty())
			return null;
		
		if (!node.getRight().isEmpty()) {
			return (BSTNode<T>) minimumRecursive(node.getRight());
		} else {
			return sucessorRecursive(node, element);
		}
	}

	private BSTNode<T> sucessorRecursive(BSTNode<T> node, T value) {
		// if tree is unitary and root has no right child, return root or nil?
		if (node.getParent().isEmpty()) {
			return null;
		// if node has parent whose data is bigger than the value whose sucessor we want to find
		// case base: we found sucessor
		} else if (!node.getParent().isEmpty()
				&& node.getParent().getData().compareTo(value) > 0 ) {
			return (BSTNode<T>) node.getParent();
		} else {
			return sucessorRecursive((BSTNode<T>) node.getParent(), value);
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		if (isEmpty())
			return null;
		
		BSTNode<T> node = search(element);
		if (node == null || node.isEmpty())
			return null;
		
		if (!node.getLeft().isEmpty()) {
			return (BSTNode<T>) maximumRecursive(node.getLeft());
		} else {
			return predecessorRecursive(node, element);
		}
	}

	private BSTNode<T> predecessorRecursive(BSTNode<T> node, T value) {
		if (node.getParent().isEmpty()) {
			return null;
		} else if (!node.getParent().isEmpty()
				&& node.getParent().getData().compareTo(value) < 0 ) {
			return (BSTNode<T>) node.getParent();
		} else {
			return predecessorRecursive((BSTNode<T>) node.getParent(), value);
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> toRemove = search(element);
			removeRecursive(toRemove);
		}
		
		// testar quando toRemove for igual ao root (teste para quando root tem dois filhos, tem filho so a esq, tem filho so a direita. 
	}

	private void removeRecursive(BSTNode<T>  node) {
	BSTNode<T> toRemove = node;
		
		if (toRemove == null || toRemove.isEmpty())
			return;
		
		// node is leave
		if (toRemove.getLeft().isEmpty() && toRemove.getRight().isEmpty()) {
			becomeNil(toRemove);
			
		// node has one child
		} else if (toRemove.getLeft().isEmpty() || toRemove.getRight().isEmpty()) {
						
			if (!toRemove.equals(root)) {
				
				// node is left child
				if (toRemove.getParent().getLeft().equals(toRemove)) {
					
					if (!toRemove.getLeft().isEmpty()) {
						// node.left is left child of node parent
						toRemove.getParent().setLeft( toRemove.getLeft() );
						toRemove.getLeft().setParent(toRemove.getParent());

					} else {
						// node.right is left child of node parent
						toRemove.getParent().setLeft( toRemove.getRight() );
						toRemove.getRight().setParent(toRemove.getParent());
					}
					
				} else { // node is right child
					
					if (!toRemove.getLeft().isEmpty()) {
						// node.left is right child of node's parent
						toRemove.getParent().setRight( toRemove.getLeft() );
						toRemove.getLeft().setParent(toRemove.getParent());
					} else {
						// node.right is right child of node's parent
						toRemove.getParent().setRight( toRemove.getRight() );
						toRemove.getRight().setParent(toRemove.getParent());
					}
				}
			
			} else { // toRemove equals to root 
				if (!root.getRight().isEmpty()){
					root = (BSTNode<T>) root.getRight();
					root.setParent(null);
				} else {
					root = (BSTNode<T>) root.getLeft();
					root.setParent(null);
				}
			}
			
		// 	recursive step
		} else {
			BSTNode<T> sucessor = sucessor(toRemove.getData());
			T sucessorData = sucessor.getData();
			removeRecursive(sucessor);
			toRemove.setData( sucessorData );
		}
			
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> array = new ArrayList<T>();
		Comparable<T>[] a = new Comparable[size()];
		preOrderRecursive(root, array);
		return (T[]) array.toArray(a);
	}

	private void preOrderRecursive(BTNode<T> node, ArrayList<T> array) {
		if (!node.isEmpty()){
			visitNode(node, array);
			preOrderRecursive(node.getLeft(), array);
			preOrderRecursive(node.getRight(), array);
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> array = new ArrayList<T>();
		Comparable<T>[] a = new Comparable[size()];
		orderRecursive(root, array);
		System.out.println(array.toString());
		return (T[]) array.toArray(a);
	}

	private void orderRecursive(BTNode<T> node, ArrayList<T> array) {
		if (!node.isEmpty()){
			orderRecursive(node.getLeft(), array);
			visitNode(node, array);
			orderRecursive(node.getRight(), array);
		}		
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> array = new ArrayList<T>();
		Comparable<T>[] a = new Comparable[size()];
		postOrderRecursive(root, array);
		return (T[]) array.toArray(a);
	}

	private void postOrderRecursive(BTNode<T> node, ArrayList<T> array) {
		if (!node.isEmpty()){
			visitNode(node, array);
			postOrderRecursive(node.getLeft(), array);
			postOrderRecursive(node.getRight(), array);
		}			
	}

	private void visitNode(BTNode<T> node, ArrayList<T> array) {
		array.add(node.getData());
	}
	
	/**
	 * This method is already implemented using recursion. You must understand how it work and 
	 * use similar idea with the other methods. 
	 */
	@Override
	public int size() {
		return size(root);
	}
	
	private int size(BSTNode<T> node){
		int result = 0;
		//base case means doing nothing (return 0)
		if(!node.isEmpty()){ //indusctive case
			result = 1 + size((BSTNode<T>)node.getLeft()) + size((BSTNode<T>)node.getRight());
		}
		return result;
	}

	private void becomeNil(BSTNode<T> node){
		node.setData(null);
		node.setLeft(null);
		node.setRight(null);
	}
}
