package Task6;
import java.io.*;
import java.util.*;


public class Collect {
    public static void main(String[] args) throws IOException {
        String path = "src\\main\\java\\Task6\\test.txt"; //путь к текстовому файлу со словами
        ArrayList<String> words = readFile(path); //считываем слова из файла
        statisticAndMax(words); //выводим статистику по словам
        sorting(words); //сортируем по алфавиту
    }


    public static ArrayList<String> readFile(String path) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        try {
            if (!scanner.hasNextLine()){
                System.err.println("Файл пуст");
                System.exit(1); //закрываем программу
            }else {
                while (scanner.hasNextLine()) {
                    arrayList.add(scanner.next()); //заполняем arrayList из внешнего файла
                }
            }
        }catch (Exception e){
            System.err.println("Файл содержит пробелы без текста");
            System.exit(1); //закрываем программу
        }
        scanner.close();
        return arrayList;
    }


    public static void statisticAndMax (ArrayList<String> arrayList){
        Map<String, Integer> map = new HashMap<>();
        for (String s : arrayList) {
            map.put(s, Collections.frequency(arrayList, s)); //получаем число слов в arrayList для каждого слова
        }

         System.out.println("Слово | Количество повторений");
         Map<String, Integer> pairMax = new HashMap<>();
         int max = Collections.max(map.values());//находим максимальное число повторений
         for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue() + " раз"); //выводим статистику по каждому слову
            if (pair.getValue().equals(max)) { //проверяем соответствует ли максимальному числу повторений
                pairMax.put(pair.getKey(), pair.getValue()); //пишем мапу слов с максимальным количеством повтерений, на случай если их несколько
            }
         }
         System.out.println();
         System.out.println("Слова с максимальным количеством повторений:");
         for (Map.Entry<String, Integer> pairMaxCur : pairMax.entrySet()) {
             System.out.println(pairMaxCur.getKey() + " (" + pairMaxCur.getValue() + " раз)");
        }
    }


    public static void sorting (ArrayList<String> arrayList){
        Collections.sort(arrayList); //Сортируем arrayList по алфавиту
        System.out.println();
        System.out.println("Отсортированный arrayList по алфавиту: "+arrayList);
    }


}
