package Flight_ticket_Reservation_System;

public class Flight_Service {

	// function to book tickets in flight
	public static void book(Flight currentFlight, int tickets, int passengerID) {
		String passengerDetail = "";
		// create detail about the passenger with the ID
		passengerDetail = "Passenger ID " + passengerID + " -- " + " Number of Tickets Booked " + tickets + " -- "
				+ "Total cost " + currentFlight.price * tickets;
		// add passenger detail to flight object
		addPassengerDetails(passengerDetail, tickets, passengerID, currentFlight);
		flightSummary(currentFlight);
		printDetails(currentFlight);
	}

	// add passenger details to flight
	public static void addPassengerDetails(String passengerDetail, int numberOfTickets, int passengerID,
			Flight flight) {
		flight.passengerDetails.add(passengerDetail);
		flight.passengerIDs.add(passengerID);
		flight.passengerCost.add(flight.price * numberOfTickets);

		// updating price using logic in the problem statement
		flight.price += 200 * numberOfTickets;

		// updating available number of tickets
		flight.tickets -= numberOfTickets;
		flight.bookedTicketsPerPassenger.add(numberOfTickets);
		System.out.println("Booked Successfully!");

	}

	// function to cancel the booked tickets by the particular passenger
	public static void cancel(Flight currentFlight, int passengerID) {
		// find the index to remove from all lists
		int indexToRemove = currentFlight.passengerIDs.indexOf(passengerID);
		if (indexToRemove < 0) {
			System.out.println("Passenger ID not found!");
			return;
		}
		int ticketsToCancel = currentFlight.bookedTicketsPerPassenger.get(indexToRemove);

		// increase number of available tickets
		currentFlight.tickets += ticketsToCancel;
		// change price to new value after cancellation
		currentFlight.price -= 200 * ticketsToCancel;

		// calculate refund
		System.out.println("Refund Amount after cancel : " + currentFlight.passengerCost.get(indexToRemove));

		// remove details of passenger from all lists
		currentFlight.bookedTicketsPerPassenger.remove(indexToRemove);
		currentFlight.passengerIDs.remove(Integer.valueOf(passengerID));
		currentFlight.passengerDetails.remove(indexToRemove);
		currentFlight.passengerCost.remove(indexToRemove);

		System.out.println("Cancelled Booked Tickets Successfully!");

		flightSummary(currentFlight);
		printDetails(currentFlight);
	}
	
	// function to print flightdetails
	public static void flightSummary(Flight flight) {
		System.out.println("Flight ID " + flight.flightID + " --" + "Remaining Tickets " + flight.tickets + " --"
				+ "Current Ticket Price " + flight.price);
	}
	
	// functions to print details about flights and passengers
	public static void printDetails(Flight f) {
		for (String detail : f.passengerDetails)
			System.out.println("Flight ID " + f.flightID + "->"+detail);
	}

}
