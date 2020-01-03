package demo.dao;

import demo.model.Home;

import java.util.List;

public interface PersonsAndHomesDao {
    List<Home> getManyHomeAndMaps(int homeId);
}
