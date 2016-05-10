package adt.splaytree;

import adt.avltree.AVLTreeImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

public class SplayTreeImpl<T extends Comparable<T>> extends AVLTreeImpl<T> implements
		SplayTree<T> {
	
	private void splay(BSTNode<T> node) {

		if (node.equals(root))
			return;
		
		if (node.getParent().equals( root )) {
			if (node.equals( node.getParent().getLeft() )) {
				rightRotation(root);
			} else {
				leftRotation(root);
			}
		} else if ((isRight(node)) && (isRight((BSTNode<T>) node.getParent()))) {
			leftRotation((BSTNode<T>) node.getParent().getParent());
			leftRotation((BSTNode<T>) node.getParent());
		} else if ((isLeft(node)) && (isLeft((BSTNode<T>) node.getParent()))) {
			rightRotation((BSTNode<T>) node.getParent().getParent());
			rightRotation((BSTNode<T>) node.getParent());
		} else {
			if ((isRight(node)) && (isLeft((BSTNode<T>) node.getParent()))) {
				leftRotation((BSTNode<T>) node.getParent());
				rightRotation((BSTNode<T>) node.getParent().getParent());
			} else {
				rightRotation((BSTNode<T>) node.getParent());
				leftRotation((BSTNode<T>) node.getParent().getParent());
			}
		}
	}

	private boolean isLeft(BSTNode<T> node) {
		return (node.equals( node.getParent().getLeft() ));
	}

	private boolean isRight(BSTNode<T> node) {
		return (node.equals( node.getParent().getRight() ));
	}

	@Override
	public void insert(T key) {
			insertRecursive(root, key);			
			splay( searchRecursive(root, key) );
	}

	private void insertRecursive(BTNode<T> node, T element) {
		if (node.isEmpty()) {
			
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());

			node.getLeft().setParent(node);
			node.getRight().setParent(node);
			
		} else {
			if (element.compareTo(node.getData()) < 0)
				insertRecursive(node.getLeft(), element);
			else
				insertRecursive(node.getRight(), element);
		}
	}
	
	@Override
	public BSTNode<T> search(T key) {
		
		if (key != null) {
		
			BSTNode<T> node = searchRecursive(root, key);
			
			if (!node.isEmpty()) {
				splay(node);
			} else {
				splay((BSTNode<T>) node.getParent());
			}
		}
			return searchRecursive(root, key);
	}
	
    protected BSTNode<T> searchRecursive(BSTNode<T> node, T key) {
        
    	BSTNode<T> result = node;
    	
        if (!node.isEmpty()) {
        
        	if (key.compareTo(node.getData()) == 0) {
        		result = node;
        	} else if (key.compareTo(node.getData()) < 0) {
        		result = searchRecursive((BSTNode<T>) node.getLeft(), key);
        	} else {
        		result = searchRecursive((BSTNode<T>) node.getRight(), key);
        	}
        	
        }
        return result;
    }
	
	@Override
	public void remove(T key) {
	
		BSTNode<T> node = searchRecursive(root, key);
		super.removeRecursive(node);

		if (root.isEmpty())
			return;
		
		if (node.isEmpty()) {
			splay((BSTNode<T>) node.getParent());
		} else if (!node.equals(root)) { 
			splay((BSTNode<T>) node.getParent());
		}
	}
}
