package ro.fasttrack.curs21homework.curs21homework;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CountryService {
        private final List<Country> countries = new ArrayList<>();

        public CountryService() throws IOException {
            countries.addAll(new CountryReader().readCountries());
        }

        public List<Country> getAllCountries() {
            return countries;
        }


        public List<String> getAllCountryNames() {
            List<String> countryNames = countries
                    .stream()
                    .map(Country::getName)
                    .collect(Collectors.toList());
            return countryNames;
        }

        public String getCapitalOfCountry(int id) {
            List<Country> countriesById = countries
                    .stream()
                    .filter(country -> country.getId() == id)
                    .collect(Collectors.toList());
            String capitalName = "";
            if (countriesById.size() == 1) {
                capitalName = countriesById.get(0).getCapital();
            }
            return capitalName;
        }

        public long getPopulation(int countryId) {
            List<Country> countriesById = countries
                    .stream()
                    .filter(country -> country.getId() == countryId)
                    .collect(Collectors.toList());
            long totalPopulation = 0;
            if (countriesById.size() == 1) {
                totalPopulation = countriesById.get(0).getPopulation();
            }
            return totalPopulation;
	    }

	    public List<Country> getCountriesInContinent(String continentName) {
            List<Country> countriesInContinent = countries
                    .stream()
                    .filter(country -> country.getContinent().equals(continentName))
                    .collect(Collectors.toList());
            return countriesInContinent;
        }

        public List<String> getNeighbours (int countryId) {
            List<Country> countriesById = countries
                    .stream()
                    .filter(country -> country.getId() == countryId)
                    .collect(Collectors.toList());
            List<String> neighbours = new ArrayList<>();
            if (countriesById.size() == 1) {
                neighbours = countriesById.get(0).getNeighbours();
            }
            return neighbours;
        }

        public List<Country> getCountriesInContinentWithMinimumPopulation(String continentName, long minPopulation) {
            List<Country> countriesWithPopulation = countries
                    .stream()
                    .filter(country -> continentName.equals(country.getContinent()) && country.getPopulation() >= minPopulation)
                    .collect(Collectors.toList());
            return countriesWithPopulation;
        }

        public List<Country> getCountriesWithNeighboursXButNotY (String includeNeighbour, String excludeNeighbour) {
            List<Country> countriesWithNeighbours = countries
                    .stream()
                    .filter(country -> country.getNeighbours().contains(includeNeighbour) && !country.getNeighbours().contains(excludeNeighbour))
                    .collect(Collectors.toList());
            return countriesWithNeighbours;
        }

        public Map<String,Long> getCountryPopulation() {
            Map<String,Long> countriesPopulation = countries
                    .stream()
                    .collect(Collectors.toMap(Country::getName, Country::getPopulation));
            return countriesPopulation;
        }

        public Map<String, List<Country>> getContinentCountries() {
            Map<String, List<Country>> continentCountries = countries
                    .stream()
                    .collect(Collectors.groupingBy(Country::getContinent, Collectors.toList()));
            return continentCountries;
        }

}
