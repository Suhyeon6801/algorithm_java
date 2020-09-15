import java.io.*;
import java.util.*;

public class Main {
	static int MAX = 32010;
	static int indegree[] = new int[MAX];
	static ArrayList<Integer> graph[] = new ArrayList[MAX];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Integer>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			indegree[B]++;
		}

		Queue<Integer> que = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				que.add(i);
		}

		while (!que.isEmpty()) {
			int cur = que.poll();
			bw.write(cur + " ");

			for (int next : graph[cur]) {
				indegree[next]--;
				if (indegree[next] == 0)
					que.add(next);
			}
		}

		bw.write("\n");
		bw.flush();
		bw.close();
	}
}
