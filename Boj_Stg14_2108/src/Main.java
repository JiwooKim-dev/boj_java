import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int nums[] = new int[n];
		int counts[] = new int[8001];
		int sum = 0;
		for (int i=0 ; i<n ; i++){
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i];	// 산술평균을 위한 sum
		}
		
		Arrays.sort(nums);	// 중앙값, 범위 자동으로 구해짐
		
		// 최빈값
		for (int i=0 ; i<n ; i++){
			counts[nums[i] + 4000]++;
		}
		int count = 0;
		int mode = 0;
		int maxCount = counts[nums[0] + 4000];
		for (int i=0 ; i<n ; i++){
			if (counts[nums[i] + 4000] >= maxCount && nums[mode] != nums[i]){
				maxCount = counts[nums[i] + 4000];
				mode = i;
				count++;
			}
			if (count == 2) break;
		}
		
		if (maxCount == 1 && n != 1) mode = 1;
		
		bw.write(Long.toString(Math.round((float)sum / n)) + "\n");
		bw.write(Integer.toString(nums[(n - 1) / 2]) + "\n");
		bw.write(Integer.toString(nums[mode]) + "\n");
		bw.write(Integer.toString(nums[n - 1] - nums[0]));
		bw.flush();
		bw.close();
	}
}
