package adt.avltree;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.avltree.AVLTree;
import adt.avltree.AVLTreeImpl;
import adt.bst.BSTNode;

public class Teste1 {
	
	private AVLTreeImpl<Integer> avl;
	
	@Before
	public void setUp() {
		avl = new AVLTreeImpl<Integer>();
	}

	@Test
	public void testLeftRotation_1() {
		
		assertEquals(-1, avl.height());
		
		avl.insert(5);
		assertEquals(0, avl.height());
		
		avl.insert(10);
		assertEquals((Integer) 5, avl.getRoot().getData());
		//assertTrue(avl.isRightPending(avl.getRoot()));
		
		avl.insert(15);
		BSTNode<Integer> aux = avl.search(5);
		assertEquals((Integer) 10, aux.getParent().getData());
		
		assertEquals((Integer) 10, avl.getRoot().getData());
		assertEquals((Integer) 15, avl.getRoot().getRight().getData());
		assertEquals((Integer) 5, avl.getRoot().getLeft().getData());
		
	}
	
	@Test
	public void testLeftRotation_2() {
		
		avl.insert(5);
		avl.insert(10);
		avl.insert(15);
		
		// 5 root==10 15
		
		avl.insert(30);
		
		assertTrue(avl.isRightPending(avl.getRoot()));
		assertEquals((Integer) 10, avl.getRoot().getData());
		assertEquals((Integer) 5, avl.getRoot().getLeft().getData());		
		assertEquals((Integer) 15, avl.getRoot().getRight().getData());
		assertEquals((Integer) 30, avl.getRoot().getRight().getRight().getData());
	}

	@Test
	public void testRightRotation_1() {
		
		avl.insert(3);
		avl.insert(2);
		avl.insert(1);
		
		assertEquals((Integer) 2, avl.getRoot().getData());
		assertEquals((Integer) 1, avl.getRoot().getLeft().getData());
		assertEquals((Integer) 3, avl.getRoot().getRight().getData());
		
		avl.insert(0);
		
		assertTrue(avl.isBalanced(avl.getRoot()));
		assertTrue(avl.isLeftPending(avl.getRoot()));
		
		assertEquals((Integer) 0, avl.getRoot().getLeft().getLeft().getData());
		
	}
	
	@Test
	public void testDoubleLeftPending_1() {
		
		avl.insert(5);
		avl.insert(10);
		avl.insert(15);
		avl.insert(30);
		
		// 5 root=10 15 30
		
		avl.insert(20);
				
		assertTrue(avl.isRightPending(avl.getRoot()));
		assertEquals((Integer) 10, avl.getRoot().getData());
		assertEquals((Integer) 5, avl.getRoot().getLeft().getData());		
		assertEquals((Integer) 20, avl.getRoot().getRight().getData());
		
		BSTNode<Integer> aux = avl.search(20);
		assertEquals((Integer) 30, aux.getRight().getData());
		assertEquals((Integer) 15, aux.getLeft().getData());
	}

	@Test
	public void testDoubleRightPending_1() {
		avl.insert(5);
		avl.insert(10);
		avl.insert(30);
		avl.insert(15);
		
		// 5 root=10 30 15
		
		avl.insert(20);
		
		assertTrue(avl.isRightPending(avl.getRoot()));
		assertEquals((Integer) 10, avl.getRoot().getData());
		assertEquals((Integer) 5, avl.getRoot().getLeft().getData());		
		assertEquals((Integer) 20, avl.getRoot().getRight().getData());
		
		BSTNode<Integer> aux = avl.search(20);
		assertEquals((Integer) 30, aux.getRight().getData());
		assertEquals((Integer) 15, aux.getLeft().getData());
		
	}

}
