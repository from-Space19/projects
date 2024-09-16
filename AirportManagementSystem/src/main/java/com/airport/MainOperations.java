package com.airport;

import java.util.Scanner;


public class MainOperations {
	static Scanner sc = new Scanner(System.in);

	public static void mainOperation() {
		while (true) {
			System.out.println("Airport Management System:");
			System.out.println("1. Airport Operations");
			System.out.println("2. Airline Operations");
			System.out.println("3. Passenger Operations");
			System.out.println("4. Staff Operations");
			System.out.println("5. Flight Operations");
			System.out.println("6. Booking Operations");
			System.out.println("7. Exit");
			int choice = sc.nextInt();
			sc.nextLine(); 
			
			switch (choice) {
			case 1:
				AllOperations.airportOperations();
				System.out.println("=======================================");
				break;
			case 2:
				AllOperations.airlineOperations();
				System.out.println("=======================================");
				break;
			case 3:
				AllOperations.passengerOperations();
				System.out.println("=======================================");
				break;
			case 4:
				AllOperations.staffOperations();
				System.out.println("=======================================");
				break;
			case 5:
				AllOperations.flightOperations();
				System.out.println("=======================================");
				break;
			case 6:
				AllOperations.bookingOperations();
				System.out.println("=======================================");
				break;
			case 7:
				System.out.println("Exiting the system...");
				System.exit(0);
			default:
				System.out.println("Invalid choice! Please try again.");
			}
			System.out.println("=======================================");
		}
	}
	
}
