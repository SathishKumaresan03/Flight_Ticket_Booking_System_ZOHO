package Flight_ticket_Reservation_System;

import java.util.ArrayList;

public class Flight {

    // id for flight which is alloted everytime a new Flight Object is created
    static int id = 0;
    int flightID;
    //Availabel number of tickets currently in flight
    int tickets;
    //current price
    int price;
    //string list of all passenger details for printing
    ArrayList<String> passengerDetails;
    //list of all passenger IDs
    ArrayList<Integer> passengerIDs;
    //list of number of tickets booked by every passenger ID
    ArrayList<Integer> bookedTicketsPerPassenger;
    //list of cost paid by every passenger ID, used to calculate refund while cancelling
    ArrayList<Integer> passengerCost;

    //constructor to set values
    public Flight()
    {
        tickets = 50;
        price = 5000;
        id = id + 1;
        flightID = id;
        passengerDetails = new ArrayList<String>();
        passengerIDs = new ArrayList<Integer>();
        bookedTicketsPerPassenger = new ArrayList<Integer>();
        passengerCost = new ArrayList<Integer>();
    }
 
    
    
   
}
