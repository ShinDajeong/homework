package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hwalgo0828_local_5반_신다정 {

	static int N, d, k, c;
	static int[] arr;
	static int[] check;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
//		for(int i=0; i<N; i++) {
//			check = new boolean[d+1];
//			
//			int cnt = 0;
//			for(int j=0; j<k; j++) {
//				if(!check[arr[(i+j)%N]]) {
//					cnt++;
//					check[arr[(i+j)%N]] = true;
//				}
//			}
//			if(!check[c]) cnt++;
//			
//			max = (max < cnt)?cnt:max;
//		}
//		
//		
//		System.out.println(max);
		check = new int[3001];
		int cnt = 0;
		
		// arr[0] ~ arr[k-1] 까지 배열을 확인해서 cnt값을 설정해준다.
		for(int i=0; i<k; i++) {
			check[arr[i]]++;
			if(check[arr[i]] == 1) cnt++;
		}
		if(check[c] == 0) max = cnt+1;
		else max = cnt;
		
		for(int i=k; i<N+k; i++) {
		
			// 처음과 끝만 확인한다 
			check[arr[i-k]]--;
			if(check[arr[i-k]] == 0) cnt--;	// 만약 시작하는 인덱스가 포함되지 않는다면 cnt -1 을 해줌
			check[arr[i%N]]++;
			if(check[arr[i%N]] == 1) cnt++; // 끝 인덱스가 새로 포함된다면 cnt + 1을 해줌
			
			if(check[c] == 0) max = Math.max(cnt+1, max);
			else max = Math.max(cnt, max);
		
		}
		
		System.out.println(max);
	}

}
