package com.ssafy;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;
public class swea_1223 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = 10;


		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringBuilder sb = new StringBuilder();
			int N = sc.nextInt();
			char[] arr = new char[N];
			Stack<Character> st = new Stack<Character>();
			
			String str = sc.next();
			for(int i=0; i<N; i++) {
				arr[i] = str.charAt(i);
			}
			
			for(int i=0; i<N; i++) {
				if(arr[i] == '0' || arr[i] == '1' || arr[i] == '2' || arr[i] == '3' || arr[i] == '4' || arr[i] == '5' ||
						arr[i] == '6' || arr[i] == '7' || arr[i] == '8' || arr[i] == '9') {
					sb.append(arr[i]);
				}
				else {
					if(st.isEmpty()) {
						st.push(arr[i]);
					}
					else {
						if(st.peek() == arr[i]) {
							sb.append(arr[i]);
							
						}
						else if(st.peek() == '*' && arr[i] == '+') {
							sb.append(st.pop());
							
							if(!st.isEmpty()) {
								if(st.peek() == arr[i])
									sb.append(arr[i]);
								else
									st.push(arr[i]);
								
							}
							else {
								st.push(arr[i]);
							}
							
						}
						else if(st.peek() == '+' && arr[i] == '*') {
							st.push(arr[i]);
						}
					}
				}
			}
			while(!st.isEmpty()) {
				sb.append(st.pop());
				
			}
			
			Stack<Integer> stack = new Stack<Integer>();
			for(int i=0; i<sb.length(); i++) {
				if(sb.charAt(i) >= '0' && sb.charAt(i) <= '9') {
					stack.push(sb.charAt(i)-'0');
				}
				else if(sb.charAt(i) == '+') {
					int num1 = stack.pop();
					int num2 = stack.pop();
					stack.push(num1+num2);
				}
				else if(sb.charAt(i) == '*') {
					int num1 = stack.pop();
					int num2 = stack.pop();
					stack.push(num1*num2);
				}
			}
			System.out.println("#"+test_case+ " " + stack.pop());
			
			
			
		}
		
		
		
	}

}
