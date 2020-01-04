package demo.dao;

import demo.model.Person;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PersonDao {
    public Person getPersonById(int id);

    void insertPerson(Person person);

    boolean updatePerson(Person person);

    void deletePersonById(int id);

    Person getPersonByIdAndName(int id, @Param("name") String name);

    Person getPersonByMap(Map<Object, Object> maps);

    Person getPersonInTableByIdAndName(String tableName, int id, @Param("name") String name);

    List<Person> getPersons(int id);

    Map<String, Object> getPersonInMap(int id);

    @MapKey("id")
    Map<Integer, Person> getPersonMaps(int id);

    Person getPersonSelfDefineResultMap(int id);

    List<Person> getAllPerson();
}
