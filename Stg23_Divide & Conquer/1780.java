import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 1780 '종이의 개수'
// Divide & Conquer
// 2020.08.06

public class Main {

	static int N;
	static int[][] color;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		color = new int[N][N];

		String line;
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < N; j++) {
				color[i][j] = Integer.parseInt("" + line.charAt(j));
			}
		}

		bw.write(sb.toString());

		br.close();
		bw.close();
	}
}
