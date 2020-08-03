package com.ssafy;
import java.util.Arrays;
import java.util.Scanner;
public class SWEA_9229_한빈이와SpotMart {
	static int[] Snack = new int[1000];
	static int[] number = new int[2];
	static int N, M, sum, max = 0;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			
			Snack = new int[N];
			
			for(int i=0; i<N; i++) {
				Snack[i] = sc.nextInt();
			}
			
			Arrays.sort(Snack);
			
			Comb(0, 0);
			if(max == 0) System.out.println("#"+ test_case + " " + -1);
			else System.out.println("#"+ test_case + " " + max);
			max = 0;
		}		
		
	}

	private static void Comb(int cnt, int start) {
		if(cnt == 2) {
			if(number[0] + number[1] > M) return;
			else{
				if(max < number[0] + number[1]) max = number[0] + number[1];;
				return;
			}
		}
		
		for(int i=start; i<=Snack.length-1; i++) {
			number[cnt] = Snack[i];
			Comb(cnt+1, i+1);
		}
	}

}
