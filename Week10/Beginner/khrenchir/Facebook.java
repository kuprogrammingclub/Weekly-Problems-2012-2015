import java.util.Scanner;

public class Facebook {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		String names = input.nextLine();
		
		String [] namesArray = names.split("\\s+");

			if (namesArray[0].equals("")){
				System.out.println("No one likes this. Or you. No one likes you.");
			} else if(namesArray.length == 1){
				System.out.println(namesArray[0] + " likes this.");
			} else if (namesArray.length < 3){
				System.out.println(namesArray[0] + " and " + namesArray[1] + " like this.");
			} else if (namesArray.length == 3){
				System.out.println(namesArray[0] + ", " + namesArray[1] + ", and " + namesArray[2] + " like this.");
			} else if (namesArray.length >= 4){
				System.out.print(namesArray[0] + ", " + namesArray[1] + ", and " + (namesArray.length-2) + " other people like this.");
			} 
	}

}
