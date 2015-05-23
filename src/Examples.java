import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by thomas on 23.05.15.
 */
public class Examples {

    List<Person> persons;

    public boolean allMatch() {
        return persons.stream()
                .allMatch(x -> x.getAge() > 18);
    }

    public boolean anyMatch() {
        return persons.stream()
                .anyMatch(x -> x.getCountry()
                        .equals("China"));
    }

    public Double avg() {
        return persons.stream().
                mapToInt(Person::getAge)
                .average().getAsDouble();
    }

    public long count() {
        return persons.stream()
                .filter(x -> x.getCountry().equals("China")).count();
    }

    public List<String> distinct() {
        return persons.stream()
                .map(Person::getCountry)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Person> filter() {
        return persons.stream()
                .filter(x -> x.gender.equals(Gender.MALE))
                .collect(Collectors.toList());
    }

    public Person findFirst() {
        Optional<Person> p = persons.stream().filter(x -> x.isMale()).findFirst();
        return p.get();
    }

    public Map<String, List<Person>> groupBy() {
        return persons.stream().
                collect(Collectors.groupingBy(Person::getCountry));
    }

    public Map<Gender, List<Person>> groupBy2() {
        return persons.stream().
                collect(Collectors.groupingBy(x -> (x.getGender())));
    }

    public Map<String, Map<Gender, List<Person>>> groupBy3() {
        return persons.stream().
                collect(Collectors.groupingBy(
                                Person::getCountry, Collectors.groupingBy(x -> x.getGender()))
                );

    }

    public List<Person> limit() {
        return persons.stream()
                .filter(x -> x.getEmail().contains("com"))
                .limit(3)
                .collect(Collectors.toList());
    }

    public List<String> map() {
        return persons.stream()
                .map(Person::getCountry)
                .collect(Collectors.toList());
    }

    public Integer max() {
        return persons.stream()
                .map(Person::getAge)
                .reduce(Integer::max).get();
    }

    public Integer min() {
        return persons.stream()
                .map(Person::getAge)
                .reduce(Integer::min).get();
    }

    public boolean noneMatch() {
        return persons.stream()
                .noneMatch(x -> x.getAge() > 18);
    }

    public Map<Boolean, List<Person>> partition() {
        return persons.stream()
                .collect(
                        Collectors.partitioningBy(p -> p.isMale())
                );
    }

    public List<Person> skip() {
        return persons.stream()
                .filter(x -> x.getEmail().contains("com"))
                .limit(3)
                .skip(2)
                .collect(Collectors.toList());
    }

    public List<Person> sort() {
        return persons.stream()
                .sorted((x, y) -> {
                    return x.getLast_name().compareTo(y.getLast_name());
                })
                .limit(5)
                .collect(Collectors.toList());
    }

    public Examples(List<Person> persons) {
        this.persons = persons;
    }
}
