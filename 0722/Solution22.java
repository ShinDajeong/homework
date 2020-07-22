package com.ssafy.algo;

import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			int N = sc.nextInt();
			int s = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int i=0; i<s; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int d = sc.nextInt();
				
				if(arr[x][y] == 1) 
					continue;
				
				
				for(int k=3; k>0; k--) {
					if(d==1) {
						if(x-k < 0) 
							break;
						else {
							arr[x-k][y] = k;
							x = x - k;
						}	
					}
					else if(d==2) {
						if(x+k >= N) 
							break;
						else {
							arr[x+k][y] = k;
							x = x + k;
						}
					}
					else if(d==3) {
						if(y-k < 0) 
							break;
						else {
							arr[x][y-k] = k;
							y = y - k;
						}
					}
					
					else if(d==4) {
						if(y+k >= N) 
							break;
						else {
							arr[x][y+k] = k;
							y = y + k;
						}
					}

				}
				
				
			}
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)
					if(arr[i][j] == 1) cnt++;
			}
			
			System.out.println("#" + testCase + " " + cnt);
			
	
			
		}
		
		
		
	}

}
