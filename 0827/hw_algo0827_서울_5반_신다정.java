package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hw_algo0827_서울_5반_신다정 {

	static int R, C;
	static char[][] map;
	static int cnt = 1;
	static int max = 0;
	static boolean[] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		visited = new boolean[26];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		dfs(0, 0, 1);
		System.out.println(max);
	}

	private static void dfs(int x, int y, int cnt) {
		max = Math.max(max, cnt);
		visited[map[x][y]-65] = true;
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(nx < 0 || ny < 0 || nx > R-1 || ny > C-1) continue;
			if(visited[map[nx][ny]-65] == false) {
				visited[map[nx][ny]-65] = true;
				dfs(nx, ny, cnt+1);
				visited[map[nx][ny]-65] = false;
			}
		}
	}

}
