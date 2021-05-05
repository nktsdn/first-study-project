package Task5;
import Task5.operation.*;

import java.util.Scanner;


public class Calc {
    public static void main(String[] args) {
        double a=0, b=0;
        char operations = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите первое число: "); //запрашиваем первое число
            a = scanner.nextDouble(); //получаем первое число из консоли
            System.out.println("Введите второе число: "); //запрашиваем второе число
            b = scanner.nextDouble(); //получаем второе число из консоли
            System.out.println("Введите операцию (+, -, /, *): "); //запрашиваем действие, пока только сложение
            operations = scanner.next().charAt(0); //получаем операцию из консоли
            scanner.close();
        } catch (Exception e) {
            System.err.println("Введено некорректное значение"); //ловим исключение, если пользователь ввел некорректные значения, то выводим ошибку
            System.exit(1); //закрываем программу
        }
        double result = calculate(a, b, operations);
        System.out.printf("Результат: %.4f", result); //выводим в консоль результат в формате дробного числа с округлением до 4х знаков
    }


    public static double calculate(double a, double b, char operations) {
        double result = 0; //результат действий калькулятора
        Operation operation;
        try {
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
                    return result;
            }
        }catch (Exception e){
            System.err.println("Ошибка выполнения операции "+e);
        }
        return result;
    }
}
