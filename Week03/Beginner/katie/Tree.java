import java.util.Scanner;
public class Tree {
	public static void main (String [] args){
		Scanner input = new Scanner(System.in);
		System.out.print("tree width= ");
		int n = input.nextInt();
			while (n < 3 || n%2 == 0){
				if ( n < 3) {
					System.out.println("Width must be greater than three.");
					n = input.nextInt();
				}
				if (n%2 == 0){
					System.out.println("Odd number, please.");
					n = input.nextInt();
				}
			}			
		System.out.print("leaf character= ");
		String leaves = input.next();
		System.out.print("trunk character= ");
		String trunk = input.next();
		
		int x = 0;
		int spaces = n/2;
		for (x=1; x<=n; x+=2){
			for(int i=0;i<=spaces;i++){
				System.out.print(" ");
			}
			for(int y=0; y < x; y++){
			System.out.print(leaves);
			}
			System.out.print('\r');
			spaces--;
		}
		for (int z = 0; z <=((n/2)-1) ; z++){
			System.out.print(" ");
		}
		System.out.println(trunk + trunk + trunk);
	}
}
