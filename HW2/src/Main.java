import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    protected static ArrayList<Student> students = new ArrayList<Student>();

    public static void Command() {
        //Вывод доступных пользователю команд.
        System.out.println("""
                Доступные команды:\s
                /h - Вывод подсказок.
                /r - Выбрать случайного студента в группе.\s
                /l - Вывести весь список студентов в группе.\s
                /end - Завершение программы.""");
    }

    public static void R() {
        int student = random.nextInt(students.size());
        if (students.get(student).getGrade() == 0) {
            System.out.println("Выбран студент - " + students.get(student).getName() + " " + students.get(student).getSurname() + ".");
            System.out.println("Студент присутствует?\n" + "Введите - yes/no.");
            String attended = scanner.next();
            //Если ответ - yes, то студент присутвует. Проставляем ему оценку.
            if ("yes".equals(attended)) {
                System.out.println("Оценка за ответ: ");
                String grade = scanner.next();
                try {
                    int mark = Integer.parseInt(grade);
                    students.get(student).setAttended(false);
                    students.get(student).setGrade(mark);
                } catch (NumberFormatException e) {
                    System.out.println("Некорректные данные!");
                }
            }
            //Если ответ - no, то студент отсутсвует. Проставляем ему оценку.
            else if ("no".equals(attended)) {
                students.get(student).setAttended(true);
                System.out.println("Студент " + students.get(student).getName() + " " + students.get(student).getSurname() + " отсутствует!");
                students.get(student).setGrade(0);
            } //Введено не "yes/no".
            else {
                System.out.println("Некорректный ввод!");
            }
        } //При выборе уже выбранного ранее студента, сообщаем о том, что он уже получил оценку.
        else {
            System.out.println("Студент " + students.get(student).getName() + " " + students.get(student).getSurname() + " уже получил оценку!");
        }
    }

    public static void L() {
        for (Student el : students) {
            System.out.println(el);
        }
    }

    public static void H() {
        Command();
    }

    public static void main(String[] args) {
        //Создаем шруппу студентов.
        for (int number = 0; number < random.nextInt(10); number++) {
            students.add(new Student("Name " + number, "Surname " + number, 0, true));
        }
        //Проверка, есть ли в группе > 0 студентов.
        if (students.size() == 0) {
            System.out.print("В группе нет студентов!");
        } else {
            //Вывод доступных пользователю команд.
            Command();
            System.out.print(">");
            String info = scanner.next();
            while (true) {
                switch (info) {
                    case ("/r") -> R();
                    case ("/l") -> L();
                    case ("/h") -> H();
                    case ("/end") -> {
                        return;
                    }
                    default -> {
                        System.out.print("Некорректный ввод! Повторите попытку!\n");
                    }
                }
                System.out.print(">");
                info = scanner.next();
            }
        }
    }
}