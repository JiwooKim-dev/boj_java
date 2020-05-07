// 백준 10989 '수 정렬하기 3'
// Merge Sort : 시간초과

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int sorted_x[];
	
	public static void main(String[] args) throws IOException{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer tk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(tk.nextToken());
			
			int x[] = new int[n];
			sorted_x = new int[n];
			
			// 1. 점 입력받기
			for (int i=0 ; i<n ; i++){
				tk = new StringTokenizer(br.readLine());
				x[i] = Integer.parseInt(tk.nextToken());
			}
			
			// 2. 정렬하기		
			merge_sort(x, 0, n - 1);
			
			// 3. 출력하기
			for (int i=0 ; i<n ; i++){
				bw.write(x[i]+"\n");
			}
			
			bw.close();
	}
	
	private static void merge_sort(int[] x, int left, int right) {
		
		if (left < right){
			int mid = (left + right) / 2;
			merge_sort(x, left, mid);
			merge_sort(x, mid+1, right);
			merge(x, left, mid, right);
		}
	}
	
	private static void merge(int[] x, int left, int mid, int right){
		
		int i = left, j = mid+1;
		int idx = left;
		
		while(i <= mid && j <= right){
			if (x[i] < x[j]){
				sorted_x[idx++] = x[i++];
			}
			else{
				sorted_x[idx++] = x[j++];
			}
		}
		
		while(i <= mid){
			sorted_x[idx++] = x[i++];
		}
		
		while(j <= right){
			sorted_x[idx++] = x[j++];
		}
		
		for (int k=left ; k<=right ; k++){
			x[k] = sorted_x[k];
		}
	}
}
