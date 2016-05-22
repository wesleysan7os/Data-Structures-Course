package adt.rbtree;

import java.util.ArrayList;
import java.util.List;

import adt.avltree.AVLTreeImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;
import adt.rbtree.RBNode.Colour;

public class RBTreeImpl<T extends Comparable<T>> extends AVLTreeImpl<T> 
	implements RBTree<T> {

	int i;
	
	public RBTreeImpl() {
		this.root = new RBNode<T>();
	}
	
	protected int blackHeight(){
		return blackHeight((RBNode<T>) root);
	}
	
	protected int blackHeight(RBNode<T> node) {
		
		if (node.isEmpty()) {
			return 0;
		} else {
				if (node.getColour() == Colour.BLACK)
					return 1 + Math.max(blackHeight((RBNode<T>) node.getLeft()),
							    blackHeight((RBNode<T>) node.getRight()));
				else
					return Math.max(blackHeight((RBNode<T>) node.getLeft()),
							blackHeight((RBNode<T>) node.getRight()));
		}
	}

	protected boolean verifyProperties(){
		boolean resp = verifyNodesColour()
						&& verifyNILNodeColour()
						&& verifyRootColour()
						&& verifyChildrenOfRedNodes()
						&& verifyBlackHeight();
		
		return resp;
	}
	
	/**
	 * The colour of each node of a RB tree is black or red. This is guaranteed by the type Colour.
	 */
	private boolean verifyNodesColour(){
		return true; //already implemented
	}

	/**
	 * The colour of the root must be black.
	 */
	private boolean verifyRootColour(){
		return ((RBNode<T>)root).getColour() == Colour.BLACK; //already implemented
	}
	
	/**
	 * This is guaranteed by the constructor.
	 */
	private boolean verifyNILNodeColour(){
		return true; //already implemented
	}
	
	/**
	 * Verifies the property for all RED nodes: the children of a red node must be BLACK.
	 */
	private boolean verifyChildrenOfRedNodes(){
		boolean answer = true;
		
		RBNode<T>[] array = extendedPreOrder();
		
		for (int i = 0; i < array.length; i++) {
			
			if (array[i].getColour() == Colour.RED) {
				
				if (array[i].getLeft() != null
				&& ((RBNode<T>) array[i].getLeft()).getColour() == Colour.RED ) {
					answer = false;
				}
				
				if (array[i].getRight() != null
				&& ((RBNode<T>) array[i].getRight()).getColour() == Colour.RED ) {
					answer = false;
				}
				
			}
		} // end for
		
		return answer;
	}
	
	/**
	 * Verifies the black-height property from the root. The method blackHeight returns an exception if the black heights are different.  
	 */
	private boolean verifyBlackHeight() {
		if (isEmpty())
			return true;
		
		return ( blackHeight((RBNode<T>) root.getLeft()) == blackHeight((RBNode<T>) root.getRight()) );
	}
	
	@Override
	public void insert(T value) {
		if (value!= null && isEmpty()) {
			root.setData(value);
			root.setLeft(new RBNode<T>());
			root.setRight(new RBNode<T>());
			
			root.getLeft().setParent(root);
			root.getRight().setParent(root);
			
			root.setColour(Colour.BLACK);
		} else if (value.compareTo(root.getData()) < 0) {
			insert(value, (RBNode<T>) root.getLeft());
		} else if (value.compareTo(root.getData()) > 0) {
			insert(value, (RBNode<T>) root.getRight());
		}
	}
	
	private void insert(T value, RBNode<T> node) {
		if (node.isEmpty()) {
			node.setData(value);
			node.setColour(Colour.RED);

			node.setLeft(new RBNode<T>());
			node.setRight(new RBNode<T>());
			
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
			
			fixUpCase1(node);
			
		} else {
			if (value.compareTo(node.getData()) < 0)
				insert(value, (RBNode<T>) node.getLeft());
			else if (value.compareTo(node.getData()) > 0) 
				insert(value, (RBNode<T>) node.getRight());
		}
	}
	
	@Override
	public RBNode<T>[] extendedPreOrder() {
		i = 0;
		RBNode<T>[] array = new RBNode[this.size()];
		if(size() > 0){
			i = 0;
			extendedPreOrder((RBNode<T>) root, array);
		}
		return array;
	}
	
	private void extendedPreOrder(RBNode<T> no, RBNode<T>[] array){
		if(!no.isEmpty()){
			array[i++] = ((RBNode<T>)no);
			extendedPreOrder((RBNode<T>)no.getLeft(), array);
			extendedPreOrder((RBNode<T>)no.getRight(), array);
		}
	}
	
	//FIXUP methods
	protected void fixUpCase1(RBNode<T> node){
		if (node.equals(root))
			node.setColour(Colour.BLACK);
		else
			fixUpCase2(node);
	}
	
	protected void fixUpCase2(RBNode<T> node){
		if ( ((RBNode<T>) node.getParent()).getColour() != Colour.BLACK)
			fixUpCase3(node);
	}
	
	protected void fixUpCase3(RBNode<T> node){
		RBNode<T> uncle = getUncle(node);
		
		if (uncle != null
			&& uncle.getColour() == Colour.RED) {
			
			uncle.setColour(Colour.BLACK);
			((RBNode<T>) node.getParent()).setColour(Colour.BLACK);			
			((RBNode<T>) node.getParent().getParent()).setColour(Colour.RED);
			
			fixUpCase1( ((RBNode<T>) node.getParent().getParent()) );
		
		} else {
			fixUpCase4(node);
		}
	}
	
	protected void fixUpCase4(RBNode<T> node){
		RBNode<T> next = node;
		
		if (isLeftChild(node)
		    && isRightChild((RBNode<T>) node.getParent())) {
			
			rightRotation((RBNode<T>) node.getParent());
			next = (RBNode<T>) node.getRight();
			
		} else
		
		if (isRightChild(node)
		    && isLeftChild((RBNode<T>) node.getParent()) ) {
			
			leftRotation((RBNode<T>) node.getParent());
			next = (RBNode<T>) node.getLeft();
		}
		
		fixUpCase5(next);
	}
	
	protected void fixUpCase5(RBNode<T> node){

		((RBNode<T>) node.getParent()).setColour( Colour.BLACK );
		((RBNode<T>) node.getParent().getParent()).setColour( Colour.RED );
		
		if (node.getParent().getLeft().equals(node))
			rightRotation((RBNode<T>) node.getParent().getParent());
		else
			leftRotation((RBNode<T>) node.getParent().getParent());
		
	}
	
	private RBNode<T> getUncle(RBNode<T> node) {
		if (node.getParent().getParent().getLeft().equals(node.getParent()))
			return (RBNode<T>) node.getParent().getParent().getRight();

		return (RBNode<T>) node.getParent().getParent().getLeft();
	}
	
	private boolean isLeftChild(RBNode<T> node) {
		return (node.equals( node.getParent().getLeft() ));
	}

	private boolean isRightChild(RBNode<T> node) {
		return (node.equals( node.getParent().getRight() ));
	}
	
}
