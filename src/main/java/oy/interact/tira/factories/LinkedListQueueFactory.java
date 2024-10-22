package oy.interact.tira.factories;

import oy.interact.tira.model.Coder;
import oy.interact.tira.student.LinkedListQueue;
import oy.interact.tira.util.QueueInterface;

// OPTIONAL for higher grade!
public class LinkedListQueueFactory {

	private LinkedListQueueFactory() {
		// empty
	}

	public static QueueInterface<Integer> createIntegerQueue() {
		return new LinkedListQueue<>();
	}

	public static QueueInterface<Integer> createIntegerQueue(int capacity) {
		return new LinkedListQueue<>();
	}

	public static QueueInterface<String> createStringQueue() {
		return new LinkedListQueue<>();
	}

	public static QueueInterface<String> createStringQueue(int capacity) {
		return new LinkedListQueue<>();
	}

	public static QueueInterface<Coder> createCoderQueue() {
		return new LinkedListQueue<>();
	}
}
