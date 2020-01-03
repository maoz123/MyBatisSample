package demo.service;

import demo.dao.PersonDao;
import demo.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    public PersonDao dao;

    public Person getPersonById(int id)
    {
        return dao.getPersonById(id);
    }
}
