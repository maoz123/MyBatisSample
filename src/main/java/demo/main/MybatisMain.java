package demo.main;

import demo.dao.PersonDao;
import demo.model.Person;
import demo.dao.PersonAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
mybatis 允许增加返回值，支持Integer,Long. boolean， void
参数的只和影响的行数有关。

 */

public class MybatisMain {
    public static void main(String[] args) throws IOException {
        String path = "config/mybatis.xml";
        InputStream stream = Resources.getResourceAsStream(path);

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);

        //如果openSession没有参数，就不会自动提交，因此SQl语句就不work
        SqlSession session = factory.openSession();

        try
        {
            PersonDao dao = session.getMapper(PersonDao.class);
            //dao.deletePersonById(1);
            Person p = new Person();
            //p.setId(3);
            p.setName("michael");
            p.setAddress("ftl");
            p.setEmailGb("citrix.com");

            //update
            //boolean result = dao.updatePerson(p);
            //System.out.println(result);

            //insert
            //dao.insertPerson(p);
            //System.out.println(p.getId());

            //delete
            //dao.deletePersonById(1);

            //query
            //Person person = dao.getPersonById(1);
            //Person person = session.selectOne("demo.model.PersonMapper.selectPerson", 1);
            //System.out.println(person.name + " ： "+ person.address + " : " + person.getEmailGb());

            //query by id and name
//            Person person = dao.getPersonByIdAndName(3, "tom");
//            System.out.println(person.getId() + " : "+ person.getAddress() + " : " + person.getName());

            //query with specify table name
//            Person person = dao.getPersonInTableByIdAndName("person", 3 , "tom");
//            System.out.println(person.getId() + " : " + person.getAddress() + " : " + person.getName());

            //query by id and name
//            Map<Object, Object> map = new HashMap<Object, Object>();
//            map.put("id", 9);
//            map.put("name", "michael");
//            Person person = dao.getPersonByMap(map);
//            System.out.println(person.getId() + " : "+ person.getAddress() + " : " + person.getName());

            //query list
//            List<Person> persons = dao.getPersons(2);
//            for (Person pe: persons
//                 ) {
//                System.out.println(p);
//            }
//            System.out.println(persons.size());

            //query person to maps
//            Map<String, Object> map = dao.getPersonInMap(3);
//            for (Map.Entry entry : map.entrySet())
//            {
//                System.out.println(entry.getKey() + "  : " + entry.getValue());
//            }

            //query person to maps
//            Map<Integer, Person> maps = dao.getPersonMaps(3);
//            for (Map.Entry<Integer, Person> entry : maps.entrySet())
//            {
//                System.out.println(entry.getKey()  + " : " + entry.getValue());
//            }

            //get person with result map
//            Person per = dao.getPersonSelfDefineResultMap(3);
//            System.out.println(per.getId() + " : " + per.getName() + " : " + per.getAddress() + " : " + per.getEmailGb());


            session.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
}
