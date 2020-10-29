package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890_���� {
	private static int N;
	private static int L, count;
	private static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // ������ ũ��
		L = Integer.parseInt(st.nextToken()); // ������ ����
		count = 0; // �Ǽ� ������ Ȱ�ַ��� ����� ��
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

	// �� ������ Ȱ�ַ� �Ǽ�
	private static boolean makeRoadBRow(int i) {
		int beforeHeight, size; // ���� ĭ�� ����, ��ź�� ������ ����
		beforeHeight = map[i][0];
		size = 1;
		for (int j = 1; j < N; j++) {
			// 1. ����ĭ�� ����ĭ�� ���̰� ������
			if (beforeHeight == map[i][j]) {
				++size;
			} else if (beforeHeight + 1 == map[i][j]) {
				// 2. ���� ĭ�� ���� ĭ���� ���̰� 1 ���� ��� (������ ���� ��ġ �������� üũ)
				if (size < L)
					return false; // Ȱ�ַ� �Ǽ� �Ұ�
				beforeHeight++;
				size = 1; // ���ο� ������ ��ź�� ���� ���� 1���� ����
			} else if (beforeHeight - 1 == map[i][j]) {
				// 3. ���� ĭ�� ���� ĭ���� ���̰� 1 ���� ��� (������ ���� ��ġ �������� üũ)
				int count = 0;
				for (int k = j; k < N; k++) {
					if (map[i][k] != beforeHeight - 1)
						break;
					count++; // ���� ĭ�� ���̿� 1 ���� ���� ���ӵ� ��źȭ ������ ���̸� ī��Ʈ
				}
				if (count < L)
					return false;// Ȱ�ַ� �Ǽ� �Ұ�

				j += L - 1; // ���� ���� ĭ�� ��ġ�� ����
				beforeHeight--;
				size = 0;
			}else {
				return false;
			}
		}
		return true;
	}

	// �� ������ Ȱ�ַ� �Ǽ�
	private static boolean makeRoadByCol(int i) {
		int beforeHeight, size; // ���� ĭ�� ����, ��ź�� ������ ����
		beforeHeight = map[0][i];
		size = 1;
		for (int j = 1; j < N; j++) { // j�� ��÷��
			// 1. ����ĭ�� ����ĭ�� ���̰� ������
			if (beforeHeight == map[j][i]) {
				++size;
			} else if (beforeHeight + 1 == map[j][i]) {
				// 2. ���� ĭ�� ���� ĭ���� ���̰� 1 ���� ��� (������ ���� ��ġ �������� üũ)
				if (size < L)
					return false; // Ȱ�ַ� �Ǽ� �Ұ�
				beforeHeight++;
				size = 1; // ���ο� ������ ��ź�� ���� ���� 1���� ����
			} else if (beforeHeight - 1 == map[j][i]) {
				// 3. ���� ĭ�� ���� ĭ���� ���̰� 1 ���� ��� (������ ���� ��ġ �������� üũ)
				int count = 0;
				for (int k = j; k < N; k++) {
					if (map[k][i] != beforeHeight - 1)
						break;
					count++; // ���� ĭ�� ���̿� 1 ���� ���� ���ӵ� ��źȭ ������ ���̸� ī��Ʈ
				}
				if (count < L)
					return false;// Ȱ�ַ� �Ǽ� �Ұ�

				j += L - 1; // ���� ���� ĭ�� ��ġ�� ����
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
