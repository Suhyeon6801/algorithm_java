package algorithm;

import java.io.*;
import java.util.*;

public class Main {
	static int MAX = 1000010;
	static int par[] = new int[MAX];
	
	public static int find(int x) {
		if(par[x]==x)	return x;
		else return par[x]=find(par[x]);
	}
	
	public static void merge(int x, int y) {
		x = find(x);
		y = find(y);
		par[y]=x;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for(int i=0; i<=N; i++)
			par[i]=i;
		
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(cmd==0) {
				merge(A,B);
			}
			else {
				if(find(A)==find(B))
					System.out.println("YES");
				else {
					System.out.println("NO");
				}
			}
		}
		
	}
}
