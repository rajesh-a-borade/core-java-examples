package rajesh.lambda.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

@FunctionalInterface
interface MyComparator<T> {
	
	public abstract int compare(Person t1, Person t2);
	
	public static MyComparator<Person> comparing(Function<Person, String> extractFunction) {
		return (p1, p2) -> {
			String s1 = extractFunction.apply(p1);
			String s2 = extractFunction.apply(p2);
			return s1.compareTo(s2);
		};
	}

	public default MyComparator<Person> thenComparing(Function<Person, String> otherFunction) {
		
		return (p1, p2) -> {
            int cmp = this.compare(p1, p2);
            if (cmp == 0) {
            	MyComparator<Person> other = comparing(otherFunction);
                return other.compare(p1, p2);
            } else {
                return cmp;
            }
        };
	}
	
}


public class ComparatorChainTest {

	public static void main(String[] args) {
	
		Function<Person, String> getFirstNameFunction = p -> p.getFirstName();
		Function<Person, String> getLastNameFunction = p -> p.getLastName();
		Function<Person, String> getAgeFunction = p -> "" + p.getAge(); // hack
		
		MyComparator<Person> personComparator =
				MyComparator.comparing(getFirstNameFunction)
							.thenComparing(getLastNameFunction)
							.thenComparing(getAgeFunction);
		
		List<Person> listOfPeople = new ArrayList<>();
		listOfPeople.add(new Person(1, "A", "Z", 9));
		listOfPeople.add(new Person(2, "A", "Y", 77));
		listOfPeople.add(new Person(3, "C", "X", 7));
		listOfPeople.add(new Person(4, "A", "Y", 66));
		
		listOfPeople.stream()
					.sorted(new DynamicPersonComparator(personComparator))
					.forEach(System.out::println);
		
		listOfPeople.add(new Person(5, null, "Y", 66));
		
		Comparator<Person> combinedComparator = Comparator.comparing(Person::getFirstName, Comparator.nullsFirst(Comparator.naturalOrder()))
					.thenComparing(Person::getLastName)
					.thenComparing(Person::getAge);
		
		listOfPeople.stream()
			// .sorted(new DynamicPersonComparator(personComparator)) // throws exception
			.sorted(combinedComparator)
			.forEach(System.out::println);
	}
	
}

class Person {
	
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	
	public Person(int id, String firstName, String lastName, int age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
}

class DynamicPersonComparator implements Comparator<Person> {

	private MyComparator<Person> myComparator;
	
	public DynamicPersonComparator(MyComparator<Person> myComparator) {
		this.myComparator = myComparator;
	}

	@Override
	public int compare(Person p1, Person p2) {
		return myComparator.compare(p1, p2);
	}
	
}