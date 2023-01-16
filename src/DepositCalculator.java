import java.util.Scanner;

public class DepositCalculator {
    void printMenu() {
        int moneyAmount, depositType, depositPeriod;
        double finalMoneyAmount = 0;
        double yearRate = 0.06;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        moneyAmount = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();

        if (depositType == 1) {
            finalMoneyAmount = calculateSimplePercent(moneyAmount, yearRate, depositPeriod);
        } else if (depositType == 2) {
            finalMoneyAmount = calculateComplexPercent(moneyAmount, yearRate, depositPeriod);
        }

        System.out.println("Результат вклада: " + moneyAmount + " за " + depositPeriod + " лет превратятся в "
            + finalMoneyAmount);
    }

    double calculateSimplePercent(double moneyAmount, double yearRate, int depositPeriod) {
        return exponentiationPercent(moneyAmount + moneyAmount * yearRate * depositPeriod);
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double payValue = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return exponentiationPercent(payValue);
    }

    double exponentiationPercent(double payValue) {
        int degree = 2;
        double scale = Math.pow(10, degree);

        return Math.round(payValue * scale) / scale;
    }
}

