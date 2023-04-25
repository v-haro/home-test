package dataProvider;

import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import java.io.FileReader;

public class DataProviderFromJson {

    @DataProvider(name = "userdata")
    public Object[][] getUserData() throws Exception {
        // Read the JSON file
        FileReader reader = new FileReader("src/test/resources/testUsers.json");
        // Parse the JSON into an array of MyUserData objects
        dataDefinition.MyUserData[] userData = new Gson().fromJson(reader, dataDefinition.MyUserData[].class);
        // Create a 2D array of test data
        Object[][] data = new Object[userData.length][1];
        for (int i = 0; i < userData.length; i++) {
            data[i][0] = userData[i];
        }
        return data;
    }

    @DataProvider(name = "userdataFailed")
    public Object[][] getUserDataFailed() throws Exception {
        // Read the JSON file
        FileReader reader = new FileReader("src/test/resources/testUsersFails.json");
        // Parse the JSON into an array of MyUserData objects
        dataDefinition.MyUserData[] userData = new Gson().fromJson(reader, dataDefinition.MyUserData[].class);
        // Create a 2D array of test data
        Object[][] data = new Object[userData.length][1];
        for (int i = 0; i < userData.length; i++) {
            data[i][0] = userData[i];
        }
        return data;
    }

    @DataProvider(name = "checkoutData")
    public Object[][] getCheckoutData() throws Exception {
        // Read the JSON file
        FileReader reader = new FileReader("src/test/resources/checkout.json");
        // Parse the JSON into an array of MyUserData objects
        dataDefinition.MyCheckOutData[] checkOutData = new Gson().fromJson(reader, dataDefinition.MyCheckOutData[].class);
        // Create a 2D array of test data
        Object[][] data = new Object[checkOutData.length][1];
        for (int i = 0; i < checkOutData.length; i++) {
            data[i][0] = checkOutData[i];
        }
        return data;
    }

}
