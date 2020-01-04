package demo.main;

import demo.dao.DynamicSqlDao;
import demo.model.Person;
import demo.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DynamicMain {
    public static void main(String[] args) throws IOException {
        SqlSession session = SqlSessionUtils.getSqlSession();

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
