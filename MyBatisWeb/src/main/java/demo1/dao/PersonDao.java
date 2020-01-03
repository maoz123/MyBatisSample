package demo1.dao;

import demo1.models.Person;

public interface PersonDao {
    //@Select(value = "select id, name from person where id = #{id}")
    Person getPersonById(int id);
}
