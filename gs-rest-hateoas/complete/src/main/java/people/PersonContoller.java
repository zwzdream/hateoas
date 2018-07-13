package people;

import hello.GreetingController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * @author WH1707008
 * @date 2018/7/12 11:18
 * Description:
 */
@RestController
@RequestMapping(value = "/people")
public class PersonContoller {
    List<PersonResource> personResourceList=new ArrayList<>();

    public void init(){
        personResourceList.add(new PersonResource("org", "springframework"));
        personResourceList.add(new PersonResource("org", "apache"));
        personResourceList.add(new PersonResource("org", "hibernate"));
        personResourceList.add(new PersonResource("org", "slf4j"));
    }


    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<?> showAll(){
        init();

        for(PersonResource resource: personResourceList){
            updatePollResourceWithLinks(resource);
        }

       return new ResponseEntity<>(personResourceList,HttpStatus.OK);
    }

    @RequestMapping(value="/{lastName}", method=RequestMethod.GET)
    public ResponseEntity<PersonResource> show(@PathVariable String lastName) {
        PersonResource personResource=new PersonResource("org", lastName);
            updatePollResourceWithLinks(personResource);


        return new ResponseEntity<> (personResource, HttpStatus.OK);
    }

    @RequestMapping(value="/org", method=RequestMethod.GET)
    public ResponseEntity<Resources<PersonResource>> scanFirstName() {
        Link link=linkTo(methodOn(PersonContoller.class).scanFirstName()).withSelfRel();
       Resources<PersonResource> personResources=new Resources<PersonResource>(
               new PersonResourceAssembler(PersonContoller.class, PersonResource.class)
               .toResources(new ArrayList<Person>(){{add(new Person("org"));}}),link);

        return new ResponseEntity<> (personResources, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/read",method = RequestMethod.GET)
    public  PersonResource readPerson(@PathVariable Long id){
        return new PersonResourceAssembler(PersonContoller.class,
                PersonResource.class).toResource(new Person("zwz","dream"));
    }

    private void updatePollResourceWithLinks( PersonResource personResource) {
        personResource.add(
                linkTo(methodOn(PersonContoller.class)
                        .show(personResource.getLastName()))
                        .withSelfRel());
        personResource.add(
                linkTo(methodOn(GreetingController.class)
                .greeting(personResource.getFirstName()+"."+personResource.getLastName()))
                .withRel("greeting"));
        personResource.add(
                linkTo(methodOn(PersonContoller.class)
                .scanFirstName())
                        .withRel("first-name"));

    }

}
