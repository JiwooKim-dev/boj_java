import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		
		String lines[] = new String[N];
		for (int i=0 ; i<lines.length ; i++){
			lines[i] = br.readLine();
		}
		
		int min = 64;
		
		for (int startX=0 ; startX+8 <= M ; startX++){
			for (int startY=0 ; startY+8 <= N ; startY++){
				char base = lines[startX].charAt(startY);
				int count = 0;
				for (int i=startX ; i<startX+8 ; i++){
					for (int j=startY ; j<startY+8 ; j++){
						if ((i-startX + j-startY) % 2 == 0){
							if (lines[j].charAt(i) != base){
								count++;
							}
						}
						else {
							if (lines[j].charAt(i) == base){
								count++;
							}
						}
					}
				}
				if (count < min){
					min = count;
				}
			}
		}
		
		
		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
	}
}
