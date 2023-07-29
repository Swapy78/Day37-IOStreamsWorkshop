//Java program to sort the entries in the address book alphabetically by Person’s name using streams

package demo;

import java.util.*;

public class AlphabeticalSort {
    private Map<String, List<String>> cityPersonDictionary; // Dictionary to store persons by city
    private Map<String, List<String>> statePersonDictionary; // Dictionary to store persons by state

    public AlphabeticalSort() {
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
    
    public void printSortedEntries() {
        List<String> sortedEntries = new ArrayList<>();
        
        // Collecting all the persons' names from the dictionaries
        cityPersonDictionary.values().forEach(sortedEntries::addAll);
        statePersonDictionary.values().forEach(sortedEntries::addAll);
        
        // Sorting the entries alphabetically by name
        Collections.sort(sortedEntries);
        
        // Printing the sorted entries
        sortedEntries.forEach(System.out::println);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address Book Entries:\n");

        List<String> sortedEntries = new ArrayList<>();

        // Collecting all the persons' names from the dictionaries
        cityPersonDictionary.values().forEach(sortedEntries::addAll);
        statePersonDictionary.values().forEach(sortedEntries::addAll);

        // Sorting the entries alphabetically by name
        Collections.sort(sortedEntries);

        // Constructing the string representation of the address book entries
        for (String name : sortedEntries) {
            sb.append(name).append("\n");
        }

        return sb.toString();
    }

    

    public static void main(String[] args) {
        AlphabeticalSort personDictionary = new AlphabeticalSort(); // Create an instance of AlphabeticalSort

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

        System.out.println();

        System.out.println("Sorted Address Book Entries:");
        personDictionary.printSortedEntries();

        System.out.println();

        System.out.println(personDictionary);
    }

		
	
}