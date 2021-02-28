import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> inCars = new HashMap<>();
		int[] outCars = new int[N + 1];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			inCars.put(input, i);
		}

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			outCars[i] = inCars.get(input);
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (outCars[i] > outCars[j]) {
					cnt++;
					break;
				}
			}
		}

		System.out.print(cnt);
	}
}
