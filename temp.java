
public class temp {

	import java.io.File;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.Scanner;

	public class BoardingScheduler {
		
		public static BoardingHeap heap;
		public static int currentTime;
		public static BoardingHeap boardingHeap;
		
		/**
	     * Main Class, used for testing purposes
	     * 
	     */
	    public static void main(String[] args) {
	    	//TEST 
	    	checkIn("sample1.txt");
	    	
	    }
		
		public static void boardFlight(Iterator<Passenger> passengers, int start){
			
			// TODO wtf do i do with this fuck what
			BoardingScheduler boarding = new BoardingScheduler();
			
			currentTime = start;
			heap = new BoardingHeap();
			boardingHeap = new BoardingHeap();
			
			// Store the interator in a temporary variable
			Iterator<Passenger> iter = passengers;
			Passenger temp; // enqueue
			Passenger temp2; // dequeue
			
			// Starting boarding
			System.out.println(currentTime + " Boarding begins\n");
			
			while (iter.hasNext()){
				
				temp = iter.next();
				
				temp2 = temp; // initialize temp2 to a passenger
				
				//TODO
//				System.out.println("GOTTA CATCHEM ALL " + temp.getName() + " : Time: " 
//						+ temp.getTime() + ", Seat: " + temp.getSeat()
//						+ ", Priority: " + temp.getPreferredBoarding());
//				System.out.println("	The currentTime is: " + currentTime 
//						+ "\n	The passenger time is : " + temp.getTime());		

				if (temp.getTime() <= currentTime){
					// If it is ther current timestep, enqueue 
					//TODO
					//System.out.println("-----i can enqueue------here here " + temp.getName());
					
					// TODO modify the passenger to when they start boarding,
					// and calculate the done time estimate
				
					temp.setStartTime(currentTime);
					temp.setDoneTimeEstimate(boarding.calculateDoneTimeEstimate(temp));
					heap.enqueue(temp);	
				} else {
					// If no passengers arrive at the current time:
					// Increment current time until it matches the current passenger,
					// as long as there is a next passenger, else increment current time 
					// by 1.
					// Dequeue one passenger if possible for every timestep
					// incrementation, since only one passenger
					// can be dequeued per time step
					// Then enqueue current passenger
					if (iter.hasNext()){
						while (temp.getTime() != currentTime){
							if (!heap.isEmpty()){
								temp2 = heap.dequeue();
								boarding.boardingHeap.enqueue(temp2);
								System.out.println(currentTime + " "
										+ temp2.getName() + " " + temp2.getSeat()
										+ ", (done " + temp2.getDoneTime() + ")");
							}
							
							currentTime++;
						}
					} else {
						if (!heap.isEmpty()){
							temp2 = heap.dequeue();
							boarding.boardingHeap.enqueue(temp2);
							System.out.println(currentTime + " "
									+ temp2.getName() + " " + temp2.getSeat()
									+ " (done " + temp2.getDoneTime() + ")");
						}
						currentTime++;
					}
					 				
					//TODO
					//System.out.println("-----i can enqueue------there " + temp.getName());
					temp.setStartTime(currentTime);
					temp.setDoneTimeEstimate(boarding.calculateDoneTimeEstimate(temp));
					heap.enqueue(temp);
				}	
				
				// If there are no more passengers coming, dequeue the remaining passengers
				if (!iter.hasNext()){
					while (!heap.isEmpty()){
					temp2 = heap.dequeue();
					System.out.println(currentTime + " "
							+ temp2.getName() + " " + temp2.getSeat()
							+ " (done " + temp2.getDoneTime() + ")");
					currentTime++;
				}
				
				System.out.println((temp2.getDoneTime() + 1) + " All passengers have boarded!");
				
			}		
			}
			/**
			while(iter.hasNext()){
				temp = iter.next();
				
				System.out.println(temp.getName() + " : Time: " 
						+ temp.getTime() + ", Seat: " + temp.getSeat()
						+ ", Priority: " + temp.getPreferredBoarding());
				heap.enqueue(temp);
			}
			
			System.out.println("\nTESTING FUCKING HEAP SHIT");
			
			//temp2 = heap.dequeue();
			while (!heap.isEmpty()){
				temp2 = heap.dequeue();
				if (temp2 == null){
					break;
				}
				System.out.println(temp2.getName() + ", Time: " 
						+ temp2.getTime() + ", Seat: " + temp2.getSeat()
						+ ", Priority: " + temp2.getPreferredBoarding());
			}
			**/
			
			// passengers checking in, 
			// enqueued on the time steip given (int time)
			// multiple passengers arrive in one time step
			
			
			// passengers beginning boarding 
			
		}
		

		/**
		 * Reads in a file containing a list of flight passengers in the order they
		 * check in and runs the boardFlight() method with those passengers.
		 * @author Tina, Alexi
		 * @param flight is the name of the input file in the project directory
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
		        // TODO 
		        boardFlight(passengers.iterator(), 1);
		    } catch (IOException e) {
		        System.out.println("Error: Unable to load file " + flight);
		    }
		}
		
		public int calculateDoneTimeEstimate(Passenger p) {
			final int EXTRA_TIME = 5; // The extra time it takes for a passenger to sit down
			int doneTime;
			Passenger inTheDamnWay;
			
			if (boardingHeap.isEmpty()){
				doneTime = p.getStartTime() + EXTRA_TIME;
				p.setDoneTimeEstimate(doneTime);
				return doneTime;
			} else {
				inTheDamnWay = boardingHeap.dequeue();
				// If a passenger p2 with a seat that is in the same row,
				// or in an ìearlierî (lower numbered) row has begun boarding already
				if (p.getSeatNum() >= inTheDamnWay.getSeatNum()){
					doneTime = inTheDamnWay.getDoneTime() + EXTRA_TIME;
				} else {
					doneTime = p.getStartTime() + EXTRA_TIME;
				}
			}

			return doneTime;
		}
		
	}

}
