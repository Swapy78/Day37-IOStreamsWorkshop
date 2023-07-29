//Java program to sort the entries in address book by city, state or zip using Java streams

package demo;

import java.util.*;
import java.util.stream.Collectors;

public class SortEntries {
    private List<Person> addressBook; // List to store the address book entries

    public SortEntries() {
        addressBook = new ArrayList<>(); // Initializing the address book
    }

    public void addPerson(Person person) {
        addressBook.add(person); // Adding a person to the address book
    }

    public List<Person> getPersonsByCity(String city) {
        // Retrieving a list of persons associated with the given city
        return addressBook.stream()
                .filter(person -> Objects.equals(person.getCity(), city))
                .collect(Collectors.toList());
    }

    public List<Person> getPersonsByState(String state) {
        // Retrieving a list of persons associated with the given state
        return addressBook.stream()
                .filter(person -> Objects.equals(person.getState(), state))
                .collect(Collectors.toList());
    }

    public List<Person> getPersonsByZip(String zip) {
        // Retrieving a list of persons associated with the given zip code
        return addressBook.stream()
                .filter(person -> Objects.equals(person.getZip(), zip))
                .collect(Collectors.toList());
    }

    public void sortByCity() {
        // Sorting the address book entries by city
        addressBook.sort(Comparator.comparing(Person::getCity, Comparator.nullsFirst(String::compareTo)));
    }

    public void sortByState() {
        // Sorting the address book entries by state
        addressBook.sort(Comparator.comparing(Person::getState, Comparator.nullsFirst(String::compareTo)));
    }

    public void sortByZip() {
        // Sorting the address book entries by zip code
        addressBook.sort(Comparator.comparing(Person::getZip, Comparator.nullsFirst(String::compareTo)));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address Book Entries:\n");

        for (Person person : addressBook) {
            sb.append(person).append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SortEntries addressBook = new SortEntries(); // Create an instance of SortEntries

        // Adding persons to the address book
        addressBook.addPerson(new Person("ABC", "New York", "New York", "12345"));
        addressBook.addPerson(new Person("DEF", "San Francisco", "California", "54321"));
        addressBook.addPerson(new Person("XYZ", "New York", "New York", "67890"));
        addressBook.addPerson(new Person("PQR", "Los Angeles", "California", "98765"));

        System.out.println("Persons in New York:");
        addressBook.getPersonsByCity("New York").forEach(System.out::println);

        System.out.println();

        System.out.println("Persons in California:");
        addressBook.getPersonsByState("California").forEach(System.out::println);

        System.out.println();

        System.out.println("Persons in zip code 12345:");
        addressBook.getPersonsByZip("12345").forEach(System.out::println);

        System.out.println();

        System.out.println("Sorted Address Book Entries (by City):");
        addressBook.sortByCity();
        System.out.println(addressBook);

        System.out.println();

        System.out.println("Sorted Address Book Entries (by State):");
        addressBook.sortByState();
        System.out.println(addressBook);

        System.out.println();

        System.out.println("Sorted Address Book Entries (by Zip):");
        addressBook.sortByZip();
        System.out.println(addressBook);
    }
}
