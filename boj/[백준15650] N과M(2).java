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
		
		dfs(1,0);
	}
	
	public static void dfs(int idx, int cnt) {
		if(cnt==M)
		{
			for(int i=0; i<M; i++)
				System.out.print(arr[i]+" ");
			System.out.println("");
			return;
		}
		
		for(int i=idx; i<=N; i++)
		{
			if(!check[i])
			{
				check[i]=true;
				arr[cnt]=i;
				dfs(i, cnt+1);
				arr[cnt]=0;
				check[i]=false;
			}
		}
	}
}
