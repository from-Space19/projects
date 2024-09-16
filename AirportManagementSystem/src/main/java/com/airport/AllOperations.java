package com.airport;

import com.airport.entity.*;
import com.airport.service.*;
import com.airport.serviceImpl.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class AllOperations {

	static AirlineService airlineService = new AirlineServiceImpl();
	static AirportService airportService = new AirportServiceImpl();
	static FlightService flightService = new FlightServiceImpl();
	static BookingService bookingService = new BookingServiceImpl();
	static PassengerService passengerService = new PassengerServiceImpl();
	static StaffService staffService = new StaffServiceImpl();

	static Scanner sc = new Scanner(System.in);

	// Airline Inputs
	public static Airline airlineInputs() {
		sc.nextLine(); 
		System.out.println("Enter Airline Name:");
		String airlineName = sc.nextLine();
		return new Airline(airlineName);
	}

	public static Airport airportInputs() {
		sc.nextLine();
		System.out.println("Enter Airport Name:");
		String airportName = sc.nextLine();
		System.out.println("Enter Airport Location:");
		String airportLocation = sc.nextLine();
		return new Airport(airportName, airportLocation);
	}

	public static Flight flightInputs() {
		sc.nextLine();
		System.out.println("Enter Departure Date (yyyy-MM-dd):");
		LocalDate departureDate = LocalDate.parse(sc.nextLine() + "T00:00:00");
		System.out.println("Enter Departure Time (HH:mm:ss):");
		LocalTime departureTime = LocalTime.parse("2000-01-01T" + sc.nextLine());
		System.out.println("Enter Arrival Time (HH:mm:ss):");
		LocalTime arrivalTime = LocalTime.parse("2000-01-01T" + sc.nextLine());
		System.out.println("Enter Departure Airport ID:");
		int departureAirportID = sc.nextInt();
		System.out.println("Enter Arrival Airport ID:");
		int arrivalAirportID = sc.nextInt();
		System.out.println("Enter Airline ID:");
		int airlineID = sc.nextInt();

		Airport departureAirport = airportService.getAirport(departureAirportID);
		Airport arrivalAirport = airportService.getAirport(arrivalAirportID);
		Airline airline = airlineService.getAirline(airlineID);

		return new Flight(departureDate, departureTime, arrivalTime, departureAirport, arrivalAirport, airline);
	}

	public static Booking bookingInputs() {
		sc.nextLine();
        System.out.println("Enter Booking Date (yyyy-MM-dd HH:mm:ss):");
        LocalDateTime bookingDate = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println("Enter Booking Amount:");
		float bookingAmount = sc.nextFloat();
		System.out.println("Enter Seat Number:");
		String seatNumber = sc.nextLine();
		System.out.println("Enter Flight ID:");
		int flightID = sc.nextInt();
		System.out.println("Enter Passenger ID:");
		int passengerID = sc.nextInt();

		Flight flight = flightService.getFlightDetails(flightID);
		Passenger passenger = passengerService.getPassengerDetails(passengerID);

		return new Booking(bookingDate, bookingAmount, seatNumber, flight, passenger);
	}

	public static Passenger passengerInputs() {
		sc.nextLine();
		System.out.println("Enter Passenger Name:");
		String passengerName = sc.nextLine();
		System.out.println("Enter Passport Number:");
		String passportNumber = sc.nextLine();
		System.out.println("Enter Nationality:");
		String nationality = sc.nextLine();
		System.out.println("Enter Email:");
		String email = sc.nextLine();
		System.out.println("Enter Password:");
		String password = sc.nextLine();
		return new Passenger(passengerName, passportNumber, nationality, email, password);
	}

	public static Staff staffInputs() {
		sc.nextLine();
		System.out.println("Enter Staff Name:");
		String staffName = sc.nextLine();
		System.out.println("Enter Staff Role:");
		String staffRole = sc.nextLine();
		System.out.println("Enter Email:");
		String email = sc.nextLine();
		System.out.println("Enter Password:");
		String password = sc.nextLine();
		System.out.println("Enter Airport ID:");
		int airportID = sc.nextInt();

		Airport airport = airportService.getAirport(airportID);
		return new Staff(staffName, staffRole, email, password, airport);
	}

	public static void airlineOperations() {
		while (true) {
			System.out.println(
					"1. Register Airline\n2. Get Airline Details\n3. Get All Airline\n4. Delete Airline\n5. Back to Main Menu");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				Airline airline = airlineInputs();
				airlineService.registerAirline(airline);
				System.out.println("Airline added successfully.");
				break;
			case 2:
				System.out.println("Enter Airline ID ");
				int airlineID = sc.nextInt();
				Airline aline = airlineService.getAirline(airlineID);
				System.out.println(aline);
				break;
			case 3:
				List<Airline> airlines = airlineService.getAllAirline();
				for (Airline air : airlines) {
					System.out.println(air);
				}
				break;
			case 4:
				System.out.println("Enter Airline ID to delete:");
				airlineID = sc.nextInt();
				airlineService.deleteAirline(airlineID);
				System.out.println("Airline deleted.");
				break;
			case 5:
				return;
			}
		}
	}

	public static void airportOperations() {
		while (true) {
			System.out.println(
					"1. Register Airport\n2. Get Airport Details\n3. Get All Airports\n4. Update Airport\n5. Delete Airport\n6. Back to Main Menu");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				Airport airport = airportInputs();
				airportService.registerAirport(airport);
				System.out.println("Airport added successfully");
				break;
			case 2:
				System.out.println("Enter Airport ID ");
				int airportID = sc.nextInt();
				Airport result = airportService.getAirport(airportID);
				System.out.println(result);
				break;
			case 3:
				List<Airport> airports = airportService.getAllAirport();
				for (Airport ap : airports) {
					System.out.println(ap);
				}
				break;
			case 4:
				System.out.println("Enter Airport ID to update:");
				int aID = sc.nextInt();
				Airport updatedAirport = airportInputs();
				airportService.updateAirportDetails(aID, updatedAirport);
				System.out.println("Airport updated successfully. ");
				break;

			case 5:
				System.out.println("Enter Airport ID to delete:");
				airportID = sc.nextInt();
				airportService.deleteAirport(airportID);
				System.out.println("Airport deleted.");
				break;
			case 6:
				return;
			}
		}
	}

	public static void flightOperations() {
		while (true) {
			System.out.println(
					"1. Register Flight\n2. Get Flight Details\n3. Get List Of All Flights\n4. Get List Of Flights Of Same Airline \n5. Get List Of Flights By Date \n6. Update Flight Details \n7. Delete Flight Details \n8. Back to Main Menu");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				Flight flight = flightInputs();
				flightService.registerFlight(flight);
				System.out.println("Flight added successfully");
				break;
			case 2:
				System.out.println("Enter Flight ID ");
				int airportID = sc.nextInt();
				Flight result = flightService.getFlightDetails(airportID);
				System.out.println(result);
				break;
			case 3:
				List<Flight> flights = flightService.getAllFlights();
				for (Flight f : flights) {
					System.out.println(f);
				}
				break;
			case 4:
				System.out.println("Enter Airline ID ");
				int airlineID = sc.nextInt();
				List<Flight> flightList = flightService.getAllFlightsByAirline(airlineID);
				for (Flight f : flightList) {
					System.out.println(f);
				}
				break;
			case 5:
				System.out.print("Enter a date (dd/mm/yyyy): ");
				String dateStr = sc.next();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate date = LocalDate.parse(dateStr, formatter);
				List<Flight> flightsList = flightService.getFlightsByDate(date);
				for (Flight f : flightsList) {
					System.out.println(f);
				}
				break;
			case 6:
				System.out.println("Enter Flight ID to update:");
				int flightID = sc.nextInt();
				Flight updatedFlight = flightInputs();
				flightService.updateFlightDetails(flightID, updatedFlight);
				System.out.println("Flight updated successfully ");
				break;
			case 7:
				System.out.println("Enter Flight ID to delete:");
				flightID = sc.nextInt();
				flightService.deleteFlightDetails(flightID);
				System.out.println("Flight deleted.");
				break;
			case 8:
				return;
			}
		}
	}

	public static void bookingOperations() {
		while (true) {
			System.out.println("1. Book Flight\n2. Get Booking Details\n3. Update Booking Details \n4. Get All Bookings By Date \n5. Get All Bookings By Flight \n6. Delete Booking \n7. Back to Main Menu");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				Booking bk = bookingInputs();
				bookingService.bookTicket(bk);
				System.out.println("Booking done successfully");
				break;
			case 2:
				System.out.println("Enter Booking ID ");
				int bID = sc.nextInt();
				Booking result = bookingService.getBookingDetails(bID);
				System.out.println(result);
				break;
			case 3:
				System.out.println("Enter Booking ID to update:");
				int bookingID = sc.nextInt();
				Booking booking = bookingInputs();
				bookingService.updateBookingDetails(bookingID, booking);
				System.out.println("Flight updated successfully ");
				break;
			case 4:
				System.out.println("Enter Booking Date (yyyy-MM-dd HH:mm:ss):");
				LocalDateTime bookingDate = LocalDateTime.parse(sc.nextLine());
				List<Booking> bookings = bookingService.getAllBookingByDate(bookingDate);
				for (Booking b : bookings) {
					System.out.println(b);
				}
				break;
			case 5:
				System.out.println("Enter Flight ID ");
				int flightId = sc.nextInt();
				List<Booking> bookingList = bookingService.getBookingsByFlight(flightId);
				for (Booking b : bookingList) {
					System.out.println(b);
				}
				break;
			case 6:
				System.out.println("Enter Booking ID to delete:");
				int bid = sc.nextInt();
				bookingService.deleteBooking(bid);
				System.out.println("Booking deleted.");
				break;
			case 7:
				return;
			}
		}
	}
	
	public static void passengerOperations() {
		while (true) {
			System.out.println("1. Register Passenger\n2. Get Passenger Details\n3. Get All Passengers \n4. Get All Passengers In a Flight \n5. Update Passenger Details \n6. Delete Passenger \n7. Back to Main Menu");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				Passenger ps = passengerInputs();
				passengerService.registerPassenger(ps);
				System.out.println("Passenger registered successfully");
				break;
			case 2:
				System.out.println("Enter Passenger ID ");
				int pid = sc.nextInt();
				Passenger result = passengerService.getPassengerDetails(pid);
				System.out.println(result);
				break;
			case 3:
				List<Passenger> passengers = passengerService.getAllPassengers();
				for (Passenger p : passengers) {
					System.out.println(p);
				}
				break;
			case 4:
				System.out.println("Enter Flight ID ");
				int flightId = sc.nextInt();
				List<Passenger> passengerList = passengerService.getAllPassengersByFlight(flightId);
				for (Passenger p : passengerList) {
					System.out.println(p);
				}
				break;
			case 5:
				System.out.println("Enter Passenger ID to update:");
				int passengerID = sc.nextInt();
				Passenger passenger = passengerInputs();
				passengerService.updatePassengerDetails(passengerID, passenger);
				System.out.println("Passenger updated successfully ");
				break;
			case 6:
				System.out.println("Enter Passenger ID to delete:");
				int pID = sc.nextInt();
				passengerService.removePassenger(pID);
				System.out.println("Passenger deleted.");
				break;
			case 7:
				return;
			}
		}
	}
	
	public static void staffOperations() {
		while (true) {
			System.out.println("1. Register Staff\n2. Get Staff Details\n3. Get All The Staff By Role \n4. Get All Staffs In An Airport \n5. Update Staff Details \n6. Delete Staff \n7. Back to Main Menu");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				Staff ps = staffInputs();
				staffService.registerStaff(ps);
				System.out.println("Staff registered successfully");
				break;
			case 2:
				System.out.println("Enter Staff ID ");
				int sid = sc.nextInt();
				Staff result = staffService.getStaffDetails(sid);
				System.out.println(result);
				break;
			case 3:
				System.out.println("Enter Staff Role ");
				String role = sc.next();
				List<Staff> staffs = staffService.getAllStaffsByRole(role);
				for (Staff s : staffs) {
					System.out.println(s);
				}
				break;
			case 4:
				System.out.println("Enter Airport ID ");
				int airportID = sc.nextInt();
				List<Staff> staffList = staffService.getAllStaffsByAirport(airportID);
				for (Staff s : staffList) {
					System.out.println(s);
				}
				break;
			case 5:
				System.out.println("Enter Staff ID to update:");
				int staffID = sc.nextInt();
				Staff staff = staffInputs();
				staffService.updateStaffDetails(staffID, staff);
				System.out.println("Staff updated successfully ");
				break;
			case 6:
				System.out.println("Enter Staff ID to delete:");
				int sID = sc.nextInt();
				staffService.deleteStaff(sID);
				System.out.println("Staff deleted.");
				break;
			case 7:
				return;
			}
		}
	}
}
