package five;

/*
ID: John Doe
LANG: JAVA
TASK: beads
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class beads {
	public static void main (String [] args) throws IOException {
		
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
	                                              // input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		// Output file path and place to write output
		
		f.readLine();
		String beads = f.readLine();
		f.close();
		int max = 0;
		
		
		
		for (int i = 0; i < beads.length(); i++) {
			String temp = "";
			temp += beads.substring(i);
			temp+= beads.substring(0, i);
			
					
			int m = findMax(temp);
			
			if(m > max) {
				max = m;
			}
			
			
		}
			
		out.println(max);
		out.close();
		
		
	}
	
	
	 static int findMax(String temp) {

		 int max = 0;
		 try {
			 
		 
		int length = temp.length();
		int m = 1;
		int count = -1;
		
		char ch = temp.charAt(0);
		
		if(ch == 'w') {
			int tempM = 0;
			ch = 'r';
			while((temp.charAt(count + 1) == ch) || (temp.charAt(count + 1) == 'w')) {
				if(m >= length) {
					break;
				}
				m++;
				count++;
			}
			
			if(m > tempM) {
				tempM= m;
			}
			
			m = 1;
			
			count = -1;
			
			ch = 'b';
			while((temp.charAt(count + 1) == ch) || (temp.charAt(count + 1) == 'w')) {
				if(m >= length) {
					break;
				}
				m++;
				count++;
			}
			
			if(m > tempM) {
				tempM = m;
			}
			
			m = tempM;
			max = m;
			
		}
		else {
			while((temp.charAt(count + 1) == ch) || (temp.charAt(count + 1) == 'w')) {
				if(m >= length) {
					break;
				}
				m++;
				count++;
			}
		}
		
		ch = temp.charAt(length - 1);
		count = length - 1;
		
		if (ch == 'w') {
			int tempM = 0;
			ch = 'r';
			
			while((temp.charAt(count - 1) == ch) || temp.charAt(count - 1) == 'w') {
				if(m >= length) {
					break;
				}
				m++;
				count--;
			}
			
			if(m > tempM) {
				tempM= m;
			}
			
			m = 1;
			count = length - 1;
			ch = 'b';
			
			while((temp.charAt(count - 1) == ch) || temp.charAt(count - 1) == 'w') {
				if(m >= length) {
					break;
				}
				m++;
				count--;
			}
			
			if(m > tempM) {
				tempM = m;
			}
			
			m = tempM;
			max = m;
			
		}
		else {
			while((temp.charAt(count - 1) == ch) || temp.charAt(count - 1) == 'w') {
				if(m >= length) {
					break;
				}
				m++;
				count--;
			}
			
			if(m > max) {
				max = m;
			}
			
		}
		 }
		 catch(StringIndexOutOfBoundsException e) {
		 }
		return max;
		
	
	
	}

}
