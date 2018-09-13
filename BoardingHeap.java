
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Boarding Scheduler
// Files:           ---
// Course:          CS 300 Spring 2018
//
// Author:          Lauryn Branham
// Email:           lbranham@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    ---
// Partner Email:   ---
// Lecturer's Name: ---
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.  If you received no outside help from either type of 
// source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This class's purpose is to act as a priority queue to keep track of where 
 * the passengers are in the checking in and boarding process. It adds people 
 * to the priority queue and also removes them.
 * 
 * @author lauryn
 *
 */
public class BoardingHeap {
	//You may store additional private fields as needed
	int size;
    private Passenger[] heap;
    private Passenger[] shadowHeap;
    private int copyIndex = 0;
    //array of passengers currently in the heap
    
 
    /**
     * Default constructor
     */
    public BoardingHeap() {  
    	heap = new Passenger[10];
    	shadowHeap = new Passenger[heap.length * 2];
    	heap[0] = null;
    	size = 0;
    }
    
    /**
     * This method's purpose is to add passenger's in the correct order
     * to the priority queue for boarding the plane.
     * 
     * @param p
     */
    public void enqueue(Passenger p) {
    	
    	if (size + 1 >= heap.length) { // not enough capacity
//			throw new IllegalStateException("Array is full");
			// array expansion using a shadow array
			heap = shadowHeap;
			shadowHeap = (Passenger[]) new Passenger[heap.length*2];
			//if the array needs to expand, this creates a shadow array to make room for more elements
			
			copyIndex = 0;
			
			heap[size + 1] = p; 
			shadowHeap[size + 1] = p;
			
		} else {
			heap[size + 1] = p; 
			shadowHeap[size + 1] = p;
			
			shadowHeap[copyIndex] = heap[copyIndex];
		}

		int i = size;
		Passenger temp;
		//swapping
		while(i > 0) {
			if(heap[i/2] != null && heap[size + 1] != null) {
				if(heap[size + 1].compareTo(heap[i / 2]) == 1){   //NOT I + 1... NEEDS TO BE PARENT
					temp = heap[i / 2];
					heap[i / 2] = heap[i + 1];
					heap[i + 1] = temp;
					break;
				}
			}
			i = i/2;
		}
		
		++copyIndex;
		++size;
    }
    
    /**
     * This method's purpose is the remove people from the priority queue
     * once they have boarded the plane.
     * 
     * @return the passenger that has boarded
     */
    public Passenger dequeue() { 
    	Passenger temp;
    	if(size > 0) {
    		temp = heap[1];
    		//shift all the elements
    		for(int i = 1; i <= size; ++i) {
    			heap[i] = heap[i+1];
    			shadowHeap[i] = heap[i+1];
    		}
    		heap[size] = null; // help garbage collection
    		shadowHeap[size] = null;
    		heap[0] = null;

    		--size;
    		
    		return temp;
    	}
    	else {
    		return null;
    	}
    }
    
    /**
     * This method's purpose is to check if the queue is empty or not.
     * @return true or false if empty or not
     */
    public boolean isEmpty() { 
    	return size == 0;
    }
    
    /**
     * This method's purpose is to access the size of the queue.
     * 
     * @return the size of the heap
     */
    public int getSize() {
    	return size;
    }
    
    /**
     * This method's purpose is to print out people in the heap
     * for testing purposes.
     */
    public String toString() {
    	
    	if(size > 0) {
	    	for(int i = 1; i <= size; ++i) {
	    		System.out.println(heap[i].getName() + ", " + heap[i].getSeat() + ", " + heap[i].getTime());
	    	}
    	}
    	else {
    		System.out.println("Empty");
    	}
    	
    	return "DONE";
    	
    }

}
