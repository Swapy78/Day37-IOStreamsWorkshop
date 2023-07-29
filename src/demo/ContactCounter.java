//Java program to get number of contact persons i.e. count by city or state

package demo;

import java.util.*;

public class ContactCounter {
    private Map<String, List<String>> cityPersonDictionary; // Dictionary to store persons by city
    private Map<String, List<String>> statePersonDictionary; // Dictionary to store persons by state

    public ContactCounter() {
        cityPersonDictionary = new HashMap<>(); // Initializing city-person dictionary
        statePersonDictionary = new HashMap<>(); // Initializing state-person dictionary
    }

    public void addPerson(String name, String city, String state) {
        // Adding the person to the city-person dictionary
        cityPersonDictionary.computeIfAbsent(city, k -> new ArrayList<>()).add(name);

        // Adding the person to the state-person dictionary
        statePersonDictionary.computeIfAbsent(state, k -> new ArrayList<>()).add(name);
    }

    public List<String> getPersonsByCity(String city) {
        // Retrieving the list of persons associated with the given city, or an empty list if not found
        return cityPersonDictionary.getOrDefault(city, Collections.emptyList());
    }

    public List<String> getPersonsByState(String state) {
        // Retrieving the list of persons associated with the given state, or an empty list if not found
        return statePersonDictionary.getOrDefault(state, Collections.emptyList());
    }
    
    public int getPersonCountByCity(String city) {
        // Retrieving the count of persons associated with the given city
        return cityPersonDictionary.getOrDefault(city, Collections.emptyList()).size();
    }

    public int getPersonCountByState(String state) {
        // Retrieving the count of persons associated with the given state
        return statePersonDictionary.getOrDefault(state, Collections.emptyList()).size();
    }

    public static void main(String[] args) {
        PersonDictionary personDictionary = new PersonDictionary(); // Create an instance of PersonDictionary

        // Adding persons to the dictionary
        personDictionary.addPerson("ABC", "New York", "New York");
        personDictionary.addPerson("DEF", "San Francisco", "California");
        personDictionary.addPerson("XYZ", "New York", "New York");
        personDictionary.addPerson("PQR", "Los Angeles", "California");

        System.out.println("Persons in New York:"); // Printing persons in New York
        personDictionary.getPersonsByCity("New York").forEach(System.out::println);

        System.out.println();
        
        System.out.println("Person count in New York: " + personDictionary.getPersonsByCity("New York"));

        System.out.println();

        System.out.println("Persons in California:"); // Printing persons in California
        personDictionary.getPersonsByState("California").forEach(System.out::println);
        
        System.out.println();
        
        System.out.println("Person count in California: " + personDictionary.getPersonsByState("California"));
    }
}
