// Задача 2:
// Напишите программу, которая запрашивает у пользователя два числа и выполняет их деление.
// Если второе число равно нулю, программа должна выбрасывать исключение DivisionByZeroException с сообщением "Деление на ноль недопустимо". 
// В противном случае, программа должна выводить результат деления.

import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double dividend = inputNumber(scanner, "Введите делимое: ");
        double divisor = inputNumber(scanner, "Введите делитель: ");
        try {
            double result = divide(dividend, divisor);
            System.out.printf("%.2f / %.2f = %.2f\n", dividend, divisor, result);
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double inputNumber(Scanner scanner, String message) {
        double number = 0.0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                number = Double.parseDouble(input);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: некорректный ввод.");
            }
        }
        return number;
    }

    public static double divide(double dividend, double divisor) throws DivisionByZeroException {
        if (divisor == 0) {
            throw new DivisionByZeroException("Деление на ноль недопустимо.");
        }
        return dividend / divisor;
    }
}

class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}