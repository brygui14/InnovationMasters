package seven;

/*
ID: John Doe
LANG: JAVA
PROG: transform
*/

import java.io.*;
import java.util.*;
public class transform {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        int N = Integer.parseInt(br.readLine());
        char[][] before = new char[N][N];
        char[][] after = new char[N][N];
        
        for (int ii = 0; ii < N; ii++) {
            before[ii]=br.readLine().toCharArray();
        }
        for (int ii = 0; ii < N; ii++) {
            after[ii]=br.readLine().toCharArray();
        }

        int transformation = 0;
        if (equal(rotate(before), after)) {
            transformation=1;
        } else if (equal(rotate(rotate(before)), after)) {
            transformation=2;
        } else if (equal(rotate(rotate(rotate(before))), after)) {
            transformation=3;
        } else if (equal(reflect(before), after)) {
            transformation=4;
        } else if (equal(rotate(reflect(before)), after)) {
            transformation=5;
        } else if (equal(rotate(rotate(reflect(before))), after)) {
            transformation=5;
        } else if (equal(rotate(rotate(rotate(reflect(before)))), after)) {
            transformation=5;
        } else if (equal(before, after)) {
            transformation=6;
        } else {
            transformation=7;
        }
        out.println(transformation);
        out.close();
        br.close();
        
        
        
        
        
    }
    public static char[][] reflect(char[][] m) {
    	int N = m.length;
        char[][] temp = new char[N][N];
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		temp[i][N - j - 1] = m[i][j];
        	}
        }
        return temp;
    }
    public static char[][] rotate(char[][] m) {
        int N = m.length;
        char[][] temp = new char[N][N];
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		temp[j][N - i - 1] = m[i][j];
        	}
        }
        return temp; 
    }
    public static boolean equal(char[][] a, char[][] b) {
        boolean temp = true;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j]!=b[i][j]) temp = false;
            }
        }
        return temp;
    }
}
