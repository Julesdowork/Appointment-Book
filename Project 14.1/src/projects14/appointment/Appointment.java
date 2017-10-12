package projects14.appointment;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * An appointment is a meeting or task to be placed in an appointment book.
 * @author Julian McNeill
 */
public class Appointment implements Comparable<Appointment>
{
	private String desc;
	private Calendar startTime;
	private Calendar endTime;
	
	/**
	 * Constructs an appointment
	 * @param aDescription a short phrase describing the appointment
	 * @param aStartTime the starting time of this appointment
	 * @param anEndTime the ending time of this appointment
	 */
	public Appointment(String aDescription, Calendar aStartTime,
			Calendar anEndTime)
	{
		desc = aDescription;
		startTime = aStartTime;
		endTime = anEndTime;
	}

	/**
	 * Checks whether this appointment comes before or after another
	 * appointment. If both appointments start at the same time, the one
	 * that ends first comes before the other one.
	 * @return -1 if it comes before the other appointment or 1 if it
	 * comes after. If 0, then these appointments happen at the exact
	 * same time.
	 */
	public int compareTo(Appointment otherAppt)
	{
		int order = startTime.compareTo(otherAppt.startTime);
		return order;
	}
	
	/**
	 * Checks whether this appointment conflicts with another appointment.
	 * @param otherAppt the other appointment
	 * @return true if this appointment occurs during another appointment,
	 * otherwise false
	 */
	public boolean conflictsWith(Appointment otherAppt)
	{
		if (startTime.after(otherAppt.startTime) &&
			endTime.before(otherAppt.endTime))
			return true;
		return false;
	}
	
	/**
	 * Gets the description of this appointment.
	 * @return the description
	 */
	public String getDescription()
	{
		return desc;
	}
	
	/**
	 * Gets the start time of this appointment
	 * @return the start time
	 */
	public Calendar getStartTime()
	{
		return startTime;
	}

	/**
	 * Gets the end time of this appointment
	 * @return the end time
	 */
	public Calendar getEndTime()
	{
		return endTime;
	}
	
	/**
	 * Prints out a string representation of this appointment.
	 */
	public void printAppointment()
	{
		System.out.printf("%s\n", desc);
		DateFormat df =
			DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);
		String startTimeString = df.format(startTime.getTime());
		String endTimeString = df.format(endTime.getTime());
		System.out.printf("%s - %s\n", startTimeString, endTimeString);
	}
}
