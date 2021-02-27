import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> st = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		long sum = 0;

		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(br.readLine());

			while (!st.isEmpty()) {
				if (st.peek() <= height) {
					st.pop();
				} else {
					break;
				}
			}

			sum += st.size();
			st.add(height);
		}

		System.out.print(sum);
	}
}
