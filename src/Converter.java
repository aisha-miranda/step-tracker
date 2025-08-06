public class Converter {
    static int convertToKm(int steps) {
        steps = (int) (steps * 0.00075);
        return steps;
    }

    static int convertStepsToKilocalories(int steps) {
        steps = (int) (steps * 0.05);
        return steps;
    }
}
