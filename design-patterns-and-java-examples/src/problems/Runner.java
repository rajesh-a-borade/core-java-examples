package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		
		int unsorted_queue_capacity = 10;
		List<Integer> unsortedQueue = new ArrayList<Integer>();
		Producer tProducer = new Producer("Producer", unsortedQueue, unsorted_queue_capacity);
		tProducer.start();
		List<Integer> sortedQueue = new LinkedList<Integer>();
		Consumer consumer1 = new Consumer("Consumer1", unsortedQueue, sortedQueue);
		consumer1.start();
		Consumer consumer2 = new Consumer("Consumer2", unsortedQueue, sortedQueue);
		consumer2.start();
		FileWriterThread fwt = new FileWriterThread("FileWriter", sortedQueue);
		fwt.start();
		
		// ConcurrentHashMap<K, V>
		// Hashtable<K, V>
		
	}
}
