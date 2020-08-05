package com.ssafy.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj_2667 {

	static int arr[][];
	static boolean visited[][];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, num=0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N][N];
		visited = new boolean[N][N];
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String s = sc.next();
			for(int j=0; j<s.length(); j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 1 && visited[i][j] == false) {
					dfs(i,j);
					list.add(num);
					num=0;
					cnt++;
					
				}
					
			}
		}
		
		System.out.println(cnt);
		Collections.sort(list);
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));

	}
	
	static void dfs(int a, int b) {
		visited[a][b] = true;
		
		for(int k=0; k<4; k++) {
			int x = a + dx[k];
			int y = b + dy[k];
			
			if(x >= 0 && y>=0 && x < N && y < N) {
				if(arr[x][y] == 1 && visited[x][y] == false)
					dfs(x,y);
			}
			
		}
		num++;
	}

}
