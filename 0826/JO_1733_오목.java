package com.ssafy;

import java.util.Scanner;

//DFS
//8방? 4방!! <-- 왼쪽 위부터 내려오므로 
//정올 제출 시, Accept..??
public class JO_1733_오목 {

 static int ans, ansY, ansX;
 static boolean found = false;
 static int N = 19;
 static int[][] map;
 static int[] dy = { 0, 1, 1,  1}; // 우, 우하, 하, 좌하
 static int[] dx = { 1, 1, 0, -1};

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     map = new int[N+1][N+1];

     for(int i=1; i<=N; i++) {
         for(int j=1; j<=N; j++) {
             map[i][j] = sc.nextInt();
         }
     }

     for(int i=1; i<=N; i++) {
         for(int j=1; j<=N; j++) {
             if( map[i][j] != 0 && !found ) {
                 search(i, j);
             }
         }
     }

     System.out.println(ans);
     if(ans != 0) {
         System.out.println(ansY + " " + ansX);
     }

     sc.close();
 }

public static void search(int y, int x) {
 
 for(int i=0; i<4; i++) {
     
     int cnt = 1;
     int ny = y;
     int nx = x;
     
     for(int k=1; k<=5; k++) {
         ny = ny + dy[i];
         nx = nx + dx[i];

         // 범위를 벗어나거나, 알이 달라지면 break
         if( ny < 0 || ny > N || nx < 0 || nx > N || map[ny][nx] != map[y][x] ) break;
         
         cnt++;
     }
     
     if( cnt == 5 ) {
         
         if( watchBack(y, x, i) ) {
             found = true;
         
             ans = map[y][x];
             
             if( i == 3 ) {
                 ansY = y + 4;
                 ansX = x - 4;
             }else {
                 ansY = y;
                 ansX = x;
             }
             
             break;
         }

     }
 }
}

static boolean watchBack(int y, int x, int d) {
 int by = y - dy[d];
 int bx = x - dx[d];
 
 if( map[by][bx] != map[y][x] ) return true;
 else return false;
}
}

/*

http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1006&sca=99&sfl=wr_hit&stx=1733

0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 1 2 0 0 2 2 2 1 0 0 0 0 0 0 0 0 0 0
0 0 1 2 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0
0 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 2 2 0 0 0 0 0 0 0 0 0 0 0 0
0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 2 1 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

1
3 2

정올 제출 시 Accept 결과가 나오며 아래의 테스트 결과를 보여줌
문제의 출력은 세로는 위 좌표를 표시하라고 했는데 정올의 답이 이상해 보임
의견 수렴 필요.
========[d4.out]=========
=> Input Data top 100 lines
0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 0 0 
0 0 2 1 0 1 1 2 2 2 1 0 0 0 0 0 0 0 0 
0 0 0 0 2 1 0 0 1 2 2 2 0 0 0 0 0 0 0 
0 0 0 0 0 1 2 1 1 1 1 2 0 0 0 2 0 0 0 
0 0 0 0 1 1 1 1 0 2 1 1 1 1 2 0 0 0 0 
0 0 0 0 0 2 0 1 0 2 0 1 2 2 0 0 0 0 0 
0 0 0 0 0 0 0 2 2 0 0 1 2 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0 0 0 1 2 1 2 1 2 1 2 1 2 1 2 1 2 1 2 
0 0 0 1 2 1 2 1 2 1 2 1 2 1 2 1 2 1 2 
0 0 1 2 1 2 1 2 1 2 1 2 1 2 1 2 1 2 0 
0 1 2 1 2 1 2 1 2 1 2 1 2 1 2 1 2 0 0 
1 2 1 2 1 2 1 2 1 2 1 2 1 2 1 2 0 0 0 

=> Solution Data top 100 lines
2
8 12

=> User Output top 100 lines
2
4 16

*/

