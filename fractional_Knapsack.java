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
