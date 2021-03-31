import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int MAX = 60;
	static int INF = 987654321;
	static int N, M;
	static int[][] city;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static ArrayList<Pos> chicken = new ArrayList<>();
	static ArrayList<Pos> house = new ArrayList<>();
	static boolean[] isSelected;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		city = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < input.length; j++) {
				int info = Integer.parseInt(input[j]);
				city[i][j + 1] = info;

				if (info == 1) {
					house.add(new Pos(i, j + 1));
				} else if (info == 2) {
					chicken.add(new Pos(i, j + 1));
				}
			}
		}

		isSelected = new boolean[chicken.size()];
		result = INF;
		dfs(0, 0);

		System.out.println(result);
	}

	public static int getDistance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	public static void dfs(int cnt, int idx) {
		if (cnt == M) {
			ArrayList<Pos> selectChicken = new ArrayList<>();
			for (int i = 0; i < chicken.size(); i++) {
				if (isSelected[i]) {
					selectChicken.add(new Pos(chicken.get(i).y, chicken.get(i).x));
				}
			}
			
			int distSum = 0;
			for (int i = 0; i < house.size(); i++) {
				int hy = house.get(i).y;
				int hx = house.get(i).x;
				int distMin = INF;

				for (int j = 0; j < selectChicken.size(); j++) {
					int cy = selectChicken.get(j).y;
					int cx = selectChicken.get(j).x;
					distMin = Math.min(distMin, getDistance(hy, hx, cy, cx));
				}

				distSum += distMin;
			}

			result = Math.min(result, distSum);

			return;
		}

		for (int i = idx; i < chicken.size(); i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				dfs(cnt + 1, i);
				isSelected[i] = false;
			}
		}
	}

	static class Pos {
		int y;
		int x;

		Pos(int a, int b) {
			y = a;
			x = b;
		}
	}
}