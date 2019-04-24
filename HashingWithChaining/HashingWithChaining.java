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


/**

import java.util.*; 
public class Arraylist { 
    public static void main(String[] args) 
    { 
        int n = 3; 
  
        // Here aList is an ArrayList of ArrayLists 
        ArrayList<ArrayList<Integer> > aList =  
                  new ArrayList<ArrayList<Integer> >(n); 
  
        // Create n lists one by one and append to the  
        // master list (ArrayList of ArrayList) 
        ArrayList<Integer> a1 = new ArrayList<Integer>(); 
        a1.add(1); 
        a1.add(2); 
        aList.add(a1); 
  
        ArrayList<Integer> a2 = new ArrayList<Integer>(); 
        a2.add(5); 
        aList.add(a2); 
  
        ArrayList<Integer> a3 = new ArrayList<Integer>(); 
        a3.add(10); 
        a3.add(20); 
        a3.add(30); 
        aList.add(a3); 
  
        for (int i = 0; i < aList.size(); i++) { 
            for (int j = 0; j < aList.get(i).size(); j++) { 
                System.out.print(aList.get(i).get(j) + " "); 
            } 
            System.out.println(); 
        } 
    } 
} 



*/