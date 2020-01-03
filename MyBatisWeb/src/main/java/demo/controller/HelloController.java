package demo.controller;

import demo.models.Person;
import demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    public PersonService personService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello()
    {
        Person p = personService.getPersonById(1);
        return p.getName();
    }
}
