import java.util.Scanner;
/**
@author Sadiulin Nikita
 @see Base
 @see #main
 */

public class Base {
    public static void main(String[] args) {
        //System.out.println("Hello world");
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the first number: "); //запрашиваем первое число
            float a = scanner.nextFloat(); //получаем первое число из консоли
            System.out.println("Enter the second number: "); //запрашиваем второе число
            float b = scanner.nextFloat(); //получаем второе число из консоли
            System.out.println("Enter operation: "); //запрашиваем действие, пока только сложение
            char operation = scanner.next().charAt(0); //получаем операцию из консоли
            float result=0; //результат действий калькулятора

            switch(operation) {
                case '+': result = a + b;
                    break;
                default:  System.out.println("incorrect operation entered"); //выводим сообщение о неверной операции
                    return;
            }
            System.out.printf("Sum is %.4f", result); //выводим в консоль сумму чисел в формате дробного числа с округлением до 4х знаков

            scanner.close();
        }
        catch (Exception e){
            System.out.println("incorrect values entered"); //ловим исключение, если пользователь ввел некорректные значения, то выводим ошибку
        }

    }
}
