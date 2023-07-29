//Java program to ensure that there is no duplicate entry of same person using java streams

package demo;

import java.util.*;
import java.util.stream.Collectors;

class AddressBookList {
    private List<Person> contacts;

    public AddressBookList() {
        contacts = new ArrayList<>();
    }

    public void addPerson(Person person) {
        // Checking if the person already exists in the contacts list
        if (contacts.stream().anyMatch(p -> p.equals(person))) {
            System.out.println("Duplicate entry found. Person not added.");
        } else {
            // Adding the person to the contacts list
            contacts.add(person);
            System.out.println("Person added successfully.");
        }
    }

    public List<Person> getAllPersons() {
        // Returning the list of distinct persons using Java streams
        return contacts.stream().distinct().collect(Collectors.toList());
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
   
      
        private String city;
        private String state;
        private String zip;

        public Person(String name, String city, String state, String zip) {
            this.name = name;
            this.city = city;
            this.state = state;
            this.zip = zip;
        }

        // Getters and setters

        

        public void setName(String name) {
            this.name = name;
        }

     

        public void setCity(String city) {
            this.city = city;
        }

       

        public void setState(String state) {
            this.state = state;
        }

       

        public void setZip(String zip) {
            this.zip = zip;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
        }
    


    @Override
    public boolean equals(Object obj) {
        // Checking if two Person objects are equal based on their names
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        // Generating hash code based on the name
        return Objects.hash(name);
    }

	public String getCity() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getState() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getZip() {
		// TODO Auto-generated method stub
		return null;
	}
}

public class NoDuplicateEntry {
    private Map<String, AddressBookList> addressBooks;

    public NoDuplicateEntry() {
        addressBooks = new HashMap<>();
    }

    public void addAddressBook(String name) {
        // Creating a new address book and add it to the addressBooks map
        addressBooks.put(name, new AddressBookList());
        System.out.println("Address book '" + name + "' created successfully!");
    }

    public void addPersonToAddressBook(String addressBookName, String personName) {
        // Getting the address book by name from the addressBooks map
        AddressBookList addressBook = addressBooks.get(addressBookName);
        if (addressBook != null) {
            // Creating a new person and add it to the address book
            Person person = new Person(personName);
            addressBook.addPerson(person);
        } else {
            System.out.println("Address book not found. Person not added.");
        }
    }

    public void printAllPersons() {
        if (addressBooks.isEmpty()) {
            System.out.println("No address books found!");
            return;
        }

        // Iterating over each address book and print all persons in each address book
        addressBooks.forEach((addressBookName, addressBook) -> {
            List<Person> persons = addressBook.getAllPersons();
            if (persons.isEmpty()) {
                System.out.println("No persons found in address book '" + addressBookName + "'.");
            } else {
                System.out.println("Address book '" + addressBookName + "' persons:");
                persons.forEach(person -> System.out.println(person.getName()));
            }
            System.out.println("------------");
        });
    }

    public static void main(String[] args) {
        NoDuplicateEntry noDuplicateEntry = new NoDuplicateEntry();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1 to add a new address book");
            System.out.println("Enter 2 to add a person to an existing address book");
            System.out.println("Enter 3 to print all persons");
            System.out.println("Enter 4 to exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the new address book: ");
                    String addressBookName = sc.nextLine();
                    noDuplicateEntry.addAddressBook(addressBookName);
                    break;
                case 2:
                    System.out.print("Enter the name of the address book to add the person: ");
                    String existingAddressBookName = sc.nextLine();
                    System.out.print("Enter the name of the person: ");
                    String personName = sc.nextLine();
                    noDuplicateEntry.addPersonToAddressBook(existingAddressBookName, personName);
                    break;
                case 3:
                    noDuplicateEntry.printAllPersons();
                    break;
                case 4:
                    System.out.println("Exited");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
