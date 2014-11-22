/*
 * Name: Stefan Mendoza
 * Date: 21 November 2014
 * Email: stefanmendoza.dev@gmail.com
*/

/*
Summary:
You are assigned with writing the code that outputs who likes a particular post. The algorithm is as follows:

If only one person likes a post (e.g., Mark), then output Mark likes this.
If only two people like a post (e.g., Mark and Giselle), then output Mark and Giselle like this.
If only three people like a post (e.g., Mark, Giselle, and Rory), then output Mark, Giselle and Rory like this.
If four or more people like a post (e.g., Mark, Giselle, Rory, and Lucy), then output Mark, Giselle and 2 others like this. Make to increase the amount in and 2 others depending on how many people like it.
If no one likes a post, then output No one likes this :(.
The input will be given as a space-separated list of names, ended by a newline.
*/

import java.util.Scanner;

class LikeCounter {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Input: ");
		String userInput = input.nextLine();
		String likes[] = userInput.split(" ");

		if(userInput.isEmpty()) {
			System.out.println("No one likes this. :(");
		}
		else if(likes.length == 1) {
			System.out.println(likes[0] + " likes this.");
		}
		else if(likes.length == 2) {
			System.out.println(likes[0] + " and " + likes[1] + " like this.");
		}
		else if(likes.length == 3) {
			System.out.println(likes[0] + ", " + likes[1] + " and " + likes[2]
			 + " like this.");	
		}
		else {
			System.out.println(likes[0] + ", " + likes[1] + " and " +
				(likes.length - 2) + " others like this.");
		}
	}
}