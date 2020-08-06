package com.ssafy.hw;

import java.util.Arrays;
import java.util.Scanner;

public class boj_2961 {
	static int N,num;
	static int min = Integer.MAX_VALUE;
	static int[] S, B;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		S = new int[N];	// 신맛 담을 배열
		B = new int[N];	// 쓴맛 담을 배열
		visited = new boolean[N];	// 방문했는지 확인할 배열
		
		for(int i=0; i<N; i++) {	// 값 넣기 
			S[i] = sc.nextInt(); 
			B[i] = sc.nextInt();
		}
		
		for(int i=1; i<=N; i++) {	// 조합을 사용할 예정, 모든 가능한 경우를 생각해야하기 때문에
			num = i;				// nC1, nC2, ... , nCr 등등 다 돌려봄
			Comb(0);
		}
		System.out.println(min);	// 최솟값 출력
	}
	static void Comb(int cnt) {
		if(cnt == num) {
			int s = 1;
			int b = 0;
			for(int i=0; i<N; i++) {
				if(visited[i] == true) {	// 방문한 인덱스만 찾아서 계산
					s *= S[i];
					b += B[i];
				}
			}
			min = Math.min(min, Math.abs(s - b));
			return;
		}
		
		for (int i = 0; i < N; i++) {	// 조합
			if(visited[i]) continue;
			visited[i] = true;
			Comb(cnt+1);
			visited[i] = false;
		}
		
	}

}
