package people;

import org.springframework.hateoas.Identifiable;
import org.springframework.hateoas.core.Relation;

import java.util.Random;

/**
 * @author WH1707008
 * @date 2018/7/12 14:41
 * Description:
 */
@Relation(value = "person", collectionRelation = "persons")
public class Person extends AbstractEntity{

    private String firstName;
    private String lastName;


    public Person() {

    }

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
