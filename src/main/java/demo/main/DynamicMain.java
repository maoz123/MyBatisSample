package demo.main;

import demo.dao.DynamicSqlDao;
import demo.model.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DynamicMain {
    public static void main(String[] args) throws IOException {
        String path = "config/mybatis.xml";

        InputStream is = Resources.getResourceAsStream(path);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();

        try
        {
            //dunamic query
//            DynamicSqlDao dao = session.getMapper(DynamicSqlDao.class);
//            List<Person> persons = dao.queryDynamic(2, "");
            DynamicSqlDao dao = session.getMapper(DynamicSqlDao.class);
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(8);
            List<Person> persons = dao.queryPersonInRange(list);
            for (Person p : persons)
            {
                System.out.println(p.getId() + " : " + p.getName() + " : " + p.getAddress() + " : " +p.getEmailGb());
            }
            session.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }

    }
}
