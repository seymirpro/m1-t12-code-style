import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double depositAmount, double depositYearRate, int depositPeriod) {
        double pay = depositAmount * Math.pow((1 + depositYearRate / 12), 12 * depositPeriod);
        return roundUpperBound(pay, 2);
    }

    double calculateSimplePercent(double depositAmount, double depositYearRate, int depositPeriod) {
        return roundUpperBound(depositAmount + depositAmount * depositYearRate * depositPeriod, 2);
    }

    double roundUpperBound(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void printDepositInfo() {
        int depositPeriod;
        int depositType;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        double depositRevenue = 0;
        if (depositType == 1) {
            depositRevenue = calculateSimplePercent(depositAmount, 0.06, depositPeriod);
        } else if (depositType == 2) {
            depositRevenue = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в " + depositRevenue);
    }

    public static void main(String[] args) {
        new DepositCalculator().printDepositInfo();
    }
}
