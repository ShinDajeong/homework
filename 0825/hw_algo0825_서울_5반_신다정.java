package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hw_algo0825_서울_5반_신다정 {
	static int N;
	static int[][] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		
		
		quad(N, 0, 0);
		
	}

	
	public static void quad(int n, int x, int y) {
		
		int zero_cnt = 0;
		int one_cnt = 0;
		
		for(int i=y; i<y+n; i++) {
			for(int j=x; j<x+n; j++) {
				if(arr[i][j] == 0)
					zero_cnt++;
				if(arr[i][j] == 1)
					one_cnt++;
			}
		}
	
		if(zero_cnt == n*n) {
			System.out.print("0");
			return;
		}
		else if(one_cnt == n*n) {
			System.out.print("1");
			return;
		}
		
		System.out.print("(");
		quad(n/2, x, y);
		quad(n/2, x+n/2, y);
		quad(n/2, x, y+n/2);
		quad(n/2, x+n/2, y+n/2);
		System.out.print(")");
	
	
	}
	
}
