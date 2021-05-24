package two;

/*
ID: John Doe
LANG: JAVA
TASK: ride
*/
import java.io.*;

class ride {
	public static void main (String [] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
                                                  // input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		
		String comet = f.readLine().toLowerCase(); //read first line get comet name
		String group = f.readLine().toLowerCase(); // read second line get group name
    
		out.println(check(comet, group));
		
		out.close();
		f.close();
		
    
	}
	
	private static String check(String comet, String group) {
		int cometValue = 1; 
		int groupValue = 1;		
		
		for (int i = 0; i < comet.length(); i++) {
			char ch = comet.charAt(i);
		    int n = (int)ch - (int)'a' + 1;
		    cometValue *= n;
		}
		
		for (int i = 0; i < group.length(); i++) {
			char ch = group.charAt(i);
		    int n = (int)ch - (int)'a' + 1;
		    groupValue *= n;
		}
		
		int cometMod = cometValue % 47;
		int groupMod = groupValue % 47;
		
		if(cometMod == groupMod) {
			return "GO";
		}
		else {
			return "STAY";
		}
		
	}
  
  
}