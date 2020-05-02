package ro.fasttrack.curs21homework.curs21homework;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountryReader {
        public List<Country> readCountries() throws IOException {
            File myObj = new File("/Users/petru/Downloads/SPRINGhomework/level1-1.in");
            Scanner myReader = new Scanner(myObj);
            List<Country> countryList = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split("\\|");
                String countryName = parts[0];
                String capitalName = parts[1];
                int populationNumber = Integer.parseInt(parts[2]);
                int areaSize = Integer.parseInt(parts[3]);
                String continentName = parts[4];
                ArrayList<String> neighbours = new ArrayList<String>();
                if (parts.length == 6) {
                    String neighboursName = parts[5];
                    String str[] = neighboursName.split("~");
                    for (String elem : str) {
                        neighbours.add(elem);
                    }
                }


                Country country = new Country(countryName, capitalName, populationNumber, areaSize, continentName, neighbours);
                countryList.add(country);
            }
            myReader.close();
            return countryList;
        }
}
