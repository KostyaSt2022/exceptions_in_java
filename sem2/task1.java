// Задача 1:
// Напишите программу, которая запрашивает у пользователя число и проверяет, 
// является ли оно положительным. Если число отрицательное или равно нулю, программа должна выбрасывать исключение InvalidNumberException
// с сообщением "Некорректное число". В противном случае, программа должна выводить сообщение "Число корректно".

import java.util.InputMismatchException;
import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            try {
                System.out.print("Введите положительное число: ");
                double num = scanner.nextDouble();
                if (num <= 0) {
                    throw new InvalidNumberException("Некорректное число.");
                }
                System.out.println("Число корректное.");
            } catch (InvalidNumberException e) {
                System.out.println(e.getMessage());
            } 
              catch (InputMismatchException e) {
                System.out.println("Некорректный ввод.");
                scanner.nextLine();
            }
        }
        
    }

    static class InvalidNumberException extends Exception {
        public InvalidNumberException(String message) {
            super(message);
        }
    }
}