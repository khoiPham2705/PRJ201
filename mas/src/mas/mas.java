package mas;
import java.util.Random;
import java.util.Scanner;

public class mas {
    private static final int SIMULATIONS = 10000;
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double initialCapital = 500000000; // 500 triệu VND

        // Nhập tham số cho Startup
        System.out.print("Nhập số lượng startup đầu tư: ");
        int totalStartups = scanner.nextInt();
        System.out.print("Nhập xác suất startup thành công (vd: 0.1 cho 10%): ");
        double successProbability = scanner.nextDouble();
        System.out.print("Nhập lợi nhuận trung bình khi startup thành công (vd: 5.0 cho 500%): ");
        double meanReturn = scanner.nextDouble();
        System.out.print("Nhập độ lệch chuẩn của lợi nhuận (vd: 2.0 cho 200%): ");
        double stdDevReturn = scanner.nextDouble();

        // Nhập tham số cho Bất động sản
        System.out.print("Nhập tỷ lệ tăng trưởng trung bình hàng năm của BĐS (vd: 0.12 cho 12%): ");
        double realEstateMeanGrowth = scanner.nextDouble();
        System.out.print("Nhập độ lệch chuẩn của tỷ lệ tăng trưởng (vd: 0.02 cho 2%): ");
        double realEstateStdDev = scanner.nextDouble();

        // Nhập tham số cho Chứng khoán
        System.out.print("Nhập tỷ lệ lợi nhuận trung bình hàng năm của chứng khoán (vd: 0.15 cho 15%): ");
        double stockMeanReturn = scanner.nextDouble();
        System.out.print("Nhập độ lệch chuẩn của lợi nhuận chứng khoán (vd: 0.2 cho 20%): ");
        double stockVolatility = scanner.nextDouble();

        // Nhập tham số cho F&B
        System.out.print("Nhập số khách trung bình mỗi ngày (vd: 200): ");
        int avgCustomers = scanner.nextInt();
        System.out.print("Nhập giá trị trung bình của mỗi đơn hàng (vd: 50000 VND): ");
        double avgOrderValue = scanner.nextDouble();
        System.out.print("Nhập chi phí vận hành hàng ngày (vd: 20000000 VND): ");
        double dailyOperatingCost = scanner.nextDouble();

        scanner.close();

        // Chạy mô phỏng
        double[] startupResults = simulateStartupInvestment(totalStartups, successProbability, meanReturn, stdDevReturn, initialCapital);
        double[] realEstateResults = simulateRealEstateInvestment(1, realEstateMeanGrowth, realEstateStdDev);
        double[] stockResults = simulateStockMarketInvestment(1, stockMeanReturn, stockVolatility);
        double[] fbResults = simulateFBInvestment(avgCustomers, avgOrderValue, dailyOperatingCost);

        // Xuất kết quả
        System.out.println("\n📊 Kết quả mô phỏng:");
        System.out.printf("Startup: %.2f lần vốn đầu tư | Xác suất có lợi nhuận: %.2f%%\n", startupResults[0], startupResults[1] * 100);
        System.out.printf("Bất động sản: %.2f lần vốn đầu tư sau 10 năm | Xác suất có lợi nhuận: %.2f%%\n", realEstateResults[0], realEstateResults[1] * 100);
        System.out.printf("Chứng khoán: %.2f lần vốn đầu tư sau 10 năm | Xác suất có lợi nhuận: %.2f%%\n", stockResults[0], stockResults[1] * 100);
        System.out.printf("Ngành F&B: %.2f lần vốn đầu tư mỗi ngày | Xác suất có lợi nhuận: %.2f%%\n", fbResults[0] / initialCapital, fbResults[1] * 100);
    }

    private static double[] simulateStartupInvestment(int totalStartups, double successProbability, double meanReturn, double stdDevReturn, double initialInvestment) {
    double totalProfit = 0;
    int positiveCount = 0;

    for (int i = 0; i < SIMULATIONS; i++) {
        int successfulStartups = binomial(totalStartups, successProbability);
        double profit = 0;

        if (successfulStartups > 0) {
            for (int j = 0; j < successfulStartups; j++) {
                profit += normal(meanReturn, stdDevReturn) * (initialInvestment / totalStartups);
            }
        } else {
            // Mất toàn bộ vốn nếu tất cả startup thất bại
            profit = -initialInvestment;
        }

        totalProfit += profit;
        if (profit > 0) positiveCount++;
    }

    return new double[]{totalProfit / SIMULATIONS, (double) positiveCount / SIMULATIONS};
}

    private static double[] simulateRealEstateInvestment(double capital, double meanGrowthRate, double stdDeviation) {
        int years = 10;
        double totalReturn = 0;
        int positiveCount = 0;

        for (int i = 0; i < SIMULATIONS; i++) {
            double value = capital;
            for (int j = 0; j < years; j++) {
                value *= 1 + (meanGrowthRate + random.nextGaussian() * stdDeviation);
            }
            totalReturn += value;
            if (value > capital) positiveCount++;
        }

        return new double[]{totalReturn / SIMULATIONS, (double) positiveCount / SIMULATIONS};
    }

    private static double[] simulateStockMarketInvestment(double capital, double meanReturn, double volatility) {
        int years = 10;
        double totalReturn = 0;
        int positiveCount = 0;

        for (int i = 0; i < SIMULATIONS; i++) {
            double value = capital;
            for (int j = 0; j < years; j++) {
                value *= 1 + (meanReturn + random.nextGaussian() * volatility);
            }
            totalReturn += value;
            if (value > capital) positiveCount++;
        }

        return new double[]{totalReturn / SIMULATIONS, (double) positiveCount / SIMULATIONS};
    }

    private static double[] simulateFBInvestment(int avgCustomers, double avgOrderValue, double dailyOperatingCost) {
        double totalProfit = 0;
        int positiveCount = 0;

        for (int i = 0; i < SIMULATIONS; i++) {
            int customers = poisson(avgCustomers);
            double revenue = customers * avgOrderValue;
            double profit = revenue - dailyOperatingCost;
            totalProfit += profit;
            if (profit > 0) positiveCount++;
        }

        return new double[]{totalProfit / SIMULATIONS, (double) positiveCount / SIMULATIONS};
    }

    public static int poisson(int lambda) {
        int k = 0;
        double p = 1.0;
        double L = Math.exp(-lambda);
        do {
            k++;
            p *= random.nextDouble();
        } while (p > L);
        return k - 1;
    }

    public static int binomial(int n, double p) {
        int successes = 0;
        for (int i = 0; i < n; i++) {
            if (random.nextDouble() < p) {
                successes++;
            }
        }
        return successes;
    }

    public static double normal(double mean, double stdDev) {
        return mean + stdDev * random.nextGaussian();
    }
}
