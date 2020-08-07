package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1697_숨바꼭질 {
	
	static int N, K, cnt, s;
	static Queue<Integer> q = new LinkedList<>();
	static Queue<Integer> dept = new LinkedList<>();
	static boolean[] visited = new boolean[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		int cnt = 0;
		q.offer(N);
		dept.offer(cnt);
		if(q.contains(K) && cnt == 0) {
			return dept.poll();
		}
		while(!q.isEmpty()){
			int num = q.poll();
			visited[num] = true;
			s = dept.poll();
			if(num == K)
				break;
			if(2*num <= 100000 && 2*num >= 0 && visited[2*num] == false ) {
				q.offer(2*num);
				dept.offer(s+1);
			}
			if(num+1 < 100000 && num+1 >= 0 && visited[num+1] == false) {
				q.offer(num+1);
				dept.offer(s+1);
			}
			if(num-1 < 100000 && num-1 >= 0 && visited[num-1] == false) {
				q.offer(num-1);
				dept.offer(s+1);
			}
			
			
		}
		return s;
		
		
		
	}

}
