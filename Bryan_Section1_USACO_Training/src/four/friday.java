package four;


/*
ID: John Doe
LANG: JAVA
TASK: friday
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class friday {
	
	
	static int[] week = new int[] {0, 0, 0, 0, 0, 0, 0};
    static int[] month = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	

public static void main (String [] args) throws IOException {
	// Use BufferedReader rather than RandomAccessFile; it's much faster
	BufferedReader f = new BufferedReader(new FileReader("friday.in"));
                                              // input file name goes above
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
	// Output file path and place to write output
	
	int beginYear = 1900;
	int endYear = beginYear + Integer.parseInt(f.readLine());
    
	int dayOfWeek = 2;
    
	for (int i = beginYear; i < endYear; i++) {
		 boolean leap = false;
	        if (i % 400 == 0) {
	            leap = true;
	        } else if (i % 100 == 0) {
	            leap = false;
	        } else if (i % 4 == 0) {
	            leap = true;
	        } else {
	            leap = false;
	        }
	        if (leap) {
	            month[1] = 29;
	        } else {
	            month[1] = 28;
	        }
		for (int m: month) {
            dayOfWeek+=12;
            dayOfWeek%=7;
            week[dayOfWeek]++;
            dayOfWeek+=m-12;
		}
	}
	
    
    
    out.println(week[0]+" "+week[1]+" "+week[2]+" "+week[3]+" "+week[4]+" "+week[5]+" "+week[6]);
    
    out.close();
	f.close();
	
	}
}