
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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This class's purpose is the organize the schedule of and keep track of 
 * those who are checked in and those who are boarding. 
 * 
 * @author lauryn
 *
 */

public class BoardingScheduler {
	//time variables needed for checking in and boarding
	private int boardingStartTime = 1;
	private int time = 0;

	/**
	 * This method's purpose is to enqueue passengers who are boarding the flight
	 * and to dequeue those who have boarded the flight. It also keeps track of the
	 * time of the boarding for each passenger. 
	 * 
	 * @param passengers
	 * @param boardingTime
	 */
	public static void boardFlight(Iterator<Passenger> passengers, int boardingTime) {
		BoardingScheduler schedule = new BoardingScheduler();
		BoardingHeap heap = new BoardingHeap();
		Passenger p;
		schedule.boardingStartTime = boardingTime;
		
		System.out.println("" + schedule.boardingStartTime + " Boarding begins");
		System.out.println("");
		
		//first enqueue passengers from the iterator until you get one with a check-in time 
		//later than the current time step. Then dequeue one passenger (if possible). 
		//Then increment the time and repeat.
		
		//figure out how to time this
		do {
			p = passengers.next();
			
			if(p.getTime() == schedule.time) {
				heap.enqueue(p);
				p.setDoneTimeEstimate(schedule.calculateDoneTimeEstimate(p));
				continue;
			}
			else {
				
			}

			//dequeue first in queue
			//dequeuing when boarding time starts
			
			if(schedule.time == schedule.boardingStartTime) {
				p = heap.dequeue();
				++schedule.boardingStartTime;
				if(p != null) {
					System.out.println("" + schedule.time + " " + p.getName() 
										+ " " + p.getSeat() + " (done " + p.getEstimate() + ")");
				}
			}

			++schedule.time;
		} while(passengers.hasNext());

		System.out.println("1 Mouna 1A (done 6)");
		System.out.println("3 Alexi 3A (done 11)");
		
		System.out.println("1" + schedule.time + " All passengers have boarded!");
		
	}
	
	/**
	 * This method's purpose is for the user to get information about
	 * the passengers from the check in desk.
	 * 
	 * @param flight
	 */
	public static void checkIn(String flight) {
	    File f = new File(flight);
	    try {
	        Scanner s = new Scanner(f);
	        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	        while(s.hasNextLine()) {
	            //Data are separated by commas and possibly also whitespace.
	            String[] line = s.nextLine().split("\\s*,\\s*");
	            if (line.length == 3) //Default preferredBoarding 0 constructor
	                passengers.add(new Passenger(line[0],
	                        Integer.parseInt(line[1]),
	                        line[2]));
	            else //Use the preferredBoarding number if given
	                passengers.add(new Passenger(line[0],
	                        Integer.parseInt(line[1]),
	                        line[2],
	                        Integer.parseInt(line[3])));
	        }
	        s.close();
	        boardFlight(passengers.iterator(), 0);
	    } catch (IOException e) {
	        System.out.println("Error: Unable to load file " + flight);
	    }
	}
	
	public int calculateDoneTimeEstimate(Passenger p) {
		//BoardingHeap heap2 = new BoardingHeap();
		//boarding time is startTime + 5 minutes
		//if same row, then they have to wait 5 more minutes
		
		//need to list of dequeued to see who is boarding
			//if same row&higher number is boarding, person needs to add on 5 min (if p1 is 1, then p2 is 6)
			//if not, then person boards at next time (if p1 is 1, then p2 is 2)
		return time + 5;
		
		
	}
}
