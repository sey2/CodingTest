import java.util.*;
import java.io.*;

class FastScanner {
	BufferedReader br;
	StringTokenizer st;
	
	public FastScanner() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}
	
	int nextInt() {
		return Integer.parseInt(next());
	}
	
	long nextLong() {
		return Long.parseLong(next());
	}
}

public class Main{	
	static int n;
	static int m;
	static boolean visited[];
	static int count;
	static ArrayList<ArrayList<Integer>> computer;

    public static void main(String[] args)throws Exception{
    	FastScanner sc=new FastScanner();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	// 노드의 수, 정점의  
    	n = sc.nextInt()+1;
    	m = sc.nextInt()+1;
    	
    	computer = new ArrayList<>();
    	
    	for(int i=0; i<n; i++)
    		computer.add(new ArrayList<Integer>());
    	
    	// 양 방향 연결
    	for(int i=0; i<m-1; i++) {	
    		int v1 = sc.nextInt();		
    		int v2 = sc.nextInt();		
    		
    		computer.get(v1).add(v2);
    		computer.get(v2).add(v1);
    	}
    	
    	bfs();
    	
    	bw.write(Integer.toString(count));
    	bw.close();
    }
    
    public static void bfs() {
    	Queue<Integer> queue = new LinkedList<>();
    	visited = new boolean[n];
    	
		queue.add(1);
		visited[1] = true;

		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			Iterator<Integer> it = computer.get(tmp).iterator();

			while (it.hasNext()) {
				int i = it.next();
				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
					count ++;
				}
			}
		}
    }
}