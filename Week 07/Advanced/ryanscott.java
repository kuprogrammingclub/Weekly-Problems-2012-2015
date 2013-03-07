package com.xnux.acm;

import java.util.Random;
import java.util.Scanner;

/**
 * Estimates the value of pi by "throwing darts" at a square board with side length
 * 2*RADIUS, which encloses a circle of radius RADIUS. The ratio of darts that land
 * within the circle to the total number of darts is roughly π/4.
 */
public class PiApproximator {
	public static final int RADIUS = 1; //This can be any value, FWIW
	private static Random mRand = new Random(System.currentTimeMillis());
	private static Scanner mScan = new Scanner(System.in);

	public static class Dart {
		private double x, y;
		private boolean isInCircle;

		/** "Throws" dart and determines if it landed in the circle */
		public Dart() { 
			x = getRandomDouble(mRand, RADIUS);
			y = getRandomDouble(mRand, RADIUS);
			if (Math.pow(x, 2) + Math.pow(y, 2)
					<= Math.pow(RADIUS, 2)) {
				isInCircle = true;
			} else {
				isInCircle = false;
			}
		}

		public boolean isInCircle() { return isInCircle; }
		private double getRandomDouble(Random rand, double radius) {
			return 2 * radius * rand.nextDouble() - radius;
		}
	}

	public static void main(String... args) {
		System.out.print("How many darts do you want to throw? ");
		long numDarts = mScan.nextLong();
		long numDartsHit = 0, numDartsMissed = 0;
		for (int i = 0; i < numDarts; i++) {
			Dart someDart = new Dart();
			if (someDart.isInCircle()) {
				numDartsHit++;
			} else {
				numDartsMissed++;
			}
		}
		
		/** This should be roughly equal to π/4, since circle has area of π*RADIUS^2
		 * and square has area (2*RADIUS)^2 */
		double ratio = (double) numDartsHit/numDarts;
		
		System.out.println("\nOut of " + numDarts + " darts thrown, "
				+ numDartsHit + " hit the circle of radius " +  RADIUS
				+ ", and " + numDartsMissed + " missed.");
		System.out.println("This produces a hit/total ratio of "
				+ ratio + " which, when multiplied by four, is "
				+ 4 * ratio + ".");
		System.out.println("This is " + Math.abs(Math.PI - 4 * ratio)
				+ " away from pi, " + Math.PI + ".");
	}
}
