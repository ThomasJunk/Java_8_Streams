/**
 * Created by thomas on 23.05.15.
 */
public class Person {

    int id;
    String first_name;
    String last_name;
    String email;
    String country;
    String ip_address;
    Gender gender;
    int age;
    String language;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean isMale(){
        return this.getGender().equals(Gender.MALE);
    };

    public Person(int id, String first_name, String last_name, String email, String country, String ip_address, Gender gender, int age, String language) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.country = country;
        this.ip_address = ip_address;
        this.gender = gender;
        this.age = age;
        this.language = language;
    }
}
