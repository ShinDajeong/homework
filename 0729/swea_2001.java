package com.ssafy;
import java.util.Scanner;
import java.io.FileInputStream;
public class swea_2001 {
	static int[] dx = {1, 1, 1};
	static int[] dy = {0, 0, 1};
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			int sum = 0;
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {

					for(int k=i; k<M+i; k++) {
						for(int l=j; l<M+j; l++) {
							sum += arr[k][l];
						}
					}
					
					if(max < sum)
						max = sum;
					sum = 0;
				}
			}
			System.out.println("#"+test_case+ " " + max);
			
			
			
		}
	}

}
