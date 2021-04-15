import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static int INF = 987654321;
	static int N, P, K;
	static List<edge>[] graph;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		int from, to, cost;
		int start = 0, end = INF;
		int answer = -1;

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());

			graph[to].add(new edge(from, cost));
			graph[from].add(new edge(to, cost));
			end = Math.max(end, cost);
		}

		while (start <= end) {
			int mid = (start + end) / 2;

			if (dijkstra(mid)) {
				end = mid - 1;
				answer = mid;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(answer);

	}

	public static boolean dijkstra(int max) {
		dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dist[i] = INF;
		}

		PriorityQueue<edge> pq = new PriorityQueue<>(new Comparator<edge>() {
			@Override
			public int compare(edge e1, edge e2) {
				return e1.cost - e2.cost;
			}
		});

		dist[1] = 0;
		pq.add(new edge(1, 0));

		while (!pq.isEmpty()) {
			edge e = pq.poll();
			int cur = e.dst;
			int curCost = e.cost;

			if (dist[cur] < curCost)
				continue;

			for (int i = 0; i < graph[cur].size(); i++) {
				int next = graph[cur].get(i).dst;
				int nextCost = graph[cur].get(i).cost > max ? 1 : 0;

				if (dist[next] > dist[cur] + nextCost) {
					dist[next] = dist[cur] + nextCost;
					pq.add(new edge(next, dist[cur]));
				}
			}
		}

		return dist[N] <= K;
	}

	static class edge {
		int dst;
		int cost;

		edge(int a, int b) {
			dst = a;
			cost = b;
		}
	}
}