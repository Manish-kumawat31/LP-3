import java.util.Scanner;

public class DP_Knapsack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] profit = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and profit: ");
            weight[i] = sc.nextInt();
            profit[i] = sc.nextInt();
        }

        System.out.print("Enter capacity: ");
        int W = sc.nextInt();

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {

                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            profit[i - 1] + dp[i - 1][w - weight[i - 1]],
                            dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Maximum Profit = " + dp[n][W]);

        sc.close();
    }
}






































































































































































/*
 * THEORY:
 * 
 * 0/1 Knapsack is an optimization problem in which we have a bag
 * with limited capacity and different items having different
 * weights and profits.
 * 
 * The main objective is to select items to get maximum profit
 * without exceeding the capacity of the bag.
 * 
 * 1. Dynamic Programming:
 * 
 * Dynamic Programming is a technique used to solve complex
 * problems by dividing them into smaller subproblems and storing
 * their results to avoid repeated calculations.
 * 
 * 2. Working:
 * - Read the weight and profit of each item.
 * - Read the maximum capacity of the knapsack.
 * - Create a DP table to store maximum profit values.
 * - Check whether the current item can fit in the knapsack.
 * - If it cannot fit, skip the item.
 * - If it can fit, compare two choices:
 * a) Include the item.
 * b) Exclude the item.
 * - Store the maximum profit in the DP table.
 * - Repeat until all items are considered.
 * - Display the maximum profit.
 * 
 * 3. Formula:
 * 
 * If weight of item is greater than capacity:
 * 
 * DP[i][W] = DP[i-1][W]
 * 
 * Otherwise:
 * 
 * DP[i][W] = max(
 * DP[i-1][W],
 * Profit[i] + DP[i-1][W-Weight[i]]
 * )
 * 
 * 4. 0/1 Knapsack:
 * 
 * In this method, each item has only two choices:
 * 0 means the item is not selected.
 * 1 means the complete item is selected.
 * 
 * We cannot take a fraction of an item.
 * 
 * 5. Example:
 * 
 * Item Weight Profit
 * A 1 15
 * B 3 20
 * C 4 30
 * D 5 35
 * 
 * Knapsack Capacity = 7
 * 
 * Possible selections:
 * A + D = Weight 6, Profit 50.
 * B + C = Weight 7, Profit 50.
 * 
 * Maximum Profit = 50.
 * 
 * 6. Time Complexity:
 * O(n * W), where n is the number of items and W is the
 * maximum capacity of the knapsack.
 * 
 * 7. Space Complexity:
 * O(n * W), for storing the dynamic programming table.
 * 
 * 8. Applications:
 * - Budget planning.
 * - Resource allocation.
 * - Cargo loading.
 * - Investment selection.
 * - Project selection.
 * 
 * Conclusion:
 * The 0/1 Knapsack problem can be solved using Dynamic Programming.
 * It compares the choices of including or excluding each item
 * and finds the maximum possible profit without exceeding the
 * knapsack capacity.
 */