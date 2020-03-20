package leetcode;

import java.util.Scanner;

public class T96 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		long[] dp = new long[n+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 5;
		for(int i=4; i<n+1; i++) {
			for(int j=0; j<i; j++) {
				dp[i] += dp[j]*dp[i-1-j];
			}
		}
		System.out.println(dp[n]);
	}

}
