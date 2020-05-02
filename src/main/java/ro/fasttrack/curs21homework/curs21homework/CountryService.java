package ro.fasttrack.curs21homework.curs21homework;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            List<String> countryNames = new ArrayList<>();
            for (Country country : countries) {
                countryNames.add(country.getName());
            }
            return countryNames;
        }

        public String getCapitalOfCountry(int id) {
            String capitalName = "";
            for (Country country : countries) {
                if (country.getId() == id) {
                    capitalName = country.getCapital();
                    break;
                }
            }
            return capitalName;
        }

        public long getPopulation(int countryId) {
		long totalPopulation = 0;
		for (Country country : countries) {
			if (country.getId() == countryId) {
				totalPopulation = country.getPopulation();
				break;
			}
		}
		return totalPopulation;
	    }

	    public List<Country> getCountriesInContinent(String continentName) {
            List<Country> countriesInContinent = new ArrayList<>();
            for (Country country : countries) {
                if (country.getContinent().equals(continentName)) {
                    countriesInContinent.add(country);
                }
            }
            return countriesInContinent;
        }

        public List<String> getNeighbours (int countryId) {
            List<String> neighbours = new ArrayList<>();
            for (Country country : countries) {
                if (country.getId() == countryId) {
                    neighbours = country.getNeighbours();
                    break;
                }
            }
            return neighbours;
        }

        public List<Country> getCountriesInContinentWithMinimumPopulation(String continentName, long minPopulation) {
            List<Country> countriesWithPopulation = new ArrayList<>();
            for (Country country : countries) {
                if (continentName.equals(country.getContinent()) && country.getPopulation() >= minPopulation) {
                    countriesWithPopulation.add(country);
                }
            }
            return countriesWithPopulation;
        }

        public List<Country> getCountriesWithNeighboursXButNotY (String includeNeighbour, String excludeNeighbour) {
            List<Country> countriesWithNeighbours = new ArrayList<>();
            for (Country country : countries) {
                if (country.getNeighbours().contains(includeNeighbour) && !country.getNeighbours().contains(excludeNeighbour)) {
                    countriesWithNeighbours.add(country);
                }
            }
            return countriesWithNeighbours;
        }

        public Map<String,Long> getCountryPopulation() {
            Map<String,Long> countriesPopulation = new HashMap<>();
            for (Country country : countries) {
                countriesPopulation.put(country.getName(), country.getPopulation());
            }
            return countriesPopulation;
        }

        public Map<String, List<Country>> getContinentCountries() {
            Map<String, List<Country>> continentCountries = new HashMap<>();
            for (Country country : countries) {
                String contName = country.getContinent();
                if (continentCountries.containsKey(contName)) {
                    continentCountries.get(contName).add(country);
                } else {
                    List<Country> countryList = new ArrayList<>();
                    countryList.add(country);
                    continentCountries.put(contName, countryList);
                }
            }
            return continentCountries;
        }

}
