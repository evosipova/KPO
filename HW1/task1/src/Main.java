import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("Введите размерность массива:");
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        double[] array = new double[n];
        for(int i = 0; i < n; ++i) {
            array[i] = Math.random();
        }
        System.out.println("\nМассив:");
        for(int i = 0; i < n; ++i) {
            System.out.println(array[i]);
        }
        System.out.println();
        double max = array[0]; // Массив не должен быть пустым
        double min = array[0];
        double average = 0;
        for (double el : array) {
            if (max < el)
                max = el;
            if (min > el)
                min = el;
            average += el / array.length;
        }
        System.out.println("Максимальное значение:  " + max);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Среднее значение: " + average);
    }
}
