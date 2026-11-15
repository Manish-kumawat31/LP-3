import java.util.*;

public class fractional_Knapsack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        double[] weight = new double[n];
        double[] profit = new double[n];
        double[] ratio = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and profit of item " + (i + 1) + ": ");
            weight[i] = sc.nextDouble();
            profit[i] = sc.nextDouble();

            ratio[i] = profit[i] / weight[i];
        }

        System.out.print("Enter knapsack capacity: ");
        double capacity = sc.nextDouble();

        // Sort items by profit/weight ratio
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (ratio[i] < ratio[j]) {

                    double temp = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = temp;

                    temp = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp;

                    temp = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp;
                }
            }
        }

        double totalProfit = 0;

        // Greedy selection
        for (int i = 0; i < n; i++) {

            if (capacity >= weight[i]) {
                totalProfit += profit[i];
                capacity -= weight[i];
            } else {
                totalProfit += ratio[i] * capacity;
                break;
            }
        }

        System.out.println("Maximum Profit = " + totalProfit);

        sc.close();
    }
}









































































































































/*
 * THEORY:
 * 
 * Fractional Knapsack is an optimization problem in which we have
 * a bag with limited capacity and different items having different
 * weights and profits.
 * 
 * The main objective is to select items to get maximum profit
 * without exceeding the capacity of the bag.
 * 
 * 1. Greedy Strategy:
 * Fractional Knapsack uses the Greedy Strategy. It selects the
 * item having the highest profit-to-weight ratio first.
 * 
 * 2. Profit-to-Weight Ratio:
 * 
 * Ratio = Profit / Weight
 * 
 * Items are arranged in descending order of their ratios.
 * 
 * 3. Working:
 * - Read the weight and profit of each item.
 * - Calculate the profit-to-weight ratio.
 * - Sort items according to the highest ratio.
 * - Select the item with the highest ratio first.
 * - If the complete item fits, take the entire item.
 * - Otherwise, take only the required fraction.
 * - Repeat until the knapsack becomes full.
 * - Calculate the total maximum profit.
 * 
 * 4. Example:
 * 
 * Item Weight Profit Ratio
 * A 10 60 6
 * B 20 100 5
 * C 30 120 4
 * 
 * Knapsack Capacity = 50 kg
 * 
 * Take item A completely = Profit 60.
 * Take item B completely = Profit 100.
 * Take 20 kg of item C = Profit 80.
 * 
 * Total Profit = 60 + 100 + 80 = 240.
 * 
 * 5. Fractional Knapsack:
 * In this method, we can take a complete item or a fraction
 * of an item according to the remaining capacity.
 * 
 * 6. Time Complexity:
 * O(n log n), because sorting the items takes O(n log n) time.
 * 
 * 7. Space Complexity:
 * O(n), for storing the items and their ratios.
 * 
 * 8. Applications:
 * - Cargo loading.
 * - Resource allocation.
 * - Budget planning.
 * - Investment selection.
 * - Filling containers with maximum value.
 * 
 * Conclusion:
 * Fractional Knapsack uses the Greedy Strategy to maximize profit.
 * It selects items according to their profit-to-weight ratio and
 * allows taking fractions of items when required.
 */