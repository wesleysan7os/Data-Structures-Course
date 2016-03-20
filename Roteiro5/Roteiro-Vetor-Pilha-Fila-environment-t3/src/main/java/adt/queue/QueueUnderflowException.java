package adt.queue;

public class QueueUnderflowException extends QueueException {

	public QueueUnderflowException() {
		super("Fila vazia");
	}

}
