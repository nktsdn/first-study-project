import java.util.Scanner;
/**
@author Sadiulin Nikita
 @see Base
 @see #main
 */

public class Base {
    public static void main(String[] args) {
        //System.out.println("Hello world");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какую программу запустить? (1-калькулятор, 2-поиск максимального элемента в массиве): "); //запрашиваем какую программу запустить
        byte flag = scanner.nextByte();

        if (flag==1) {
            try {
                System.out.println("Введите первое число: "); //запрашиваем первое число
                float a = scanner.nextFloat(); //получаем первое число из консоли
                System.out.println("Введите второе число: "); //запрашиваем второе число
                float b = scanner.nextFloat(); //получаем второе число из консоли
                System.out.println("Введите операцию (+, -, /, *): "); //запрашиваем действие, пока только сложение
                char operation = scanner.next().charAt(0); //получаем операцию из консоли
                float result = 0; //результат действий калькулятора

                switch (operation) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    default:
                        System.out.println("Введена некорректная операция"); //выводим сообщение о неверной операции
                        return;
                }
                System.out.printf("Результат: %.4f", result); //выводим в консоль результат в формате дробного числа с округлением до 4х знаков

                scanner.close();
            } catch (Exception e) {
                System.out.println("incorrect values entered"); //ловим исключение, если пользователь ввел некорректные значения, то выводим ошибку
            }
        }


        if (flag==2){
            System.out.println("Введите количество слов в массиве: "); //запрашиваем количество слов в массиве
            int num = scanner.nextInt(); //получаем количество слов в массиве
            String[] mass = new String[num]; //создаем и инициализируем массив слов
            for (int i=0;i<num;i++){
                System.out.println("Введите "+(i+1)+"-ое слово: "); //запрашиваем ввод слов
                mass[i]=scanner.next(); //заполняем массив слов
            }
            //ищем самое длинное слово в массиве
            int maxLeng=mass[0].length();
            int maxIndex=0;
            for (int i=1;i<num;i++){
                if (mass[i].length()>maxLeng){
                    maxLeng=mass[i].length();
                    maxIndex=i;
                }
            }
            System.out.println("Самое длинное слово в массиве: "+mass[maxIndex]); //выводим самое длинное слово
        }

    }
}
