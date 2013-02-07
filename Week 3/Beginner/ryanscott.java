package com.xnux;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class SleepCycle {

	private static final int SLEEP_CYCLE_LENGTH = 90;
	private static final int FALL_ASLEEP_TIME = 7;

	public static void main(final String[] args) {

		final Scanner inputScanner = new Scanner(System.in);

		System.out.println("Do you want to\n " +
				"(1) Enter a wake-up time and calculate possible go-to-sleep times?\n " +
				"(2) Enter a go-to-sleep time and calculate possible wake-up times?\n");
		System.out.print("Your choice?: ");

		int option = inputScanner.nextInt();

		if (option == 1) { //Find go-to-bed times
			System.out.print("\nPlease enter your wake-up time (e.g. \"6:05 AM\"): ");
			inputScanner.nextLine(); //This prevents the previously typed integer from being stored in inputTime
			String inputTime = inputScanner.nextLine();
			String[] bits = inputTime.split(":"); //Split input into array elements (e.g., first element is "12", second element is "30 PM").

			Calendar wakeUpTime = new GregorianCalendar(); //The calendar type probably doesn't matter, but the word "Gregorian" is awesome
			wakeUpTime.set(Calendar.HOUR, Integer.valueOf(bits[0]));
			wakeUpTime.set(Calendar.MINUTE, Integer.valueOf(bits[1].substring(0,2))); //Only use first two characters from second element of bits
			wakeUpTime.set(Calendar.AM_PM, bits[1].replaceAll("[^A-Za-z]", "").equalsIgnoreCase("AM") ? Calendar.AM : Calendar.PM); //This strips the
			//second element of bits of all non-letter characters, then sees if remaining string equals "AM" or something else (hopefully "PM").

			System.out.println("\nYou should go to bed at:");
			for (int i = 3; i <= 6; i++) {
				Calendar goToBedTime = (Calendar) wakeUpTime.clone();
				goToBedTime.add(Calendar.MINUTE, -SLEEP_CYCLE_LENGTH*i - FALL_ASLEEP_TIME);
				int hour = goToBedTime.get(Calendar.HOUR);
				int minutes = goToBedTime.get(Calendar.MINUTE);
				int amOrPm = goToBedTime.get(Calendar.AM_PM);

				System.out.println("\t"
						+ ((hour == 0) ? 12 : hour) + ":" /*The Calendar class represents hour 12 as 0, so this accounts for that */
						+ ((minutes < 10) ? "0" + minutes : minutes) + " " /* Make sure output is two characters long */
						+ ((amOrPm == Calendar.AM) ? "AM" : "PM"));
			}
		} else { //Find wake-up times
			System.out.print("\nPlease enter your go-to-sleep time (e.g. \"11:00 PM\"): ");
			inputScanner.nextLine();
			String inputTime = inputScanner.nextLine();
			String[] bits = inputTime.split(":");

			Calendar wakeUpTime = new GregorianCalendar();
			wakeUpTime.set(Calendar.HOUR, Integer.valueOf(bits[0]));
			wakeUpTime.set(Calendar.MINUTE, Integer.valueOf(bits[1].substring(0,2)));
			wakeUpTime.set(Calendar.AM_PM, bits[1].replaceAll("[^A-Za-z]", "").equalsIgnoreCase("AM") ? Calendar.AM : Calendar.PM);

			System.out.println("\nYou will (probably) wake up at:");
			for (int i = 3; i <= 6; i++) {
				Calendar goToBedTime = (Calendar) wakeUpTime.clone();
				goToBedTime.add(Calendar.MINUTE, SLEEP_CYCLE_LENGTH*i + FALL_ASLEEP_TIME);
				int hour = goToBedTime.get(Calendar.HOUR);
				int minutes = goToBedTime.get(Calendar.MINUTE);
				int amOrPm = goToBedTime.get(Calendar.AM_PM);

				System.out.println("\t"
						+ ((hour == 0) ? 12 : hour) + ":"
						+ ((minutes < 10) ? "0" + minutes : minutes) + " "
						+ ((amOrPm == Calendar.AM) ? "AM" : "PM"));
			}
		}
		inputScanner.close();
	}

}
