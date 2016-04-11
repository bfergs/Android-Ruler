package bfergus.androidruler.Utils;


public class MeasurementUtils {
    public static String convertInchesToCm(String inches) {
        return Double.toString(Double.parseDouble(inches) * 2.54);
    }

    public static String convertInchesToMM(String inches) {
        return Double.toString(Double.parseDouble(inches) * 25.4);
    }
}
