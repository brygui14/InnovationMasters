package three;

/*
ID: John Doe
LANG: JAVA
TASK: gift1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class gift1 {
	
	static LinkedHashMap<String, Integer> members = new LinkedHashMap<String, Integer>();  //Store each person with their name as the key
										       									           //Store each persons net amount as the value
	
	static ArrayList<String> dataLines = new ArrayList<String>(); //Place to store the input Data
	static ArrayList<String> nameKeys = new ArrayList<String>();
	
	public static void main (String [] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
                                                  // input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		// Output file path and place to write output
		
		String temp = f.readLine();
		while(temp != null) {
			dataLines.add(temp); //adding each line to dataLines
			temp = f.readLine();
		}
		
		
		int numberOfMembers = Integer.parseInt(dataLines.get(0));
		
		dataLines.remove(0);
		
		for(int i = 0; i < numberOfMembers; i++) {
			members.put(dataLines.get(0), 0);
			nameKeys.add(dataLines.get(0));
			dataLines.remove(0);
		}
		
		for(int i = 0; i < numberOfMembers; i++) {
			try {
				
				String key = dataLines.get(0);
				
				
				String[] amounts = dataLines.get(1).split(" ");
				
				
				int perPerson = Integer.parseInt(amounts[0]) / Integer.parseInt(amounts[1]);				
				int leftover = Integer.parseInt(amounts[0]) - (perPerson * Integer.parseInt(amounts[1]));
				
				dataLines.remove(0);
				dataLines.remove(0);
				
				int orginal = members.get(key);
				int newTotal = -Integer.parseInt(amounts[0]) + leftover + orginal;
				
				members.put(key, newTotal);
				
				for (int ii = 0; ii < Integer.parseInt(amounts[1]); ii++) {
					String key1 = dataLines.get(0);
					if (key1 == null) {
						int orginal2 = members.get(key);
						int newTotal2 = orginal2 + Integer.parseInt(amounts[0]);
						members.put(key, newTotal2);
						break;
					}
					dataLines.remove(0);
					
					int orginal1 = members.get(key1);
					int newTotal1 = orginal1 + perPerson;
					
					members.put(key1, newTotal1);
					
				}
				
				
				}
			catch(ArithmeticException e) {
				if(dataLines.isEmpty()) {
					break;
				}
				String key = dataLines.get(0);
				
				String[] amounts = dataLines.get(1).split(" ");
				
				int perPerson = 0;
				int leftover = Integer.parseInt(amounts[0]) - (perPerson * Integer.parseInt(amounts[1]));
				
				dataLines.remove(0);
				dataLines.remove(0);	
				
				int orginal = members.get(key);
				int newTotal = -Integer.parseInt(amounts[0]) + leftover + orginal;
				
				members.put(key, newTotal);
				
				for (int ii = 0; ii < Integer.parseInt(amounts[1]); ii++) {
					String key1 = dataLines.get(0);
					if (key1 == null) {
						int orginal2 = members.get(key);
						int newTotal2 = orginal2 + Integer.parseInt(amounts[0]);
						members.put(key, newTotal2);
						break;
					}
					dataLines.remove(0);
					
					int orginal1 = members.get(key1);
					int newTotal1 = orginal1 + perPerson;
					
					members.put(key1, newTotal1);
					
				}
				
			}
			catch(IndexOutOfBoundsException e1) {
				break;
			}
			
			
				
		
			
		}
		

		
	}
	
}
