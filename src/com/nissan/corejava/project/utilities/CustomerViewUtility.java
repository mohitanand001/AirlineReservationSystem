package com.nissan.corejava.project.utilities;

import java.util.Scanner;

import com.nissan.corejava.project.dao.CustomerDaoImpl;
import com.nissan.corejava.project.dao.FlightDaoImpl;
import com.nissan.corejava.project.dao.TicketDaoImpl;
import com.nissan.corejava.project.pojo.Flight;
import com.nissan.corejava.project.pojo.Customer;
public class CustomerViewUtility {

	public void bookFlight(Customer c) {
		FlightDaoImpl flightImpl = new FlightDaoImpl();
		flightImpl.showAllFlight();
		System.out.println("Enter the flight id and the number of tickets to book to book");
		
		int id, numOfTickets;
		Scanner input = new Scanner(System.in);
		id = input.nextInt();
		Flight flight = flightImpl.showFlight(id);
		int availableTickets = flight.getNumberOfSeats();
		numOfTickets =input.nextInt();
		while(!(availableTickets - numOfTickets >= 0))
		{
			System.out.println("The number of seats available is less than"+numOfTickets);
			System.out.println("Please another number of tickets again");
			numOfTickets = input.nextInt();
		}
		TicketDaoImpl ticket = new TicketDaoImpl();
		
		for(int i = 1; i <= numOfTickets; i++)
		{
			System.out.println("Enter passener" + i +" name email dob and contact");
			System.out.println("Enter name");
			String name = input.next();
			System.out.println("Enter email");
			String email = input.next();
			System.out.println("Enter dob");
			String dob = input.next();
			System.out.println("Enter contact number");
			String contact = input.next();
			ticket.addTicket(id, c.getId(), name, email, dob, contact, 1);
		}
	}

	public void cancelFlight() {
		// TODO Auto-generated method stub
		
	}

	public void resheduleFlight() {
		// TODO Auto-generated method stub
		
	}

	public void showBooking() {
		// TODO Auto-generated method stub
		
	}

	
}