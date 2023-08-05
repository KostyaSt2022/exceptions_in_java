/** 
Задача 1: Проверка пароля (Основы языка Java, операторы, ветвления)

Создайте класс PasswordVerifier. Этот класс должен содержать метод, который принимает строку пароля и проверяет его на соответствие следующим правилам:
Пароль должен быть не менее 8 символов.
Пароль должен содержать хотя бы одну цифру.
Пароль должен содержать хотя бы одну заглавную букву.
Метод должен выбрасывать исключение, если пароль не соответствует какому-либо из этих правил.
 
*/

import java.util.Scanner;
import java.util.function.Predicate;

public class PasswordVerifier{
	
	static class Password {

		private String password;

		public Password(String password) {
			this.password = password;
		}

		public boolean isValid() {
			return UpperCase.and(LengthOfEight)
					.and(OneDigit).test(this.password);
		}

		Predicate<String> OneDigit = new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t.chars().anyMatch(Character::isDigit);
			}
		};

		Predicate<String> LengthOfEight = new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t.length() >=8 ? true : false;
			}
		};

		Predicate<String> UpperCase = new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t.chars().anyMatch(Character::isUpperCase);
			}
		};
	}

	public static void main(String[] args) {

		// создание сканера для ввода
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Введите пароль для проверки: ");
		String input = keyboard.nextLine();

		// закрываем ввод
		keyboard.close();

		// проверка
		Password password = new Password(input);

		boolean validPassword = password.isValid();

		System.out.println("Пароль " + input + " - "
				+ (validPassword ? " подходящий пароль." : "неподходящий пароль."));

	}

}