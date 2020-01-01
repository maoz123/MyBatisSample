package demo.dao;

import demo.model.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSqlDao {
    List<Person> queryDynamic(@Param("homeId") int homeId, @Param("name") String name);

    List<Person> queryPersonInRange(@Param("ids") List<Integer> ids);
}
