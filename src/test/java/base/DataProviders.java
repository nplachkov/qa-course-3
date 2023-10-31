package base;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataProviders {

    //Method to read the valid users from a CSV file.
    @DataProvider(name = "validUsersFromCSV")
    public Object[][] readValidUsersFromCSV(){
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/correctUsers.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[] [] csvDataObject = new Object[csvData.size()][2];

            for (int i = 0; i < csvData.size(); i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }
        catch (IOException e){
            System.out.println("CSV file not found.");
            return null;
        } catch (CsvException e) {
            System.out.println("File not readable.");
            return null;
        }
    }

    //Method to read wrong users from a CSV file.
    @DataProvider(name = "wrongUsersFromCSV")
    public Object[][] readWrongUsersFromCSV(){
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/wrongUsers.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[] [] csvDataObject = new Object[csvData.size()][2];

            for (int i = 0; i < csvData.size(); i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }
        catch (IOException e){
            System.out.println("CSV file not found.");
            return null;
        }
        catch (CsvException e){
            System.out.println("File not readable.");
            return null;
        }
    }
    //Method to read the checkout details from a CSV file.
    @DataProvider(name = "checkoutDetailsFromCSV")
    public Object[][] readCheckoutDetailsFromCSV(){
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/checkoutDetails.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[] [] csvDataObject = new Object[csvData.size()][3];

            for (int i = 0; i < csvData.size(); i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }
        catch (IOException e){
            System.out.println("CSV file not found.");
            return null;
        }
        catch (CsvException e){
            System.out.println("File not readable.");
            return null;
        }
    }
}