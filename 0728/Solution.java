package com.ssafy;

import java.util.Scanner;

public class Solution {
	// 오른쪽 아래 왼쪽 위
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int cnt = 1;
			int x=0;
			int y=-1;
			
			for(int i=0; i<2*N+1; i++) {
				while(true) {
					if(x+dx[i%4]>=0 && x+dx[i%4]<N && y+dy[i%4]>=0 && y+dy[i%4]<N && arr[x+dx[i%4]][y+dy[i%4]]==0) {
						x += dx[i%4];
						y += dy[i%4];
						arr[x][y] = cnt;
						cnt++;
					}
					else
						break;
					
				}
			}
					
			
			System.out.println("#"+test_case);
			for(int a=0; a<N; a++) {
				for(int b=0; b<N; b++) {
					System.out.print(arr[a][b] + " ");
				}
				System.out.println();
			}
		}
	}

}
