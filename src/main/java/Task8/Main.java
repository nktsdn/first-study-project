package Task8;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        File file = new File("src/main/java/Task8/company.json");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String str = reader.readLine();
        String jsonFile = "";
        while (str != null) {
            jsonFile += str;
            str = reader.readLine();
        }
        Gson g = new Gson();
        Type type = new TypeToken<List<Company>>(){}.getType();
        List<Company> companies = g.fromJson(jsonFile, type);

        System.out.println("Список организаций: ");
        for (Company company: companies) {
            Date foundation_date = new SimpleDateFormat("yyyy-MM-dd").parse(company.getFoundationDate());
            String fdate = new SimpleDateFormat("dd/MM/yyyy").format(foundation_date);
            System.out.println("\""+company.getName()+"\" - Дата основания "+fdate);
        }
        System.out.println("-----------------");
        writeSecurities(companies);
        System.out.println("-----------------");
        writeCompany(companies);
        System.out.println("-----------------");
        writeCurrency(companies);

    }


    public static void writeSecurities(List<Company> companies) throws ParseException {
        int count=0;
        Date currentDate = new Date();
        System.out.println("Просроченные ценные бумаги: ");
        for (Company company: companies) {
            for (int i = 0; i < company.getSecurities().size(); i++) {
                Date date_end = new SimpleDateFormat("yyyy-MM-dd").parse(company.getSecurities().get(i).getDate_end());
                if (date_end.getTime() < currentDate.getTime()){
                    System.out.println("Код бумаги: "+company.getSecurities().get(i).getId()+" Наименование орг. владельца: \""+company.getName()+"\" Дата истечения: "+company.getSecurities().get(i).getDate_end());
                    count++;
                }
            }
        }
        System.out.println("Всего просроченных бумаг: "+count);
    }

    public static void writeCompany(List<Company> companies) throws ParseException {
        System.out.println("Введите дату создания организации: ");
        Scanner scanner = new Scanner(System.in);
        String userDate = scanner.next(); //Получаем дату из консоли
        userDate=userDate.replaceAll("/", ".");
        userDate=userDate.replaceAll(",", ".");
        Date userDateFormat = new Date();
        String userDateFormatStr="";
        if (userDate.length()==10) {
            userDateFormat = new SimpleDateFormat("dd.MM.yyyy").parse(userDate); //парсим введенную дату в формат даты
            userDateFormatStr = new SimpleDateFormat("dd/MM/yyyy").format(userDateFormat);
        }
        if(userDate.length()==8) {
            userDateFormat = new SimpleDateFormat("dd.MM.yy").parse(userDate); //парсим введенную дату в формат даты
            userDateFormatStr = new SimpleDateFormat("dd/MM/yyyy").format(userDateFormat);
        }
        System.out.println("Организации, основанные после "+userDateFormatStr+" :");
        for (Company company: companies) {
            Date foundation_date = new SimpleDateFormat("yyyy-MM-dd").parse(company.getFoundationDate());//парсим дату основания организации
            if (foundation_date.getTime() > userDateFormat.getTime()){
                System.out.println("\""+company.getName()+"\" "+company.getFoundationDate());
            }
        }
    }

    public static void writeCurrency(List<Company> companies){
        System.out.println("Введите код валюты (RUB/USD/EUR): ");
        Scanner scanner = new Scanner(System.in);
        String userCurrency = scanner.next();
        Map<Integer, String> map = new HashMap<>();

        if (userCurrency.equals("RUB")||userCurrency.equals("USD")||userCurrency.equals("EUR")){
            System.out.println("Ценные бумаги, импользующие валюту "+userCurrency+" :");
            for (Company company: companies) {
                for (int i = 0; i < company.getSecurities().size(); i++) {
                    if (company.getSecurities().get(i).getCurrency().equals(userCurrency)) {
                        map.put(company.getSecurities().get(i).getId(), company.getSecurities().get(i).getCode());//пишем в мапу бумаги
                    }
                }
            }
            for (Map.Entry<Integer, String> pair : map.entrySet()) {
                System.out.println(pair.getKey()+" "+pair.getValue()); //выводим ценные бумаги
            }
        }else{
            System.err.println("Введена некорректная валюта");
        }

    }

}
