/**
 * @author Swrajit Paul
 * @version 1.0
 * 
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HashingWithChaining {
	private static ArrayList<Integer>[] al;
	private static int n = 0;
	public static void main(String[] args) {
		FileInputStream fInput = null;
		try {
			fInput = new FileInputStream(args[0]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner scan = new Scanner(fInput);
		
		Random rand = new Random();
		n = rand.nextInt(10);
		al = new ArrayList[n];
		for(int i = 0; i < al.length; i++) {
			al[i] = new ArrayList<Integer>();
		}
		
		while(scan.hasNextInt()) {
			
			al[scan.nextInt() % n].add(scan.nextInt());
		}
		scan.close();
		String answer = "";
		int searchedNumber = 0;
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("Enter a number or type exit to quit search");
			answer = input.nextLine();
			try {
				searchedNumber = Integer.parseInt(answer);
			} catch(NumberFormatException e) {
				if(answer.equalsIgnoreCase("exit")) {
					System.out.println("you have exited");
					break;
				}
				System.out.println("Please make sure it is a number or a valid command(ie: exit");
				continue;
			}
				System.out.println(exist(searchedNumber));
			
		}
	}
	
	public static boolean exist(int number) {
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < al[i].size(); j++) {
				if(al[i].get(j) == number) {
					return true;
				}
			}
		}
		
		return false;
	}
}
