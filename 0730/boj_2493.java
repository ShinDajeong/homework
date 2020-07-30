package com.ssafy.hw;

import java.io.*;
import java.util.*;

public class boj_2493 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Stack<Integer> stack = new Stack<Integer>();
		int[] result = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		while(N!=1) {
			for(int i=0; i<N; i++) {
				stack.push(arr[i]);
			}
			int num = stack.peek();
			for(int j=0; j<N; j++) {
				if(num < stack.pop()) {
					result[N-1] = stack.size()+1;
					break;
				}
			}
			
			
			N--;
			stack.clear();
		}
		
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
			

}
