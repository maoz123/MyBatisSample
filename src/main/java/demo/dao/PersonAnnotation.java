package demo.dao;

import demo.model.Person;
import org.apache.ibatis.annotations.Select;

public interface PersonAnnotation {
    @Select("select * from person where id=#{id}")
    Person getPerson(int id);
}
