package com.ssafy;

import java.io.*;
import java.util.StringTokenizer;

public class jungol_1863_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;

	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parents = new int[N+1];
		make();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a, b;

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			Union(a, b);

		}

		int cnt = 0;
		for (int i = 1; i < parents.length; i++) {
			if(i==parents[i])
				cnt += 1;
		}
		sb.append(cnt);
		System.out.println(sb.toString());
//      HashSet<Integer> comparable = new HashSet<>();
//      for(int i=1; i<parents.length; i++){
//          comparable.add(parents[i]);
//      }
//      System.out.println(comparable.size());

	}

	private static void Union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			return;
		}

		parents[y] = x;

	}

	private static int find(int x) {
		if (x == parents[x])
			return x;
		int idx = find(parents[x]);
		parents[x] = idx;
		return idx;

	}

	private static void make() {

		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

	}

}
