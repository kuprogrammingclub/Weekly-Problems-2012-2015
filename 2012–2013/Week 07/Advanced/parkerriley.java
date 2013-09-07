package week7Git;

import java.util.*;

public class MonteCarlo {
	
	public static void main(String[] args) {
		final int NUM_REPS = 5000000;
		final int SIDE_LENGTH = 1001;
		final int RADIUS = SIDE_LENGTH / 2;
		Random numGen = new Random();
		int numInside = 0;
		for (int i = 0; i < NUM_REPS; i++) {
			int x = numGen.nextInt(SIDE_LENGTH);
			int y = numGen.nextInt(SIDE_LENGTH);
			if (Math.pow(x - RADIUS, 2) + Math.pow(y - RADIUS,  2) <= Math.pow(RADIUS, 2)) {
				numInside++;
			}
		}
		System.out.println((double) (((double) numInside / NUM_REPS) * Math.pow(SIDE_LENGTH, 2) / (Math.pow(RADIUS, 2))));
	}
}
