
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
 * 
 * This class's purpose is to store the data on each
 * Passenger who checks in and boards the flight.
 * 
 * @author lauryn
 *
 */
public class Passenger implements Comparable<Passenger> {
	//private variables needed to store data
	private int time; //time the passenger should board
	private int preferredBoarding; //if the passenger has preferred boarding
	private int doneTimeEstimate; //what time the passenger will be done boarding the flight
	private String name = ""; //name of the passenger
	private String seat = ""; //seat the passenger is assigned
	
	/**
	 * First constructor
	 * @param name
	 * @param time
	 * @param seat
	 */
	public Passenger(String name, int time, String seat) {
		this.time = time;
		this.name = name;
		this.seat = seat;
		preferredBoarding = 0;
	}
	
	/**
	 * Second constructor 
	 * @param name
	 * @param time
	 * @param seat
	 * @param preferredBoarding
	 */
    public Passenger(String name, int time, String seat, int preferredBoarding) {
    	this.time = time;
		this.name = name;
		this.seat = seat;
    	this.preferredBoarding = preferredBoarding;
    }
 
    /**
     * This method's purpose is to set the approximate time the
     * passenger will be done boarding the flight.
     * 
     * @param estimate
     */
    public void setDoneTimeEstimate(int estimate) {
    	this.doneTimeEstimate = estimate;
    }
	
    /**
     * This method compares one passenger to another to see
     * which has highest boarding priority.
     * 
     * @param A passenger to compare to
     */
	@Override
	public int compareTo(Passenger o) {
		//check for order (priority) when enqueuing/dequeuing
		//1 = higher, 0 = lower
		if(o.preferredBoarding < this.preferredBoarding) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * This method is a getter method for the time.
	 * @return
	 */
	public int getTime() {
		return time;
	}
	
	/**
	 * This method is a setter method for the time.
	 * @return
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * This method is a getter method for the name.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method is a getter method for the seat.
	 * @return
	 */
	public String getSeat() {
		return seat;
	}
	
	/**
	 * This method is a getter method for the estimated time.
	 * @return
	 */
	public int getEstimate() {
		return doneTimeEstimate;
	}
}
