package adt.stack;

public class StackOverflowException extends StackException {

	public StackOverflowException() {
		super("Stack is full");
	}
	
}
