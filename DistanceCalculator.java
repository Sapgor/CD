import java.util.Scanner;

public class DistanceCalculator {
    private static final double EARTH_RADIUS = 6371;
//    средний радиус земли в км

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// сканер для ввода пользователя
        System.out.println("Введите координаты первой точки:");
        double shir1 = scanner.nextDouble();
        double lon1 = scanner.nextDouble();
        // координаты первой точки
        System.out.println("Введите координаты второй точки:");
        double shir2 = scanner.nextDouble();
        double lon2 = scanner.nextDouble();
        // координаты второй точки
        double distance = CD(shir1, lon1, shir2, lon2);
        System.out.println("Расстояние между точками: " + distance + " км");
        // при помощи  функции calculateDistance вычисляется расстояние

        scanner.close();
    }

    private static double CD(double shir1, double lon1, double shir2, double lon2) {
        double dshir = Math.toRadians(shir2 - shir1);
        double dLon = Math.toRadians(lon2 - lon1);
        // перевод в радианы

        double a = Math.sin(dshir / 2) * Math.sin(dshir / 2) +
                Math.cos(Math.toRadians(shir1)) * Math.cos(Math.toRadians(shir2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
}