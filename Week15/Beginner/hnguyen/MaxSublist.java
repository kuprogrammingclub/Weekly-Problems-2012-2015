import java.util.*;
public class MaxSublist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner user_input = new Scanner(System.in);
		int size;
		System.out.println("The size of the list is:");
		size = user_input.nextInt();
		int[] arr  = new int[size];
		int[] sum = new int[size];
		int max_sum = arr[size-1];
		int max_index = size-1;
		System.out.println("The list is:");
		for (int i  = 0; i < size; i++) {
			arr[i] = user_input.nextInt();
		}
		for (int i = size-1; i >= 0; i--) {
			if (i == size-1) {
				sum[i] = arr[i];
			} else if (arr[i] >= 0) {
				sum[i] = Math.max(arr[i], arr[i] + sum[i+1]);
			} else {
				sum[i] = arr[i] + sum[i+1];
			}
			if (sum[i] > max_sum) {
				max_sum = sum[i];
				max_index = i;
			}
		}
		int end = max_index;
		int s = 0;
		while (s < max_sum) {
			s += arr[end];
			end++;
		}
		System.out.print("Sublist: ");
		for (int i = max_index; i < end; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(",sum: " + max_sum);
	}
}
