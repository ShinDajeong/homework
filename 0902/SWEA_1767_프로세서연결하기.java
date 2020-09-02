package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서연결하기 {

	static int N, idx;
	static int[][] map;
	static int[] cnt;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<Point> list;
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	
	public static void main(String args[]) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T= Integer.parseInt(br.readLine());
	
	for(int test_case = 1; test_case <= T; test_case++)
	{
	
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		cnt = new int[N];
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if((i == N-1 || j == N-1) && map[i][j] == 1) {
					idx++;
					visited[i][j] = true;
					continue;
				}
				if(map[i][j] == 1) {
					list.add(new Point(i, j));
				}
			}
		}

		dfs(0, 0);
		
	}
	
	}

	private static void dfs(int idx, int distance) {
		Point p = list.get(idx);
		
		if(p.x == N-1 || p.y == N-1) {
			cnt[idx] = distance;
		}
		
		for(int k=0; k<4; k++) {
			int nx = p.x + dx[k];
			int ny = p.y + dy[k];
			
			if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1) continue;
			if(visited[nx][ny] == false && map[nx][ny] == 0) {
				visited[nx][ny] = true;
				dfs(idx+1, distance+1);
			}
		}
		
	}

}
