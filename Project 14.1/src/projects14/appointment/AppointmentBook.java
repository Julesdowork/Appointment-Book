package projects14.appointment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/**
 * An appointment book stores a list of appointments and can print them all.
 * @author Julian McNeill
 */
public class AppointmentBook
{
	private ArrayList<Appointment> book;
	private boolean sorted;
	
	/**
	 * Constructs the appointment book.
	 */
	public AppointmentBook()
	{
		book = new ArrayList<Appointment>();
	}
	
	/**
	 * Adds an appointment to the appointment book.
	 * @param appt the appointment to add
	 */
	public void add(Appointment appt)
	{
		for (Appointment a : book)
		{
			if (appt.conflictsWith(a))
			{
				System.out.println("Cannot add appointment. "
						+ "Conflicts with \"" + a.getDescription() + "\".");
				return;
			}
		}
		book.add(appt);
		sorted = false;
	}
	
	/**
	 * Prints all of the appointments for a given day
	 */
	public void printAll(Calendar date)
	{
		if (!sorted)
			sort();
		for (Appointment appt : book)
		{
			if (appt.getStartTime().get(Calendar.MONTH) == date.get(Calendar.MONTH) && 
				appt.getStartTime().get(Calendar.DAY_OF_MONTH) == date.get(Calendar.DAY_OF_MONTH))
				appt.printAppointment();
		}
	}
	
	/**
	 * Sorts the appointment book by order of start and end times.
	 */
	private void sort()
	{
		Collections.sort(book);
		sorted = true;
	}
}
