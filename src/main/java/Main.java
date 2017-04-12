import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) throws ParseException {
        // write your code here

        JSONParser parser = new JSONParser();

        try {
            URL url = new URL("http://lukaszogan.com/data.json");
            URLConnection connection = url.openConnection();

            //Standardowa procedura gdy chcemy połączyć się z jakimś źródłem
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(connection.getInputStream()));

         //   in.lines().forEach(System.out::println);

            String line;
            while ((line = in.readLine()) != null){

                JSONArray array = (JSONArray) parser.parse(line);
                for (Object obj: array){
                    JSONObject jsonObject = (JSONObject) obj;

                    System.out.println("ID posta " + jsonObject.get("ID") + ";"+
                            " \nData: \n"+ jsonObject.get("post_date") +
                            " \nTytul: \n" + jsonObject.get("post_title"));
                }


            }

        }catch (IOException err){

        }


    }
}
