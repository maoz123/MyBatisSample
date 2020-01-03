package demo.dao;

import demo.model.Home;
import demo.model.Person;
import demo.model.PersonHome;

import java.util.List;

public interface PersonHomeDao {
    PersonHome getPersonHome(int id);

    Home selectHome(int homeId);

    Home getHomePersons(int homeId);

    Home getHome(int homeId);

    Person selectPerson(int id);

    List<Home> getManyHomeAndMaps(int homeId);
}
