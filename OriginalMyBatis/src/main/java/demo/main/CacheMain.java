package demo.main;

import demo.dao.CacheDao;
import demo.model.Person;
import demo.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class CacheMain {
    public static void main(String[] args) throws IOException {
        SqlSession session = SqlSessionUtils.getSqlSession();
        try
        {
            CacheDao dao = session.getMapper(CacheDao.class);
            Person p1 = dao.getPersonById(2);
            System.out.println(p1.getId()+ " : "  + p1.getName());

            //sout
            //session.close();

            //SqlSession session2 = factory.openSession();
            //CacheDao dao2 = session2.getMapper(CacheDao.class);
//            Person p = new Person();
////            p.setId(11);
////            p.setName("rom");
////            p.setAddress("hangzhou");
////            p.setEmailGb("gb.com");
////            p.setHomeId(3);
////            dao.insertPerson(p);
            session.clearCache();
            Person p2 = dao.getPersonById(2);
            System.out.println(p2.getId()+ " : "  + p2.getName());
            //session2.close();
        }
        finally {
            session.close();
        }
    }
}
