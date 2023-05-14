import java.io.*;
import java.util.*;

public class Main {
	static int count[] = new int[101];
	static int ladderAndSnake[] = new int[101];
	static boolean visited[] = new boolean[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 사다리의 수
		int m = Integer.parseInt(st.nextToken()); // 뱀의 수

		for(int i = 0; i < n+m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladderAndSnake[a] = b;
		}
		
		bfs();
	}
	
	static void bfs() {
		Queue<Integer> pq = new LinkedList<Integer>();
		pq.offer(1);
		count[1] = 0;
		visited[1] = true;
		
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			if(cur == 100) {
				System.out.println(count[cur]);
				return;
			}

			for(int i = 1; i < 7; i++) {
				int x = cur + i;
				if(100 < x) continue;
				if(visited[x]) continue;
				visited[x] = true;
				
				if(ladderAndSnake[x] != 0) { // 사다리 또는 뱀의 위치일때
					if(!visited[ladderAndSnake[x]]) {
						pq.offer(ladderAndSnake[x]);	
						visited[ladderAndSnake[x]] = true;
						count[ladderAndSnake[x]] = count[cur] + 1;
					}
				}else { //아무것도 아닐때
					pq.offer(x);
					count[x] = count[cur] + 1;
				}
			}
		}
	}

}