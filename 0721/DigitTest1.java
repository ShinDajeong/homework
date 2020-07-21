package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] result = new int[10];
		
		int n;
		do {
			n = sc.nextInt();
			if(n!=0)
				result[n/10] += 1;
			
		}while(n!=0);

		for(int i=0; i<result.length; i++) {
			if(result[i] > 0) 
				System.out.println(i + " : " + result[i] + "개");
		}
		
	}

}
