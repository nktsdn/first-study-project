package Task5;
import Task5.operation.*;

import java.util.Scanner;


public class Calc {
    public static void main(String[] args) {
        try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: "); //запрашиваем первое число
        float a = scanner.nextFloat(); //получаем первое число из консоли
        System.out.println("Введите второе число: "); //запрашиваем второе число
        float b = scanner.nextFloat(); //получаем второе число из консоли
        System.out.println("Введите операцию (+, -, /, *): "); //запрашиваем действие, пока только сложение
        char operations = scanner.next().charAt(0); //получаем операцию из консоли
        float result = 0; //результат действий калькулятора

        Operation operation;
        switch (operations) {
            case '+':
                operation = new Addition();
                result = operation.getResult(a, b);
                break;
            case '-':
                operation = new Subtraction();
                result = operation.getResult(a, b);
                break;
            case '/':
                operation = new Division();
                result = operation.getResult(a, b);
                break;
            case '*':
                operation = new Multiplication();
                result = operation.getResult(a, b);
                break;
            default:
                System.err.println("Введена некорректная операция"); //выводим сообщение о неверной операции
                return;
        }
        System.out.printf("Результат: %.4f", result); //выводим в консоль результат в формате дробного числа с округлением до 4х знаков
        scanner.close();
        } catch (Exception e) {
            System.err.println("incorrect values entered"); //ловим исключение, если пользователь ввел некорректные значения, то выводим ошибку
        }
    }
}
