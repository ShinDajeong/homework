package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {
	private static int N;
	private static int L, count;
	private static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 지형의 크기
		L = Integer.parseInt(st.nextToken()); // 경사로의 길이
		count = 0; // 건설 가능한 활주로의 경우의 수
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		process();
		// printmap();

		System.out.println(count);
	}

	private static void process() {
		for (int i = 0; i < N; i++) {
			if (makeRoadBRow(i))
				++count;
			if (makeRoadByCol(i))
				++count;
		}
	}

	// 행 단위로 활주로 건설
	private static boolean makeRoadBRow(int i) {
		int beforeHeight, size; // 이전 칸의 높이, 평탄한 지형의 길이
		beforeHeight = map[i][0];
		size = 1;
		for (int j = 1; j < N; j++) {
			// 1. 이전칸과 현재칸의 높이가 같은지
			if (beforeHeight == map[i][j]) {
				++size;
			} else if (beforeHeight + 1 == map[i][j]) {
				// 2. 현재 칸이 이전 칸보다 높이가 1 높은 경우 (오르막 경사로 설치 가능한지 체크)
				if (size < L)
					return false; // 활주로 건설 불가
				beforeHeight++;
				size = 1; // 새로운 높이의 평탄한 지형 길이 1부터 시작
			} else if (beforeHeight - 1 == map[i][j]) {
				// 3. 현재 칸이 이전 칸보다 높이가 1 낮은 경우 (내리막 경사로 설치 가능한지 체크)
				int count = 0;
				for (int k = j; k < N; k++) {
					if (map[i][k] != beforeHeight - 1)
						break;
					count++; // 이전 칸의 높이와 1 차이 낮은 연속된 평탄화 지형의 길이를 카운트
				}
				if (count < L)
					return false;// 활주로 건설 불가

				j += L - 1; // 경사로 다음 칸의 위치로 제어
				beforeHeight--;
				size = 0;
			}else {
				return false;
			}
		}
		return true;
	}

	// 열 단위로 활주로 건설
	private static boolean makeRoadByCol(int i) {
		int beforeHeight, size; // 이전 칸의 높이, 평탄한 지형의 길이
		beforeHeight = map[0][i];
		size = 1;
		for (int j = 1; j < N; j++) { // j가 행첨자
			// 1. 이전칸과 현재칸의 높이가 같은지
			if (beforeHeight == map[j][i]) {
				++size;
			} else if (beforeHeight + 1 == map[j][i]) {
				// 2. 현재 칸이 이전 칸보다 높이가 1 높은 경우 (오르막 경사로 설치 가능한지 체크)
				if (size < L)
					return false; // 활주로 건설 불가
				beforeHeight++;
				size = 1; // 새로운 높이의 평탄한 지형 길이 1부터 시작
			} else if (beforeHeight - 1 == map[j][i]) {
				// 3. 현재 칸이 이전 칸보다 높이가 1 낮은 경우 (내리막 경사로 설치 가능한지 체크)
				int count = 0;
				for (int k = j; k < N; k++) {
					if (map[k][i] != beforeHeight - 1)
						break;
					count++; // 이전 칸의 높이와 1 차이 낮은 연속된 평탄화 지형의 길이를 카운트
				}
				if (count < L)
					return false;// 활주로 건설 불가

				j += L - 1; // 경사로 다음 칸의 위치로 제어
				beforeHeight--;
				size = 0;
			}else {
				return false;
			}
		}
		return true;
	}

	private static void printmap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
