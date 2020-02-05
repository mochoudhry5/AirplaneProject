/*
 * Momin Choudhry  
 * 11/18/2019
 * This program has the user input and seat and book that seat on an airplane
 * if that seat is already taken or it is not a valid seat, it will let the user know 
 * and have him/her reenter a different seat number 
 */

// Import Scanner 
import java.util.Scanner;
// Class called SeatingDriver
public class SeatingDriver {
	/**
	 * Method that will ask user to input a row and seat number 
	 * and call methods from the SeatingAssignment class 
	 * @param args
	 */
	public static void main(String args[]){
		// Create Scanner called console 
		Scanner console = new Scanner(System.in);
		// Initialize rows to equal 7
		int rows = 7;
		// Initialize columns to equal 5
		int columns = 5;
		// Create a 2D array called seats 
		char seats[][]=new char[rows][columns];
		// seatsLeft will be calculated from (columns-1)*rows
		int seatsLeft=(columns-1)*rows; 
		// Called intializedSeats with seats as a parameter from the 
		// SeatingAssignment class 
		SeatingAssignment.initializeSeats(seats);
		// Let user know he/she will be selecting seats 
		System.out.println("You will be selecting seats for this airplane.");
		// Show user how to input his/her row and seat number 
		System.out.println("You will input the seat selection using the row number and then the seat letter ( ex - 3B )");
		// Run while seatsLeft is greater than 0 
		while (seatsLeft > 0) {
			// Called displaySeats from SeatingAssignment class with seats as a parameter 
			SeatingAssignment.displaySeats(seats);
			// Ask user to input a row and seat number 
			System.out.println("Please enter the seat number or Q to quit.");
			// Hold users input in "seat" variable 
			String seatLocation=console.next();
			// If the zero index of the input is  equal to 'q' or 'Q' 
			// break from while loop 
			if(seatLocation.charAt(0)=='Q' || seatLocation.charAt(0)=='q'){
				break;
							}
			// If the zero index of the input is not equal to 'q' or 'Q' 
			// run if statement 
			if(seatLocation.charAt(0)!='Q' && seatLocation.charAt(0)!='q'){
				/*
				 * Send "seats", "seatLocation", and "seatsLeft" as parameters to assignSeat 
				 * method in SeatingAssignment class 
				 * if returns true, minus one from seatsLeft
				 * if returns false, skip "if" statement
				 */
				if(SeatingAssignment.assignSeat(seats, seatLocation, seatsLeft)) {
					seatsLeft-=1;
					}
				}
			
			// If seatsLeft equal 0, let user know all seats are assigned 
			if(seatsLeft==0) {
				SeatingAssignment.displaySeats(seats);
				// Print "This flight is completely booked. All seats assigned"
				System.out.println("This flight is completely booked. All seats assigned.");
				}
				
			}

	}
		
}

	
