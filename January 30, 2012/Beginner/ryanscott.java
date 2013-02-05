package com.xnux.acm;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Have you ever wanted a nonstable sorting algorithm that runs in O(n ⋅ n! → ∞)
 * time? Well, you're in for a treat! Especially if you're fond of waiting.
 */
public class Bogosorter {
	private static Random mRandom = new Random();
	private static Scanner mScanner = new Scanner(System.in);

	private static int[] randomArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = mRandom.nextInt();
		}
		return array;
	}

	private static void shuffle(int[] array) {
		int size = array.length;
		for (int i = 0; i < size; i++) {
			/* Swaps each index i with a random index taken from i to (size – 1).
			 * Indices before i aren't considered, since they've already had random
			 * values assigned. */
			int swapIndex = i + mRandom.nextInt(size - i);
			int temp = array[i];
			array[i] = array[swapIndex];
			array[swapIndex] = temp;
		}
	}

	private static boolean isSorted(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				return false;
			}
		}
		return true;
	}



	private static void bogoSort(int[] array) {
		while(!isSorted(array)) {
			shuffle(array);
		}
	}

	private static void bogoBogoSort(int[] array) {
		for(int subSize = 1; subSize <= array.length; subSize++) {
			int[] subArray = Arrays.copyOfRange(array, 0, subSize);
			shuffle(subArray);
			if(!isSorted(subArray)) {
				shuffle(array);
				subSize = 0;
			}
		}
	}

	public static void main(String... args) {
		System.out.print("Enter max array size number: ");
		int maxSize = mScanner.nextInt();
		for (int curSize = 1; curSize <= maxSize; curSize++) {
			System.out.print("Bogosorting array of size " + curSize + "... ");
			int[] array = randomArray(curSize);
			long startTime = System.currentTimeMillis();
			bogoBogoSort(array);
			System.out.print("Done in ~" + (System.currentTimeMillis() - startTime)
					+ " milliseconds! ");
			System.out.println(Arrays.toString(array));
		}
	}

}
