package Flight_ticket_Reservation_System;

import java.util.ArrayList;
import java.util.Scanner;

public class Flight_Control {

	public static void main(String[] args) {
		// create 2 flights for now with id 1 and 2
		ArrayList<Flight> flights = new ArrayList<Flight>();
		for (int i = 0; i < 2; i++)
			flights.add(new Flight());

		// unique ID for passenger allotted during every booking
		int passengerID = 1;
		boolean flag = true;
		// get choice from user
		while (flag) {
			System.out.println("1. Book \n2. Cancel \n3. Print\n4. Exit");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			// based on choice call different functions
			switch (choice) {
			// book
			case 1: {
				System.out.println("Enter Flight ID");
				int fid = sc.nextInt();

				// check if flight id is valid
				if (fid > flights.size()) {
					System.out.println("Invalid flight ID");
					break;
				}
				// find the corresponding flight
				Flight currentFlight = null;
				for (Flight f : flights) {
					if (f.flightID == fid) {
						currentFlight = f;
						Flight_Service.flightSummary(currentFlight);
						break;
					}
				}
				System.out.println("Enter number of tickets\n");
				int tickets = sc.nextInt();

				// check if availabilty is there
				if (tickets > currentFlight.tickets) {
					System.out.println("Not Enough Tckets");
					break;
				}
				// call book function to book tickets
				Flight_Service.book(currentFlight, tickets, passengerID);

				// increment passenger ID so that next booking will have different passenger ID
				// value
				passengerID = passengerID + 1;
				break;
			}
			// cancel
			case 2: {
				System.out.println("Enter flight ID and passenger ID to cancel booking");
				int fid = sc.nextInt();

				// check if flight id is valid
				if (fid > flights.size()) {
					System.out.println("Invalid flight ID");
					break;
				}
				// find the corresponding flight
				Flight currentFlight = null;
				for (Flight f : flights) {
					if (f.flightID == fid) {
						currentFlight = f;
						break;
					}
				}
				// get passengerID from passenger to find the booking
				int id = sc.nextInt();

				// call the cancel Booking
				Flight_Service.cancel(currentFlight, id);
				break;
			}
			// print details of flight along with passenger details
			case 3: {
				// loop though all available flights
				for (Flight f : flights) {
					// check if flight has atleast 1 passenger detail
					if (f.passengerDetails.size() == 0) {
						System.out.println("No passenger Details for  - Flight " + f.flightID);
					} else
						Flight_Service.printDetails(f);
				}
				break;
			}
			case 4: {
				System.out.println("Thank you for your service");
				flag = false;
			}
			default: {
				System.out.println("Enter valid choices");
				break;
			}
			}
			
		}

	}
}
