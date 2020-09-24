import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M;
	static boolean check[] = new boolean[10];
	static int arr[] = new int[10];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dfs(0);
	}
	
	public static void dfs(int idx) {
		if(idx==M)
		{
			for(int i=0; i<idx; i++)
				System.out.print(arr[i]+" ");
			System.out.println("");
			return;
		}
		
		for(int i=1; i<=N; i++)
		{
			if(!check[i])
			{
				check[i]=true;
				arr[idx]=i;
				dfs(idx+1);
				arr[idx]=0;
				check[i]=false;
			}
		}
	}
}
