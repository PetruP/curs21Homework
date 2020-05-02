package ro.fasttrack.curs21homework.curs21homework;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class CountryController {
    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping("countries")
    List<Country> getAllCountries() {
        return service.getAllCountries();
    }

    @GetMapping("countries/names")
    List<String> getAllCountryNames() {
        return service.getAllCountryNames();
    }

    @GetMapping("countries/{countryId}/capital")
    String getCapitalOfCountry(@PathVariable int countryId) {
        return service.getCapitalOfCountry(countryId);
    }

    @GetMapping("countries/{countryId}/population")
    long getPopulation(@PathVariable int countryId) {
        return service.getPopulation(countryId);
    }

    @GetMapping("continents/{continentName}/countries")
    List<Country> getCountriesInContinent (@PathVariable String continentName) {
        return service.getCountriesInContinent(continentName);
    }

    @GetMapping("countries/{countryId}/neighbours")
    List<String> getNeighbours (@PathVariable int countryId) {
        return service.getNeighbours(countryId);
    }

    @RequestMapping(value = "continents/{continentName}/countries", params = "minPopulation", method = RequestMethod.GET)
    List<Country> getCountriesInContinentWithMinimumPopulation(@PathVariable String continentName, @RequestParam("minPopulation") long minPopulation) {
        return service.getCountriesInContinentWithMinimumPopulation(continentName, minPopulation);
    }

    @RequestMapping(value = "countries", params = {"includeNeighbour", "excludeNeighbour"}, method = RequestMethod.GET)
    List<Country> getCountriesWithNeighboursXButNotY(@RequestParam("includeNeighbour") String includeNeighbour, @RequestParam("excludeNeighbour") String excludeNeighbour) {
        return service.getCountriesWithNeighboursXButNotY(includeNeighbour, excludeNeighbour);
    }

    @GetMapping("countries/population")
    Map<String, Long> getCountryPopulation() {
        return service.getCountryPopulation();
    }

    @GetMapping("continents/countries")
    Map<String, List<Country>> getContinentCountries() {
        return service.getContinentCountries();
    }

}
