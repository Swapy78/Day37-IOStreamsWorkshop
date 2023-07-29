//Java program to view person by city or state using java streams

package demo;

import java.util.*;

public class PersonDictionary {
    private Map<String, List<String>> cityPersonDictionary; // Dictionary to store persons by city
    private Map<String, List<String>> statePersonDictionary; // Dictionary to store persons by state

    public PersonDictionary() {
        cityPersonDictionary = new HashMap<>(); // Initialize city-person dictionary
        statePersonDictionary = new HashMap<>(); // Initialize state-person dictionary
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

        System.out.println("Persons in California:"); // Printing persons in California
        personDictionary.getPersonsByState("California").forEach(System.out::println);
    }

	public void printSortedEntries() {
		// TODO Auto-generated method stub
		
	}
}
