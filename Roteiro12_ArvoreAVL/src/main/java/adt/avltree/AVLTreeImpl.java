package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

public class AVLTreeImpl<T extends Comparable<T>> 
    extends BSTImpl<T> implements AVLTree<T> {

	//TODO Do not forget: you must override the methods insert and remove conveniently.

	@Override
	public void insert(T element) {
		if (isEmpty() && element != null) {
			root.setData(element);
			root.setLeft(new BSTNode<T>());
			root.setRight(new BSTNode<T>());
			
			BSTNode<T> nil = new BSTNode<T>(); // binding root to a parent
			root.setParent(nil);			   // to avoid nullPointer
			nil.setLeft(root);				   // when rebalance after insert
			nil.setRight(root);				   // children of root 
			
			root.getLeft().setParent(root);
			root.getRight().setParent(root);
		} else if (element != null) {
			insertRecursive(root, root.getParent(), element);
		}
	}
	
	private void insertRecursive(BTNode<T> node, BTNode<T> parent, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.setParent(parent);
		} else {
			if (element.compareTo(node.getData()) < 0)
				insertRecursive(node.getLeft(), node, element);
			else if (element.compareTo(node.getData()) > 0)
				insertRecursive(node.getRight(), node, element);			
			
			rebalance( (BSTNode<T>) node);
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> toRemove = search(element);
			removeRecursive(toRemove);
		}
	}

	private void removeRecursive(BSTNode<T>  toRemove) {
		
		if (toRemove == null || toRemove.isEmpty())
			return;
		
		// node is leave
		if (toRemove.getLeft().isEmpty() && toRemove.getRight().isEmpty()) {
			becomeNil(toRemove);
			rebalanceUp(toRemove);
			
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
			
				rebalanceUp(toRemove);
				
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
	
	//AUXILIARY
	protected int calculateBalance(BTNode<T> node){
		if (node == null)
			return 0;
		
		return height(node.getRight()) - height(node.getLeft());
	}
	
	public int height() {
		return getHeight(getRoot());
	}
	
	protected int getHeight(BTNode<T> node) {
		if (node.isEmpty())
			return -1;
		else
			return 1 + Math.max(getHeight(node.getLeft()),
								getHeight(node.getRight()));
	}
	
	//AUXILIARY
	protected void rebalance(BSTNode<T> node){

		if (isBalanced(node))
			return;
		
		int balance = calculateBalance(node);
		
		if (balance > 1) {
			if(calculateBalance(node.getRight()) < 0)
				doubleLeftRotation(node);
			else
				leftRotation(node);
		} else
			
		if (balance < -1) {
			if(calculateBalance(node.getLeft()) > 0)
				doubleRightRotation(node);
			else
				rightRotation(node);
		}
		
	}
	
	//AUXILIARY
	protected void rebalanceUp(BSTNode<T> node){
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		while (parent != null) {
			rebalance((BSTNode<T>) parent);
			parent = (BSTNode<T>) parent.getParent();
		}
	}
	
	// FOR MY OWN TESTS
	public boolean isRightPending(BTNode<T> node) {
		return (calculateBalance((BSTNode<T>) node) >= 1);
	}
	
	// FOR MY OWN TESTS
	public boolean isLeftPending(BTNode<T> node) {
		return (calculateBalance((BSTNode<T>) node) <= -1);
	}	
	
	protected boolean isBalanced(BTNode<T> node) {
		int balance = calculateBalance((BSTNode<T>) node);
		return Math.abs(balance) <= 1;
	}
	
	//AUXILIARY
	protected void leftRotation(BSTNode<T> node){
		BTNode<T> pivot = node.getRight();
		
		node.setRight(pivot.getLeft());
		pivot.getLeft().setParent(node);
		
		pivot.setLeft(node);
		
		pivot.setParent(node.getParent());
		node.setParent(pivot);
		
		if(node == root) {
			root = (BSTNode<T>) pivot;
		} else {
			if(pivot.getParent().getLeft() == node)
				pivot.getParent().setLeft(pivot);
			else
				pivot.getParent().setRight(pivot);
		}
	}
	
	//AUXILIARY
	protected void rightRotation(BSTNode<T> node){
		BTNode<T> pivot = node.getLeft();
		
		node.setLeft(pivot.getRight());
		pivot.getRight().setParent(node);
		
		pivot.setRight(node);
		
		pivot.setParent(node.getParent());
		node.setParent(pivot);
		
		if(node == root) {
			root = (BSTNode<T>) pivot;
		} else {
			if(pivot.getParent().getLeft() == node)
				pivot.getParent().setLeft(pivot);
			else
				pivot.getParent().setRight(pivot);
		}
	}
	
	protected void doubleLeftRotation(BSTNode<T> node) {
		rightRotation((BSTNode<T>) node.getRight());
		leftRotation(node);
	}
	
	protected void doubleRightRotation(BSTNode<T> node) {
		leftRotation((BSTNode<T>) node.getLeft());
		rightRotation(node);
	}
	
	protected void becomeNil(BSTNode<T> node){
		node.setData(null);
		node.setLeft(null);
		node.setRight(null);
	}
	
}
