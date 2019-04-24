/*
 * @author Swrajit Paul
 * Simple Bloom Filter 
 * Version 1.0
 */
import java.util.*;
import java.util.Scanner;

public class BloomFilter {
	private static int n = 10;
	private static int k = 3;
	private static int m = 10;
	
	public static void main(String[] args) {
		double errorRate = Math.pow((1-Math.exp((-k*n)/m)), k);
		System.out.println();
		System.out.println("The error rate of this bloom filter will be " + errorRate + " due to the values of m,n,k");
		System.out.println();
		ArrayList<Integer> al = new ArrayList<Integer>(n);
		
		Scanner scan = new Scanner(System.in);
		
		int[] array = new int[m];
		int i = 0;
		while(i < n) {
			System.out.print("Please Enter number " + i + ": " );
			al.add(scan.nextInt());
			i++;
			if(i == 10) {
				System.out.println("Done");
			}
		}
		
		Iterator<Integer> it = al.iterator();
		
		while(it.hasNext()) {
			int value = it.next();
			
			// hash function one 
			if(array[value%10] == 0) {
				array[value%10] = 1;
			}
			
			// hash function two 
			if(array[value%9] == 0) {
				array[value%9] = 1;
			}
			
			// hash function three 
			if(array[value%8] == 0) {
				array[value%8] = 1;
			}
						
		}
		
		String response = "";
		int value = 0;
		while(true) {
			System.out.print("Enter the value you want to search or type q to quit search: ");
			response = scan.next();
			if(response.equalsIgnoreCase("q")) {
				System.out.println("Search ended!");
				break;
			}
			try {
				value = Integer.parseInt(response);
			} catch (NumberFormatException e) {
				System.out.println("try again");
				continue;
			}
			
			boolean first = false;
			boolean second = false;
			boolean third = false;
			
			// hash function one 
			if(array[value%10] == 1) {
				first = true;
			}
			
			// hash function two 
			if(array[value%9] == 1) {
				second = true;
			}
			
			// hash function three 
			if(array[value%8] == 1) {
				third = true;
			}
			
			if(first && second && third) {
				System.out.println("The number you entered is in the Bloom Filter");
				continue;
			}
			
			else {
				System.out.println("The number is not in the Bloom Filter");
			}
			
		}
		
	}
}

