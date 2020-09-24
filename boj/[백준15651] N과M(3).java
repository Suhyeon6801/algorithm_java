import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	//dfs에서 출력해주기 때문에 전역으로 뺌.
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int arr[];
	
	public static void dfs(int cnt) throws IOException {
		if (cnt == M) {
			for (int i = 0; i < M; i++)
				bw.write(Integer.toString(arr[i])+" ");//bw.write()로 출력
			bw.newLine();//개행
			return;
		}

		for (int i = 1; i <= N; i++) {
			arr[cnt] = i;
			dfs(cnt + 1);
			arr[cnt] = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		dfs(0);
		
		br.close();
		bw.flush();
		bw.close();
	}
}
