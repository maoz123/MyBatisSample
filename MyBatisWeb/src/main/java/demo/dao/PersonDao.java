package demo.dao;

import demo.models.Person;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface PersonDao {
    //@Select(value = "select id, name from person where id = #{id}")
    Person getPersonById(int id);
}
