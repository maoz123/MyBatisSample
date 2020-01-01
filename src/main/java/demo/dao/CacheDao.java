package demo.dao;

import demo.model.Person;

public interface CacheDao {
    Person getPersonById(int id);

    void insertPerson(Person person);
}
