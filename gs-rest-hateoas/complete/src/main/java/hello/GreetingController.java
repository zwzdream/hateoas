package hello;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/greeting")
    public HttpEntity<Greeting> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        Link link=linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel();
        System.out.println(link);
        System.out.println(link.getHref());
        System.out.println(link.getRel());
        greeting.add(link);
        System.out.println(greeting);
        System.out.println(greeting.getId());
        System.out.println(greeting.getLinks());
        System.out.println(greeting.getContent());

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }


}
