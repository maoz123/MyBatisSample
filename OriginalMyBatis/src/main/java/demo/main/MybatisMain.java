package demo.main;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import demo.dao.PersonDao;
import demo.model.Person;
import demo.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/*
mybatis 允许增加返回值，支持Integer,Long. boolean， void
参数的只和影响的行数有关。

PageHelper分页 ：
拦截Executor的query方法，首先拿到sql语句，去掉order by等语句，然后执行总数查询
执行完总数查询之后执行分页查询，分页查询就是构造新的sql，在后面加上limit ? ?。
然后将执行sql的参数传到statement当中，传入参数，构造成新的sql语句执行查询任务，然后将结果返回。

 */



public class MybatisMain {
    public static void main(String[] args) throws IOException {
        SqlSession session = SqlSessionUtils.getSqlSession();

        try
        {
            PersonDao dao = session.getMapper(PersonDao.class);
            //dao.deletePersonById(1);
            Person p = new Person();
            //p.setId(3);
            p.setName("michael");
            p.setAddress("ftl");
            p.setEmailGb("citrix.com");

            Page page = PageHelper.startPage(3,2);
            List<Person> persons  = dao.getAllPerson();
            for (Person pe: persons
                 ) {
                System.out.println(pe.getId() + " : " + pe.getName() + " : " + pe.getAddress());
            }
            PageInfo info = new PageInfo(persons, 2);
            System.out.println(info.isIsLastPage());
            System.out.println(info.isIsFirstPage());
            System.out.println(info.getTotal());
            for (int num :info.getNavigatepageNums()
                 ) {
                System.out.println(num);
            }
            //System.out.println(info.getNavigatepageNums());
//            System.out.println(page.getTotal());
//            System.out.println(page.getPageNum());

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
