package adt.queue;

public class QueueOverflowException extends QueueException {

	public QueueOverflowException() {
		super("Fila cheia");
	}

}
