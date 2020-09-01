import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hw_algo0901_서울_5반_신다정 {

	static int N;
	static int min = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        N = Integer.parseInt(br.readLine());
	        arr = new int[N][N];
	        visited = new boolean[N];
	        
	        for(int i=0; i<N; i++) {
	        	StringTokenizer st = new StringTokenizer(br.readLine());
	        	for(int j=0; j<N; j++) {
	        		arr[i][j] = Integer.parseInt(st.nextToken());
	        	}
	        }

	        c(0, 0);
	        System.out.println(min);
	        min = Integer.MAX_VALUE;
	    
	}
	
	
	static void c(int cnt, int start) {
		if(cnt == N/2) {
			
			int a = 0;
			int b = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i != j) {
						if(visited[i] == true && visited[j] == true)
							a += arr[i][j];
						if(visited[i] == false && visited[j] == false)
							b += arr[i][j];
					}
				}
			}
			
			
			min = (min > (Math.abs(a-b)))?Math.abs(a-b):min;
			return;
		}
		
		for(int i=start; i<N; i++) {
			
			visited[i] = true;
			c(cnt+1, i+1);
			visited[i] = false;
		}
		
		
		
	}
}
