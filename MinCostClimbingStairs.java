import java.util.Arrays;
import java.util.Scanner;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("-> Enter the size of cost array: ");
        int n = scanner.nextInt();

        int[] cost = new int[n];

        System.out.println("-> Enter cost: ");
        for (int i = 0; i < n; i++) {
            cost[i] = scanner.nextInt();
        }

        // Top-Down ->
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // int ans = Math.min(solve(dp, cost, n - 1), solve(dp, cost, n-2));

        int ans = solve(cost, n);
        System.out.println("Minimum cost: " + ans);

        scanner.close();
    }
    // Top-Down -->
    // private static int solve(int[] dp, int[] cost, int n) {
    // if (n == 0)
    // return cost[0];
    // if (n == 1)
    // return cost[1];

    // if (dp[n] != -1) {
    // return dp[n];
    // }

    // dp[n] = cost[n] + Math.min(solve(dp, cost, n - 1), solve(dp, cost, n - 2));

    // return dp[n];
    // }

    // Bottom-Up -->
    // private static int solve(int[] cost, int n) {
    //     int[] dp = new int[n + 1];

    //     dp[0] = cost[0];
    //     dp[1] = cost[1];

    //     for (int i = 2; i < n; i++) {
    //         dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
    //     }

    //     return Math.min(dp[n - 1], dp[n - 2]);
    // }

    // Tabulation + Space Optimization
    private static int solve(int[] cost, int n){
        int prev1 = cost[1];
        int prev2 = cost[0];

        for (int i = 2; i < n; i++) {
            int temp = prev1;
            prev1 = cost[i] + Math.min(prev1, prev2);
            prev2 = temp;
        }

        return Math.min(prev1, prev2);
    }
}
