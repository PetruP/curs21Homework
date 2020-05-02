package ro.fasttrack.curs21homework.curs21homework;

import java.util.ArrayList;
import java.util.Objects;

public class Country {
        private static int COUNT = 0;
        private final int id;
        private final String name;
        private final String capital;
        private final long population;
        private final long area;
        private final String continent;
        private final ArrayList<String> neighbours;

        public Country(String name, String capital, int population, int area, String continent, ArrayList<String> neighbours) {
            this.id = COUNT++;
            this.name = name;
            this.capital = capital;
            this.population = population;
            this.area = area;
            this.continent = continent;
            this.neighbours = neighbours;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getCapital() {
            return capital;
        }

        public long getPopulation() {
            return population;
        }

        public long getArea() {
            return area;
        }

        public String getContinent() {
            return continent;
        }

        public ArrayList<String> getNeighbours() {
            return neighbours;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Country country = (Country) o;
            return id == country.id &&
                    population == country.population &&
                    area == country.area &&
                    name.equals(country.name) &&
                    capital.equals(country.capital) &&
                    continent.equals(country.continent) &&
                    neighbours.equals(country.neighbours);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, capital, population, area, continent, neighbours);
        }
}
