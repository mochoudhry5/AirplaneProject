/*
 * Momin Choudhry 
 * CSC 15 
 * Professor Ben White 
 * 11/18/2019
 * This program has the user input and seat and book that seat on an airplane
 * if that seat is already taken or it is not a valid seat, it will let the user know 
 * and have him/her reenter a different seat number 
 */

// Class called SeatingAssignment
public class SeatingAssignment {
	/**
	 * Method that creates the array of the seating for the airplane 
	 * @param seats
	 */
	public static void initializeSeats(char seats[][]){
		// Create variable called rows which is equal 
		// to the length of the array 
		int rows=seats.length;
		// Loop "rows" amount of times 
		for(int i=0;i<rows;i++){
			/*
			 * Creates "rows"-1 amount of rows with four columns 
			 * with 'A','B','C', and 'D'
			 */
			seats[i][0]=(""+(i+1)).charAt(0);
			seats[i][1]='A';
			seats[i][2]='B';
			seats[i][3]='C';
			seats[i][4]='D';
			}
	}
	/**
	 * Method that will print the array with row numbers and seat numbers 
	 * @param seats array 
	 */
	public static void displaySeats(char seats[][]){
		// "rows" equals the seats length
		int rows=seats.length;
		// Have it loop "row - 1" amount of times 
		for(int i=0;i<rows;i++){ 
			// cols is equal to the length of the seat array at index "i" 
			int cols=seats[i].length;
			// Print seat array at [i][0] 
			// followed by a period with a space
			System.out.print(seats[i][0]+". ");
			// Loop "cols - 1" amount of times; increment j by 2  
			for(int j=1;j<cols;j+=2){
				// Print seat array at [i][j]
				System.out.print(seats[i][j]);
				// Print seat array at [i][j+1]
				System.out.print(seats[i][j+1]);
				// Print a space 
				System.out.print(" ");
				}
			// Print a new line 
			System.out.println();
			}
	}
	/**
	 * Method that validates if the row number is valid 
	 * @param rowAisle
	 * @return true if valid row number and false if not valid 
	 */
	public static boolean validateRow(char rowAisle){
		return (rowAisle=='1'||rowAisle=='2'||rowAisle=='3'||rowAisle=='4'||rowAisle=='5'||rowAisle=='6'||rowAisle=='7');
	}
	/**
	 * Method that validates if the seat number is valid 
	 * @param seat
	 * @return true if valid seat number and false if not valid 
	 */
	public static boolean validateSeat(char seat){
		return (seat=='A'||seat=='B'||seat=='C'||seat=='D');
	}
	/**
	 * Method that assigns the seat with an 'X' if the user selects that seat 
	 * if user enters an already assigned seat, prints "Seat is already taken"
	 * if user enters an invalid seat, print " Invalid choice"
	 * @param seats
	 * @param seat
	 * @param seatsleft
	 * @return true if the seat is valid  
	 * or false if it is invalid or already assigned 
	 */
	public static boolean assignSeat(char seats[][],String seat,int seatsleft){
		// "rowAisle" is equal to the 0 index of the string "seat"
		char rowAisle=seat.charAt(0);
		// "seatLetter" is equal to the first index of the string "seat"
		char seatLetter=seat.charAt(1);
		// Checks if both rowAisle and seatLetter are valid 
		if(validateRow(rowAisle)&& validateSeat(seatLetter)){ 
			// If seatsLeft are greater than 0, run everything inside the if statement
			if(seatsleft>0){
				// "row" is equal to rowAisle - 48
				int row=rowAisle-48;
				/*
				 * if seatLetter is equal to 'A' and if the seat array [row-1][1] is not equal to 'X'
				 * replace that row and seat number with 'X'
				 */
				if(seatLetter=='A' && seats[row-1][1]!='X'){
					seats[row-1][1]= 'X';
					return true;
					}
				/*
				 * if seatLetter is equal to 'B' and if the seat array [row-1][2] is not equal to 'X'
				 * replace that row and seat number with 'X'
				 */
				else if(seatLetter=='B' && seats[row-1][2]!='X'){
					seats[row-1][2]= 'X';
					return true;
					}
				/*
				 * if seatLetter is equal to 'C' and if the seat array [row-1][3] is not equal to 'X'
				 * replace that row and seat number with 'X'
				 */
				else if(seatLetter=='C' && seats[row-1][3]!='X'){
					seats[row-1][3]= 'X';
					return true;
					}
				/*
				 * if seatLetter is equal to 'D' and if the seat array [row-1][4] is not equal to 'X'
				 * replace that row and seat number with 'X'
				 */
				else if(seatLetter=='D' && seats[row-1][4]!='X'){
					seats[row-1][4]= 'X';
					return true;
					}
				/*
				 * if the "if" and "else if" statements are false
				 * run the else statement
				 */
				else {
					// Print ""Selected seat has been taken"
					System.out.println("Selected seat has been taken");
					// Return false
					return false;
					}   
		  
				}
			// If the second "if" statement is false, run the else statement
			else {
				// Return false 
				return false;
			}
		}
		// If the first "if" statement is false, run the else statement
		else {
			// Print "Invalid Choice"
			System.out.println("Invalid Choice");
			// Return false
			return false;
		}
	}
	
}
	
	
	
	

