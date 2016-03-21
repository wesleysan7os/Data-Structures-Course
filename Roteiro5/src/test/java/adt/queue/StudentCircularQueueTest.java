package adt.queue;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentCircularQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;
	public Queue<Integer> queue4;

	@Before
	public void setUp() throws QueueOverflowException{
		queue1 = new CircularQueue<Integer>(6);
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);
		
		queue2 = new CircularQueue<Integer>(2);
		queue2.enqueue(1);
		queue2.enqueue(2);
		
		queue3 = new CircularQueue<Integer>(3);
		
		queue4 = new CircularQueue<Integer>(5);
	}
	
	//MÉTODOS DE TESTE
	@Test
	public void testHead() {
		try {
			Assert.assertTrue(queue1.head() == 1); 
			queue1.enqueue(4); 
			Assert.assertTrue(queue1.head() == 1); 
			queue1.dequeue(); 
			Assert.assertFalse(queue1.head() == 1); 

			queue2.dequeue();
			queue2.dequeue();
			Assert.assertTrue(queue2.head() == null); 
		} catch (Exception e) {
			Assert.fail("Teste failed.");
		}
	}

	@Test
	public void testIsEmpty() {
		try {
			Assert.assertTrue(queue3.isEmpty());

			queue3.enqueue(1); 
			Assert.assertFalse(queue3.isEmpty()); 

			Assert.assertFalse(queue1.isEmpty());
			Assert.assertFalse(queue2.isEmpty()); 

			queue2.dequeue(); 
			queue2.dequeue();
			Assert.assertTrue(queue2.isEmpty()); 
		} catch (Exception e) {
			Assert.fail("Test has failed.");
		}			
	}

	@Test
	public void testIsFull() {
		try {
			Assert.assertFalse(queue3.isFull());
			Assert.assertFalse(queue1.isFull());
			
			queue1.enqueue(4);
			queue1.enqueue(5);
			queue1.enqueue(6);
			Assert.assertTrue(queue1.isFull());
			
			Assert.assertTrue(queue2.isFull());
			
			queue2.dequeue();
			Assert.assertFalse(queue2.isFull());
		} catch (Exception e) {
			Assert.fail("Test has failed.");
		}
		
	}

	@Test
	public void testEnqueue() {
		try {
			queue3.enqueue(1);
			queue3.enqueue(2);
			queue3.enqueue(3);
			Assert.assertTrue(queue3.isFull());
		} catch (Exception e) {
			Assert.fail("Test has failed.");
		}
	}
	
	@Test
	public void testCircularEnqueue1() {
		try {
			
			queue4.enqueue(1);
			queue4.enqueue(2);
			queue4.enqueue(3);
			queue4.enqueue(4);
			queue4.enqueue(5);
			Assert.assertTrue(queue4.head() == 1);
			
			queue4.dequeue();
			Assert.assertTrue(queue4.head() == 2);

			queue4.dequeue();
			Assert.assertTrue(queue4.head() == 3);
			
			queue4.dequeue();
			Assert.assertTrue(queue4.head() == 4);
			
			queue4.dequeue();
			Assert.assertTrue(queue4.head() == 5);
			
			// neste momento, so ha um elemento na queue4, o numero cinco 
			
			// adiciono mais um elemento, o numero um
			queue4.enqueue(1);
			
			// verifico se o numero cinco ainda eh a cabeca da queue4
			Assert.assertTrue(queue4.head() == 5);
			
			// retiro o numero cinco
			queue4.dequeue();
			// verifico se o elemento 1 passou a ser o primeiro da queue4
			Assert.assertTrue(queue4.head() == 1);
			
		} catch (Exception e) {
			Assert.fail("Test has failed.");
		}
		
	}
	
	@Test
	public void testCircularEnqueue2()  {
		try {
			
			queue4.enqueue(1);
			queue4.enqueue(2);
			queue4.enqueue(3);
			queue4.enqueue(4);
			queue4.enqueue(5);
			
			queue4.dequeue();
			queue4.dequeue();
			queue4.dequeue();
			queue4.dequeue();
			// neste momento, so ha um elemento na queue4, o numero cinco, cabeca da queue4
			
			// adiciona mais elementos
			queue4.enqueue(1);
			queue4.enqueue(2);
			queue4.enqueue(3);
			queue4.enqueue(4);
			
			// verifica o numero cinco ainda eh a cabeca da queue4
			Assert.assertTrue(queue4.head() == 5);
			
		} catch (Exception e) {
			Assert.fail("Test has failed.");
		}
	}
	
	@Test(expected=QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue2.enqueue(3);
	}

	@Test
	public void testDequeue() {
		try {
			Assert.assertTrue(queue2.head().equals(1));
			
			queue2.dequeue();
			Assert.assertTrue(queue2.head().equals(2));
			
			queue2.dequeue();
			Assert.assertTrue(queue2.isEmpty());
		} catch (Exception e) {
			Assert.fail("Test has failed.");
		}
	}

	@Test 
	public void testCircularDequeue() throws Exception {
		queue4 = new CircularQueue<Integer>(5);
		queue4.enqueue(9);
		queue4.enqueue(8);
		queue4.enqueue(7);
		queue4.enqueue(6);
		queue4.enqueue(19);
		
		queue4.dequeue();
		queue4.dequeue();
		Assert.assertTrue(queue4.head() == 7);
		
		queue4.enqueue(17);	
		queue4.dequeue();
		queue4.dequeue();
		queue4.enqueue(5);
		Assert.assertTrue(queue4.head() == 19);
		Assert.assertTrue(queue4.dequeue() == 19);
		Assert.assertTrue(queue4.head() == 17);
		Assert.assertTrue(queue4.dequeue() == 17);
		Assert.assertTrue(queue4.dequeue() == 5);
		
		// now queue is empty
		
		queue4.enqueue(6);
		queue4.enqueue(19);
		
		// test if, after empty, head was not added by one (if was, it would be wrong)
		Assert.assertTrue(queue4.dequeue() == 6);
		Assert.assertTrue(queue4.dequeue() == 19);
	}
		
	@Test(expected=QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		queue3.dequeue();
	}

	@Test(expected=QueueUnderflowException.class)
	public void testCircularComErro() throws QueueUnderflowException, QueueOverflowException {
			
			queue4.enqueue(1);
			queue4.enqueue(2);
			queue4.enqueue(3);
			queue4.enqueue(4);
			queue4.enqueue(5);
			
			queue4.dequeue();
			queue4.dequeue();
			queue4.dequeue();
			queue4.dequeue();
			// neste momento, so ha um elemento na queue4, o numero cinco, cabeca da queue4
			
			// adiciona mais elementos
			queue4.enqueue(1);
			queue4.enqueue(2);
			queue4.enqueue(3);
			queue4.enqueue(4);
			
			// neste momento o numero cinco eh a cabeca da queue4
			
			// remove 5 elementos
			for (int i = 1; i <=  5; i++) {
				queue4.dequeue();
			}
			
			// a lista esta vazia, mas tenta retirar mais um elemento. 
			// esse paco deve lancar excecao
			queue4.dequeue();
			
	}
	
	public void testIllegalSizes() {
		try{
			new CircularQueue<Integer>(0);
			Assert.fail();
		}catch(Exception e){
			Assert.assertEquals("Size must be bigger than 0.", e.getMessage());
		}
		
		try{
			new CircularQueue<Integer>(-1);
			Assert.fail();
		}catch(Exception e){
			Assert.assertEquals("Size must be bigger than 0.", e.getMessage());
		}
	}
	
}