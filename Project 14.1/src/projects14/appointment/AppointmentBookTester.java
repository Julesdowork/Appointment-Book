package projects14.appointment;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Tests the AppointmentBook class.
 * @author Julian McNeill
 */
public class AppointmentBookTester
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to Appointment Book\n");
		
		Scanner in = new Scanner(System.in);
		AppointmentBook myBook = new AppointmentBook();
		String desc;
		Appointment appt;
		
		System.out.println("\t1. View appointments");
		System.out.println("\t2. Add new appointment");
		System.out.println("\t0. Quit program");
		System.out.print("Enter a choice: ");
		int choice = in.nextInt();
		while (choice != 0)
		{
			if (choice == 1)
			{
				System.out.println("\t1. Today's");
				System.out.println("\t2. Enter date");
				System.out.println("\t0. Go back");
				System.out.print("Enter a choice: ");
				int viewChoice = in.nextInt();
				while (viewChoice < 0 || viewChoice > 2)
				{
					System.out.println("Not an option. Please try again.");
					System.out.print("Enter a choice: ");
					viewChoice = in.nextInt();
				}
				if (viewChoice == 1)
					myBook.printAll(Calendar.getInstance());
				else if (viewChoice == 2)
				{
					int year, month, day;
					System.out.print("Year: ");
					year = in.nextInt();
					System.out.print("Month (January = 1): ");
					month = in.nextInt() - 1;
					System.out.print("Day: ");
					day = in.nextInt();
					Calendar date = Calendar.getInstance();
					date.set(year, month, day);
					myBook.printAll(date);
				}
			}
			else if (choice == 2)
			{
				int year, month, day, hour, min;
				System.out.println("Enter description of appointment:");
				in.nextLine();
				desc = in.nextLine();
				System.out.println("Enter start time:");
				System.out.print("\tYear: ");
				year = in.nextInt();
				System.out.print("\tMonth (January = 1): ");
				month = in.nextInt() - 1;
				System.out.print("\tDay: ");
				day = in.nextInt();
				System.out.print("\tHour (24-h): ");
				hour = in.nextInt();
				System.out.print("\tMinute: ");
				min = in.nextInt();
				Calendar startTime = Calendar.getInstance();
				startTime.set(year, month, day, hour, min);
				System.out.println("Enter end time:");
				System.out.print("\tYear: ");
				year = in.nextInt();
				System.out.print("\tMonth (January = 1): ");
				month = in.nextInt() - 1;
				System.out.print("\tDay: ");
				day = in.nextInt();
				System.out.print("\tHour (24-h): ");
				hour = in.nextInt();
				System.out.print("\tMinute: ");
				min = in.nextInt();
				Calendar endTime = Calendar.getInstance();
				endTime.set(year, month, day, hour, min);
				appt = new Appointment(desc, startTime, endTime);
				myBook.add(appt);
			}
			else
				System.out.println("Not an option, please try again.");
			
			System.out.println("\n\t1. View appointments");
			System.out.println("\t2. Add new appointment");
			System.out.println("\t0. Quit program");
			System.out.print("Enter a choice: ");
			choice = in.nextInt();
		}
		
		System.out.println("\nGoodbye");
		in.close();
	}
}
