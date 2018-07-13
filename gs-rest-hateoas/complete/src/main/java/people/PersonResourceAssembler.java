package people;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

/**
 * @author WH1707008
 * @date 2018/7/12 14:38
 * Description:
 */
public class PersonResourceAssembler extends ResourceAssemblerSupport<Person,PersonResource> {

    public PersonResourceAssembler(Class<?> controllerClass, Class<PersonResource> resourceType) {
        super(controllerClass, resourceType);
    }

    @Override
    public PersonResource toResource(Person person) {
        PersonResource resource=createResourceWithId(person.getFirstName(), person);
        return resource;
    }

    @Override
    protected PersonResource instantiateResource(Person entity) {
        return super.instantiateResource(entity);
    }
}


