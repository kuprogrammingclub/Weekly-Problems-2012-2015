import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class hogwarts {

	final static String FILE_NAME = "hogwarts.in";
	static enum House { GRY, HUF, RAV, SLY };
	static Map<Character, House> houseMap = new HashMap<Character, House>();
	static int gryPoints, hufPoints, ravPoints, slyPoints, numPeople;

	public static void main(String[] args) {
		houseMap.put('g', House.GRY);
		houseMap.put('y', House.GRY);
		houseMap.put('o', House.GRY);
		houseMap.put('h', House.HUF);
		houseMap.put('f', House.HUF);
		houseMap.put('u', House.HUF);
		houseMap.put('r', House.RAV);
		houseMap.put('v', House.RAV);
		houseMap.put('a', House.RAV);
		houseMap.put('s', House.SLY);
		houseMap.put('b', House.SLY);
		houseMap.put('e', House.SLY);



		File fIn = new File(FILE_NAME);
		Scanner stdIn = null;
		try {
			stdIn = new Scanner(fIn);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		numPeople = stdIn.nextInt();

		for (int i = 0; i < numPeople; i++) {
			gryPoints = 0;
			hufPoints = 0;
			ravPoints = 0;
			slyPoints = 0;
			String firstname = stdIn.next();
			String lastname = stdIn.next();
			String name = firstname + lastname;
			for (char letter : name.toCharArray()) {
				if (letter == ' ') {
					continue;
				} else {
					char newLet = Character.toLowerCase(letter);
					if (houseMap.get(newLet) != null){
						switch (houseMap.get(newLet)) {
						case GRY:
							gryPoints++;
							break;
						case HUF:
							hufPoints++;
							break;
						case RAV:
							ravPoints++;
							break;
						case SLY:
							slyPoints++;
							break;
						}
					}
				}

			}
			int[] points = {gryPoints, hufPoints, ravPoints, slyPoints};
			Arrays.sort(points);
			int maxVal = points[points.length-1];
			if (maxVal != points[points.length - 2]) {
				if (maxVal == gryPoints) {
					System.out.println("Gryffindor");
				} else if (maxVal == hufPoints) {
					System.out.println("Hufflepuff");
				} else if (maxVal == ravPoints) {
					System.out.println("Ravenclaw");
				} else if (maxVal == slyPoints) {
					System.out.println("Slytherin");
				}
			} else {
				System.out.println("The Sorting Hat Must Decide.");
			}
		}
	}

}
