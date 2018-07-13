package people;

import org.springframework.hateoas.Identifiable;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;

/**
 * @author WH1707008
 * @date 2018/7/12 11:20
 * Description:
 */
public class PersonResource extends ResourceSupport {

    private String firstName;
    private String lastName;

    public  PersonResource(){

    }

    public PersonResource(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /*    public PersonResource(String firstName) {
        this.firstName = firstName;
    }

    public PersonResource(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }*/

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }



    @Override
    public String toString() {
        return
                "firstName" + firstName +
                "lastName=" + lastName  +
                        super.toString();
    }
}
