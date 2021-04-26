import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	static int n, m;
	static int[][] paper;
	static boolean[][] visited;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static int maxDrawing = 0;
	static int drawingCnt=0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		paper = new int[m + 1][n + 1];
		visited = new boolean[m + 1][n + 1];

		for (int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < input.length; j++) {
				paper[i][j] = Integer.parseInt(input[j]);
			}
		}

		int num = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && paper[i][j] == 1) {
					drawingCnt=0;
					dfs(i, j);
					num++;	
					maxDrawing = Math.max(drawingCnt, maxDrawing);
				}
			}
		}

		bw.write(num - 1 + " " + maxDrawing);
		bw.close();
		br.close();
	}

	public static void dfs(int y, int x) {
		visited[y][x] = true;
		drawingCnt++;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || nx < 0 || ny >= m || nx >= n)
				continue;
			if (!visited[ny][nx] && paper[ny][nx] == 1) {
				dfs(ny, nx);
			}
		}
	}
}