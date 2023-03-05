import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите первое число:");
        double num1 = getNumber(input);

        System.out.println("Введите операцию (+, -, *, /):");
        String operation = input.next();

        System.out.println("Введите второе число:");
        double num2 = getNumber(input);

        double result = 0;
        boolean error = false;
        switch (operation) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    System.out.println("Ошибка: деление на 0 невозможно");
                    error = true;
                }
                else {
                    result = num1 / num2;

                }
            }

            default -> {
                System.out.println("Ошибка: некорректная операция");
                error = true;

            }
        }

        if (!error) {
            System.out.println("Результат: " + result);
        }
    }

    public static double getNumber(Scanner input) {
        while (!input.hasNextDouble()) {
            System.out.println("Ошибка: введите число");
            input.next();
        }

        return input.nextDouble();
    }
}