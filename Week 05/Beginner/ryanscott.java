package com.xnux.acm;

public class OneToOneThousand {

	public static void main(String... args) {
		int[] oneTo1000 = new int[1000]; /* We need an "upper limit" of some kind for this to work.
											Fortunately, arrays have an upper limit in size. */
		try {
			recursionFTW(oneTo1000, 0);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.exit(0); //When index 1000 is accessed, exit.
		}
	}

	public static void recursionFTW(int[] list, int index) throws ArrayIndexOutOfBoundsException {
		int mIndex = index; //Since index is passed by value
		list[mIndex] = mIndex + 1; //Map the number (in range 1–1000) to an index (in range 0–999)...
		System.out.println(list[mIndex]); //...print the number at the index...
		mIndex++; //...go to the next index...
		recursionFTW(list, mIndex); //...and recurse until an array index exception is thrown!
	}
}