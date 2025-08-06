import java.util.Scanner;
public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int monthNumber = scanner.nextInt();
        if ((monthNumber<1) || (monthNumber>12)){
            System.out.println("Номер месяца введён неверно.");
            return;
        }
        System.out.println("Введите день от 1 до 30 (включительно)");
        int dayNumber = scanner.nextInt();
        if ((dayNumber<1) || (dayNumber>30)){
            System.out.println("Номер дня введён неверно.");
            return;
        }
        System.out.println("Введите количество шагов");
        int stepNumber = scanner.nextInt();
        if ((stepNumber<0) || (stepNumber == 0)){
            System.out.println("Количество шагов должно быть положительным числом.");
            return;
        }
        MonthData monthData = monthToData[monthNumber-1];
        monthData.days[dayNumber-1] = stepNumber;
    }

    void changeStepGoal(){
        int newStepGoal = scanner.nextInt();
        if ((newStepGoal<0) || (newStepGoal ==0)){
            System.out.println("Количество шагов должно быть положительным числом.");
            return;
        }
        goalByStepsPerDay = newStepGoal;
    }

    void printStatistic() {
        System.out.println("Введите число месяца.");
        int monthNumber = scanner.nextInt();
        MonthData monthData = monthToData[monthNumber-1];
        int sumSteps = monthData.sumStepsFromMonth();
        System.out.println("Общая статистика по дням: ");
        monthData.printDayAndStepsFromMonth();
        System.out.println("Сумма шагов за месяц: " + sumSteps);
        System.out.println("Максимальное количество пройденных шагов за месяц: " + monthData.maxSteps());
        System.out.println("Среднее количество пройденных шагов за месяц: " + sumSteps/30);
        System.out.println("Пройденная за месяц дистанция в км: " + Converter.convertToKm(sumSteps));
        System.out.println("Количество сожжённых килокалорий за месяц: " + Converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }
}
