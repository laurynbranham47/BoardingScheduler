
public class TestClass {
	
	public static void main(String args[]) {
		checkIn();
		//testEnqueue();
		//test1Dequeue();
		//test2Dequeue();
		//shadowArrayTest();
	}
	
	public static boolean testEnqueue() {
		
		System.out.println("Enqueue");
		Passenger p1 = new Passenger("Josh", 15, "1A");
		Passenger p2 = new Passenger("Sara", 10, "2A", 1);
		Passenger p3 = new Passenger("Brandon", 5, "3A");
		Passenger p4 = new Passenger("Nikki", 15, "1B", 3);
		
		BoardingHeap heap = new BoardingHeap();
		heap.enqueue(p1);
		heap.enqueue(p2);
		heap.enqueue(p3);
		heap.enqueue(p4);
		
		System.out.println("SIZE: " + heap.getSize());
		
		heap.toString();
		
		return false;
		
	}
	
	public static boolean test1Dequeue() {
		
		System.out.println("Dequeue");
		Passenger p1 = new Passenger("Josh", 15, "1A");
		Passenger p2 = new Passenger("Sara", 10, "2A", 1);
		Passenger p3 = new Passenger("Brandon", 5, "3A");
		Passenger p4 = new Passenger("Nikki", 15, "1B", 3);
		
		BoardingHeap heap = new BoardingHeap();
		heap.enqueue(p1);
		heap.enqueue(p2);
		heap.enqueue(p3);
		heap.enqueue(p4);
		
		System.out.println("SIZE: " + heap.getSize());
		
		heap.dequeue();
		heap.dequeue();
		heap.dequeue();
		heap.dequeue();
		
		System.out.println("SIZE: " + heap.getSize());
		
		heap.toString();
		
		
		return false;
		
	}
	
public static boolean test2Dequeue() {
		
		System.out.println("Dequeue");
		Passenger p1 = new Passenger("Josh", 15, "1A");
		Passenger p2 = new Passenger("Sara", 10, "2A", 1);
		Passenger p3 = new Passenger("Brandon", 5, "3A");
		Passenger p4 = new Passenger("Nikki", 15, "1B", 3);
		
		BoardingHeap heap = new BoardingHeap();
		heap.enqueue(p1);
		heap.enqueue(p2);
		heap.enqueue(p3);
		heap.enqueue(p4);
		
		System.out.println("/////");
		heap.toString();
		
		System.out.println("SIZE: " + heap.getSize());
		
		System.out.println("Dequeued: " + heap.dequeue().getName());
		System.out.println("Dequeued: " + heap.dequeue().getName());
		
		System.out.println("SIZE: " + heap.getSize());
		
		heap.toString();
		
		return false;
		
	}

	public static void shadowArrayTest() {
		Passenger p1 = new Passenger("Josh", 15, "1A");
		Passenger p2 = new Passenger("Sara", 10, "2A", 1);
		Passenger p3 = new Passenger("Brandon", 5, "3A");
		Passenger p4 = new Passenger("Nikki", 15, "1B", 3);
		Passenger p5 = new Passenger("Kit", 15, "1A");
		Passenger p6 = new Passenger("David", 10, "2A", 1);
		Passenger p7 = new Passenger("Jason", 5, "3A");
		Passenger p8 = new Passenger("Keevan", 15, "1B", 3);
		Passenger p9 = new Passenger("Jeff", 15, "1A");
		Passenger p10 = new Passenger("Jake", 10, "2A", 1);
		Passenger p11 = new Passenger("Jamie", 5, "3A");
		Passenger p12 = new Passenger("Michelle", 15, "1B", 3);
		
		System.out.println("Shadow Array Test: Starting");
		
		BoardingHeap heap = new BoardingHeap();
		heap.enqueue(p1);
		heap.enqueue(p2);
		heap.enqueue(p3);
		heap.enqueue(p4);
		heap.enqueue(p5);
		heap.enqueue(p6);
		heap.enqueue(p7);
		heap.enqueue(p8);
		heap.enqueue(p9);
		heap.enqueue(p10);
		heap.enqueue(p11);
		heap.enqueue(p12);
		
		System.out.println("Shadow Array toString:");
		heap.toString();
		
		
		
		
	}
	
	public static boolean checkIn() {

		BoardingScheduler.checkIn("/Users/lauryn/eclipse-workspace/Boarding Scheduler/src/sample1.txt");
		
		return false;
		
	}
	
	/*
	 * Notes:
	 * 
	 * Questions:
	 * - Are we dequeuing right away or when boarding time starts?
	 * - How to access passengers in the calculate estimate method?
	 */
	
	
	
	
}
