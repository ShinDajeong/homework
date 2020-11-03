package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2564_경비원 {

	static class Point{
		int loc;
		int dis;
		
		public Point(int loc, int dis) {
			super();
			this.loc = loc;
			this.dis = dis;
		} 
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int calc = 2*(r+c);
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<>();
		
		for(int i=0; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

		}
		
		int answer = 0;
		
		for (int i = 0; i < list.size()-1; i++) {
			int ll = list.get(list.size()-1).loc;
			int ld = list.get(list.size()-1).dis;
			int min = 0;
			switch (list.get(i).loc) {
			
			case 1:
				if(ll == 1) {
					min = Math.abs(ld - list.get(i).dis);
				}else if(ll == 2) {
					min = Math.min(list.get(i).dis + ld + c, calc - (list.get(i).dis + ld + c));
				}else if(ll == 3) {
					min = ld + list.get(i).dis;
				}else {
					min = (r-ld) + list.get(i).dis;
				}

				break;
			case 2:
				
				if(ll == 1) {
					min = Math.min(list.get(i).dis + ld + c, calc - (list.get(i).dis + ld + c));
				}else if(ll == 2) {
					min = Math.abs(ld - list.get(i).dis);
				}else if(ll == 3) {
					min = ld + (r-list.get(i).dis);
				}else {
					min = (r-ld) + (r-list.get(i).dis);
				}
				
				
				
				break;
			case 3:
				
				if(ll == 1) {
					min = ld + list.get(i).dis;
				}else if(ll == 2) {
					min = (c-list.get(i).dis) + ld;
				}else if(ll == 3) {
					min = Math.abs(ld - list.get(i).dis);
				}else {
					min = Math.min(ld+r+list.get(i).dis, calc-(ld+r+list.get(i).dis));
				}
				
				break;
			case 4:
				
				if(ll == 1) {
					min = (r-ld) + list.get(i).dis;
				}else if(ll == 2) {
					min = (r-ld) + (c-list.get(i).dis);
				}else if(ll == 3) {
					min = Math.min(ld+r+list.get(i).dis, calc-(ld+r+list.get(i).dis));
				}else {
					min = Math.abs(ld - list.get(i).dis);
				}
				
				break;

			}
			
			answer += min;
		}
		
		System.out.println(answer);
		
	
	}

}
