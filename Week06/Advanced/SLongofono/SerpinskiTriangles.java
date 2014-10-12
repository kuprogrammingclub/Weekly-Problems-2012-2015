import java.util.Scanner;

public class SerpinskiTriangles {  //AKA Pascal's triangle mod 2

	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		System.out.println("Input number of rows: ");
		int rowsIn = input.nextInt();
		int[] temp = new int[3];
		temp[0] = 1;
		temp[1] = 2;
		temp[2] = 1;
		
		int[] thisRow = rowPlus(temp);
		if(rowsIn == 0){
			System.out.println("*");
		}
		else{
			System.out.println("*");
			System.out.println("* *");
		}
		for(int i = 0; i < (rowsIn*2)-2; i++){      //every 2 rows of Pascal's triangle is one row Serpinski's triangle
			thisRow = rowPlus(thisRow);
			for(int j = 0; j<thisRow.length; j++){
				if(thisRow[j]%2==0){
					System.out.print(" ");
				}
				else if(thisRow[j]%1==0){
					System.out.print("*");
				}
			}
			System.out.println("");
		}
		
		
	}
	
	public static int[] rowPlus(int[] lastRow){         //increments array size, fills out values per Pascal's triangle
		int[] thisRow = new int[lastRow.length + 1];
		thisRow[0] = 1;
		thisRow[thisRow.length-1] = 1;
		for(int i = 1; i<=lastRow.length-1; i++){
			thisRow[i] = lastRow[i-1]+lastRow[i];
		}
		return thisRow;
	}
	
}
