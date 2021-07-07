package imperative;

import java.util.Arrays;
import java.util.List;

public class Cities {
    public static void main(String[] args) {
        final List<String> cities = Arrays.asList(
            "Dehradun", "Agra", "Pauri", "Mathura", "Kolam",
                "Srinagar", "Nainital", "Almora"
        );

        // Imperative approach for searching Dehradun
        System.out.println("Imperative approach");
        boolean found = false;
        for (String city : cities) {
            if(city.equals("Dehradun")){
                found = true;
            }
        }
        System.out.println("Found Dehradun ? " + found);

        // Declarative approach for searching Dehradun
        System.out.println("Declarative approach");
        System.out.println("Found Dehradun ? " + cities.contains("Dehradun"));
    }
}
