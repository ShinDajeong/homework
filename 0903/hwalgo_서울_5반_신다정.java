package study3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1681_해밀턴순환회로 {

	static int N, answer;
	static int[][] map;
	static boolean[] visited;
	static int[] numbers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		numbers = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		answer = Integer.MAX_VALUE;
		visited[0] = true;
		perm(0);
		System.out.println(answer);
		
	}
	private static void perm(int cnt) {
		if(cnt == N-1) {
			System.out.println(Arrays.toString(numbers));
			int result = map[0][numbers[0]];
			for(int i=0; i<numbers.length-1; i++) {
				if(result > answer) break;
				result += map[numbers[i]][numbers[i+1]];
			}
			
			answer = Math.min(answer, result);
			
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i] == true) continue;
			if(cnt == 0 && map[0][i] == 0) continue;
			if(cnt > 0 && map[cnt-1][i] == 0) continue;
			numbers[cnt] = i;
			visited[i] = true;
			perm(cnt+1);
			visited[i] = false;
		}
		
	}
	
	
	
	
}
