/*
	SLongofono     Week 03 Fall 2015     Intermediate

	Write a method that takes in two linked lists of numbers, each number representing the digit of a larger number, but with the order reversed.
	Return another linked list in the same format, representing the sum of the two passed in.
	Ex.
		100 in list form:    [0,0,1]
		232 in list form:    [2,3,2]
		result of 100 + 232: [2,3,3]
	

*/

import java.util.LinkedList;
public class List2List{

public static LinkedList ListSum(LinkedList a, LinkedList b){

	//normalize the lists
	while(a.size() > b.size()){
		b.add(0);	
	}
	while(b.size() > a.size()){
		a.add(0);
	}
	int carry = 0;
	int sum = 0;
	LinkedList result = new LinkedList();
	for(int i = 0; i<a.size(); i++){
		sum = (carry + (int)a.get(i) + (int)b.get(i));
		if(sum>9){
			carry = 1;
			result.add(sum%10);
		}
		else{
			carry = 0;
			result.add(sum);
		}
	}
	if(carry == 1){
		result.add(1);
	}
	return result;
}

public static void main(String[] args){
	if(args.length < 2){
		System.out.println("Usage: java List2List <number set one> <number set two>");
	}
	else{
		System.out.println("Building lists . . . ");
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		for(int i = 0; i<args[0].length(); i++){
			list1.add(args[0].charAt(i)-48);
		}
		for(int i = 0; i<args[1].length(); i++){
			list2.add(args[1].charAt(i)-48);
		}
		LinkedList result = ListSum(list1, list2);
		System.out.println("Your result:\n");
		System.out.println(result);
	}

}//end main

}//end class
