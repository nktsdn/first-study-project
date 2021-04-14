package Task4_2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Task4_2 {

    public static void main(String[] args) throws IOException {
        gift();
    }

    public static void gift() throws IOException {
        ArrayList<Sweets> sweets = new ArrayList<Sweets>();
        boolean finished = false;
        double totalWeight=0; //Общий вес подарка
        double totalPrice=0; //Общая цена подарка
        Sweets candy = new Sweets("Шоколадные конфеты", 750.50, 250.10, "Вишневые");
        Sweets jellybean = new Sweets("Жевательные конфеты", 150.40, 53.15, "Апельсиновые");
        Sweets chocolate = new Sweets("Шоколад", 2000.50, 730.20, "С орехами");
        Sweets cake = new Sweets("Пирожное", 350.20, 550.40, "Сметанное");

        System.out.println("Добавить сладость в подарок: 1-Шоколадные конфеты; 2-Жевательные конфеты; 3-Шоколад; 4-Пирожное; 5-Закончить выбор"); //
        Scanner scanner = new Scanner(System.in);


        while (!finished) {
            byte flag = scanner.nextByte();
            switch (flag) {
                case 1:
                    sweets.add(candy);
                    totalWeight=totalWeight+candy.getWeight();
                    totalPrice=totalPrice+candy.getPrice();
                    System.out.println(candy.getName() + " добавлен в подарок");
                    break;
                case 2:
                    sweets.add(jellybean);
                    totalWeight=totalWeight+candy.getWeight();
                    totalPrice=totalPrice+candy.getPrice();
                    System.out.println(jellybean.getName() + " добавлен в подарок");
                    break;
                case 3:
                    sweets.add(chocolate);
                    totalWeight=totalWeight+candy.getWeight();
                    totalPrice=totalPrice+candy.getPrice();
                    System.out.println(chocolate.getName() + " добавлен в подарок");
                    break;
                case 4:
                    sweets.add(cake);
                    totalWeight=totalWeight+candy.getWeight();
                    totalPrice=totalPrice+candy.getPrice();
                    System.out.println(cake.getName() + " добавлен в подарок");
                    break;
                case 5:
                    finished = true;
                    System.out.println("Подарок собран");
                    break;
                default:
                    System.out.println("Введено некорректное значение");
                    return;
            }
        }

        System.out.println("Подарок состоит из: ");
        int count=0;
        for (Sweets sweet:sweets) {
            count++;
            System.out.println(count + ". " + sweet.getName() + " " + sweet.getUniqueParameter());
        }
        System.out.printf("Общий вес подарка: %.2f \n", totalWeight);
        System.out.printf("Общая стоимость подарка: %.2f", totalPrice);

    }
}
