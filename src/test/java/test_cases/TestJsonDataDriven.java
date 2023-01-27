package test_cases;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class TestJsonDataDriven {

    @Test(dataProvider="dp")
    void login(String data) throws InterruptedException {
        String user[] = data.split(",");
        System.out.println(user[0]);
//        driver.get("http://thedemosite.co.uk/login.php");
//        driver.findElement(By.name("username")).sendKeys(user[0]);
//        driver.findElement(By.name("password")).sendKeys(user[1]);
//        driver.findElement(By.name("FormsButton2")).click();
        Thread.sleep(1000);

    }

//    @DataProvider(name = "dp")
    public static String[] readjson() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();

        FileReader fileReader = new FileReader("C:\\Users\\G525585\\eclipse-workspace\\XYZ_Bank\\src\\test\\resources\\data_driven\\employee.json");
        Object obj = jsonParser.parse(fileReader);

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray array = (JSONArray) jsonObject.get("address");

        String arr[] = new String[array.size()];
        for (int i = 0; i < array.size(); i++) {
            JSONObject users = (JSONObject) array.get(i);
            String username = (String) users.get("street");
            String password = (String) users.get("city");

            arr[i] = username+","+password;
        }
        return arr;
    }

    public static String getSingleJsonData(String jsonFilePath,String jsonField) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        FileReader fileReader = new FileReader(jsonFilePath);
        Object obj = jsonParser.parse(fileReader);

        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject.get(jsonField).toString();
    }

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println(getSingleJsonData(System.getProperty("user.dir")+"/src/test/resources/data_driven/employee.json","firstName"));
//        String user[] = readjson();
//        System.out.println(user[1]);
    }
}
