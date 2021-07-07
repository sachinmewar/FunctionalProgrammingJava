package imperative;

import java.util.ArrayList;
import java.util.List;

import static imperative.Friend.Gender.FEMALE;
import static imperative.Friend.Gender.MALE;

public class Friend {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Sachin", MALE),
                new Person("Alice", FEMALE),
                new Person("Nikita", FEMALE),
                new Person("Manshi", FEMALE),
                new Person("Anjali", FEMALE),
                new Person("Shivani", FEMALE),
                new Person("Alex", MALE)
        );

        // Iterating through the list.

        // Imperative way
        System.out.println("\nImperative way");
        for(int i = 0; i < people.size(); i++){
            System.out.println(people.get(i).name);
        }

        // Bit more civilized approach
        System.out.println("\nBit more civilized approach");

        for(Person friend : people) {
            System.out.println(friend.name);
        }

        // Declarative way
        // Using forEach loop
        System.out.println("\nDeclarative way");
        people.forEach(friend -> System.out.println(friend.name));

        // Transforming a List(Converting a List into uppercase)

        final List<String> uppercaseName = new ArrayList<>();

        //Imperative approach
        for(Person friend : people){
            uppercaseName.add(friend.name.toUpperCase());
        }
        System.out.println("Uppercase Name with Imperative approach = " + uppercaseName);

        // Declarative approach
        final List<String> uppercaseName2 = new ArrayList<>();

        people.forEach(friend -> uppercaseName2.add(friend.name.toUpperCase()));
        System.out.println("Uppercase Name with declarative approach = " + uppercaseName2);

        // Imperative approach for getting names of female.
        System.out.println("\nImperative approach");
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for(Person female : females) {
            System.out.println(female);
        }

        // Declarative approach
        System.out.println("\nDeclarative approach");

        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" + "name = " + name + " " + "gender = " + gender + '}' ;
        }
    }

    enum Gender {
        FEMALE, MALE
    }
}
