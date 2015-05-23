import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by thomas on 23.05.15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        TestDataGenerator generator = new TestDataGenerator();
        List<Person> persons = generator.getTestData();
        Examples examples = new Examples(persons);
        //Stream<String> str = Stream.of("Peter", "Paul", "Mary");
        //System.out.print(str.collect(Collectors.joining(",")));
        //str.forEach(System.out::println);
        //IntStream.range(0,10).forEach(System.out::println);
        //System.out.println(IntStream.range(0,100).reduce(Integer::sum).getAsInt());
        //System.out.println(IntStream.rangeClosed(0,100).reduce(Integer::sum).getAsInt());
        //System.out.print(Stream.iterate(0, x ->x+1).limit(100).reduce(Integer::sum).get());
        //Stream.generate(Math::random).limit(10).forEach(System.out::println);
        //System.out.print(examples.count());
        //Files.lines(Paths.get("testdata.csv"), Charset.defaultCharset()).forEach(System.out::println);
        //examples.sort().forEach(x -> System.out.println(x.getLast_name()));
        //System.out.println(examples.findFirst().getFirst_name());
        Map<String, Map<Gender, List<Person>>> countries = examples.groupBy3();
        countries.keySet().forEach(
                country -> {
                    Map<Gender, List<Person>> pers = countries.get(country);
                    pers.keySet().forEach(
                            p -> {
                                pers.get(p).stream().forEach(k -> {
                                    System.out.println(String.format("Country: %s, %s %s (%s)", country, k.getFirst_name(), k.getLast_name(), k.getGender()));
                                });
                            }
                    );
                }
        );
    }

}
