import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int V,E;
	static int[] par = new int[10010];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=V; i++) {
			par[i]=i;
		}
		
		List<edge> e = new ArrayList<>();
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			e.add(new edge(A,B,C));
		}
		
		Collections.sort(e);
		
		int cnt=0;
		int weight=0;
		for(int i=0; i<e.size(); i++) {
			int node1 = e.get(i).from;
			int node2 = e.get(i).to;
			
			if(find(node1)!=find(node2)) {
				merge(node1, node2);
				weight+=e.get(i).cost;
				cnt++;
				
				if(cnt==V-1) {
					break;
				}
			}
		}
		
		System.out.print(weight);;
		
	}
	
	static class edge implements Comparable<edge>{
		int from;
		int to;
		int cost;
		
		public edge(int from, int to, int cost) {
			this.from=from;
			this.to=to;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(edge o) {
			return this.cost-o.cost;
		}
	}
	
	private static int find(int x) {
		if(x==par[x]) {
			return x;
		}else {
			return par[x] = find(par[x]);
		}
	}
	
	private static void merge(int x, int y) {
		x=find(x);
		y=find(y);
		
		par[y]=x;
	}
}
