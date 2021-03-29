import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());

		Stack<Character> leftStack = new Stack<>();
		Stack<Character> rightStack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			leftStack.push(str.charAt(i));
		}

		for (int i = 0; i < M; i++) {
			String cmd = br.readLine();

			if (cmd.charAt(0) == 'P') {
				leftStack.push(cmd.charAt(2));
			} else if (cmd.charAt(0) == 'B') {
				if (!leftStack.isEmpty()) {
					leftStack.pop();
				}
			} else if (cmd.charAt(0) == 'L') {
				if (!leftStack.isEmpty()) {
					rightStack.push(leftStack.pop());
				}
			} else {
				if (!rightStack.isEmpty()) {
					leftStack.push(rightStack.pop());
				}
			}
		}

		while (!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}

		while (!rightStack.isEmpty()) {
			bw.write(rightStack.pop());
		}
		
		br.close();
		bw.close();
	}
}