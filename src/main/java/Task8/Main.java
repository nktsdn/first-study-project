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
import java.util.Date;
import java.util.List;


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

        for (Company company: companies) {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(company.getFoundationDate());
            String fdate = new SimpleDateFormat("dd/MM/yyyy").format(date);
            System.out.println(company.getName()+" - Дата основания "+fdate);
        }
    }

}
