import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thomas on 23.05.15.
 */
public class TestDataGenerator {

    private final String testDataCsv = "testdata.csv";
    List<Person> testData = new ArrayList<>();


    private String loadTestdata() throws IOException {
        return new String(Files.readAllBytes(Paths.get(testDataCsv)));
    }

    private void generateTestData() throws IOException {
        Arrays.stream(loadTestdata()
                .split("\n"))
                .forEach(
                        x -> {
                            String[] values = x.split(",");
                            testData.add(
                                    new Person(
                                            Integer.parseInt(values[0]), values[1], values[2],
                                            values[3], values[4], values[5],
                                            Gender.valueOf(values[6].toUpperCase()),
                                            Integer.parseInt(values[7]), values[8]
                                    ));
                        });
    }

    public List<Person> getTestData() {
        return testData;
    }

    public TestDataGenerator() {
        try {
            generateTestData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
