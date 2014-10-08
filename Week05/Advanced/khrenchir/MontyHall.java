import java.util.Random;
import java.util.Scanner;

public class MontyHall {
	public static void main (String [] args){
		Scanner input = new Scanner(System.in);
		
		boolean stillPlaying = true;
		boolean stayed = true;
		int wonIfStayed = 0;
		int wonIfSwitched = 0;
		double tries = 0;
		String stayOrSwitch;
		int currentDoor = 5;
		
		do {
			Random rand = new Random();
			int carDoor = rand.nextInt(3) + 1;
			//System.out.println(carDoor);
						
			System.out.println("╔═══╗   ╔═══╗   ╔═══╗ \r" +
					"║   ║   ║   ║   ║   ║\r" +
					"║ 1°║   ║ 2°║   ║ 3°║\r" +
					"║   ║   ║   ║   ║   ║\r" +
					"╚═══╝   ╚═══╝   ╚═══╝");
			System.out.println("Behind one of these doors is a car, \rbut behind the other two are goats. \rWhich door will you chose?");
			int doorChosen = input.nextInt();
			
			int doorToBeOpened;
			do{
				doorToBeOpened = rand.nextInt(3) + 1 ;
			} while (doorToBeOpened == carDoor || doorToBeOpened == doorChosen);
			
			int doorToSwitchTo;
			do{
				doorToSwitchTo = rand.nextInt(3) + 1 ;
			} while (doorToSwitchTo == doorToBeOpened || doorToSwitchTo == doorChosen);
			
			//System.out.println(doorToBeOpened);
			System.out.println("It looks like there was a goat behind Door " + doorToBeOpened + "!"
					+ "\rKnowing this, will you stay with Door " + doorChosen + " or switch to Door " + doorToSwitchTo + "?");
			
			stayOrSwitch = input.next();
			
			if(stayOrSwitch.equals("stay")){
				stayed = true;
				currentDoor = doorChosen;
			} else if(stayOrSwitch.equals("switch")) {
				stayed = false;
				currentDoor = doorToSwitchTo;
			} 
			
			System.out.println("The car was behind Door " + carDoor +".");
			if (currentDoor == carDoor && stayed){
				System.out.println("You won!");
				wonIfStayed++;
			} else if(currentDoor == carDoor && !stayed){
				System.out.println("You won!");
				wonIfSwitched ++;
			} else {
				System.out.println("You won! (a goat, sucker.)");
				wonIfSwitched++;
			}
						
			tries++;
			System.out.printf("Won if stayed: %d/%,.0f ", wonIfStayed, tries);
			System.out.printf("(%,.0f)", (wonIfStayed/tries)*100);
			System.out.println("%");
			System.out.printf("Won if switched: %d/%,.0f ", wonIfSwitched, tries);
			System.out.printf("(%,.0f)", (wonIfSwitched/tries)*100);
			System.out.println("%");
			System.out.println("Play again?");
			//stillPlaying = input.nextBoolean();		
			if(input.next().equals("yes") || input.next().equals("y") ){
				stillPlaying = true;
			} else {
				stillPlaying = false;
			} 
			
		} while(stillPlaying);
		System.out.println("Thanks for playing!");
	}

}
